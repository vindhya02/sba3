package com.wellsfargo.fsd.imsa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.imsa.dao.InterviewRepository;
import com.wellsfargo.fsd.imsa.dao.UserRepository;
import com.wellsfargo.fsd.imsa.entity.Interview;
import com.wellsfargo.fsd.imsa.entity.User;
import com.wellsfargo.fsd.imsa.entity.UserDTO;
import com.wellsfargo.fsd.imsa.exception.InvException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private InterviewRepository interviewRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional
	public User add(UserDTO Userdto) throws InvException {
		if(Userdto!=null) {
			if(userRepo.existsById(modelMapper.map(Userdto, User.class).getuserid())) {
				throw new InvException("User id already used!");
			}
			
			userRepo.save(modelMapper.map(Userdto, User.class));
		}
		return modelMapper.map(Userdto, User.class);
	}

	@Override
	@Transactional
	public User save(UserDTO Userdto) throws InvException {
		if(Userdto!=null) {
			if(!userRepo.existsById(modelMapper.map(Userdto, User.class).getuserid())) {
				throw new InvException("User Not Found");
			}
			
			userRepo.save(modelMapper.map(Userdto, User.class));
		}
		return modelMapper.map(Userdto, User.class);
	}

	@Override
	@Transactional
	public boolean deleteUser(int userid) throws InvException {
		if(!userRepo.existsById(userid)) {
			throw new InvException("User Not Found");
		}
		User user = userRepo.findById(userid).orElse(null);
		List<Interview> interviewList = user.getInterviews();
		for(int i=0; i<interviewList.size();i++)
		{
			int id = interviewList.get(i).getinterviewid();
			Interview interview = interviewRepo.findById(id).orElse(null);
			interview.getUser().remove(user);
			interviewRepo.save(interview);
			
		}
		interviewList.clear();
		userRepo.save(user);
		userRepo.deleteById(userid);
		return true;
	}

	@Override
	public UserDTO getUserById(int userid) throws InvException {
		if(!userRepo.existsById(userid)) {
			throw new InvException("User Not Found");
		}
		User userentity =  userRepo.findById(userid).orElse(null);	
		return modelMapper.map(userentity, UserDTO.class);
	}

	@Override
	public List<UserDTO> getAllUsers() throws InvException {
		List<User> userlist =  userRepo.findAll();
		return userlist.stream().map(userentity -> modelMapper.map(userentity, UserDTO.class)).collect(Collectors.toList());
		
		
	}

	
}
