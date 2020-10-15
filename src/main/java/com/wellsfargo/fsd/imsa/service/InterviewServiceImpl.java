package com.wellsfargo.fsd.imsa.service;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.imsa.dao.InterviewRepository;
import com.wellsfargo.fsd.imsa.dao.UserRepository;
import com.wellsfargo.fsd.imsa.entity.Interview;
import com.wellsfargo.fsd.imsa.entity.InterviewDTO;
import com.wellsfargo.fsd.imsa.entity.User;
import com.wellsfargo.fsd.imsa.entity.UserDTO;
import com.wellsfargo.fsd.imsa.exception.InvException;


@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository InterviewRepo;
	
	@Autowired
	private UserRepository UserRepo;
	
	@Autowired
	private ConverterService converterService;
	
	@Override
	@Transactional
	public Interview add(InterviewDTO interview) throws InvException {
		if(interview!=null) {
			if(InterviewRepo.existsById(converterService.convertToEntity(interview).getinterviewid())) {
				throw new InvException("Interview id already used!");
			}
			
			InterviewRepo.save(converterService.convertToEntity(interview));
		}
		return converterService.convertToEntity(interview); 
	}

	@Override
	@Transactional
	public Interview save(InterviewDTO interview) throws InvException {
		InterviewRepo.save(converterService.convertToEntity(interview));
		return converterService.convertToEntity(interview);
	}

	@Override
	@Transactional
	public boolean deleteInterview(int interviewid) throws InvException {
		if(!InterviewRepo.existsById(interviewid)) {
			throw new InvException("Interview Not Found");
		}
		InterviewRepo.deleteById(interviewid);
		return true;
	}

	@Override
	public InterviewDTO getInterviewById(int interviewid) throws InvException {
		if(!InterviewRepo.existsById(interviewid)) {
			throw new InvException("Interview Not Found");
		}
		Interview interviewentity = InterviewRepo.findById(interviewid).orElse(null);
		return converterService.convertToDto(interviewentity);	
	}

	@Override
	public List<InterviewDTO> getAllInterviews() throws InvException {
		
		List<Interview> interviewlist =  InterviewRepo.findAll();
		return interviewlist.stream().map(converterService::convertToDto).collect(Collectors.toList());
	}
	

	@Override
	public List<InterviewDTO> findAllByInterviewName(String interviewname) throws InvException {
		List<Interview> interviewlist =  InterviewRepo.findAllByinterviewname(interviewname);
		return interviewlist.stream().map(converterService::convertToDto).collect(Collectors.toList());
	}

	@Override
	public List<InterviewDTO> findAllByInterviewerName(String interviewername) throws InvException {
		List<Interview> interviewerlist =  InterviewRepo.findAllByinterviewername(interviewername);
		return interviewerlist.stream().map(converterService::convertToDto).collect(Collectors.toList());
	}

	@Override
	public Interview addInterviewAttendee(int interviewid, int userid) throws InvException {
		
		// TODO Auto-generated method stub
		if(!InterviewRepo.existsById(interviewid)) {
			
			throw new InvException("Interview Not Found");
		}
		
		if(!UserRepo.existsById(userid)) {
			
			throw new InvException("User Not Found");
		}
		
		
		boolean flag=true;
		Interview interviewentity = InterviewRepo.findById(interviewid).orElse(null);
		User userdetails = UserRepo.findById(userid).orElse(null);
		List<User> userList = interviewentity.getUser();
			for(int i=0; i<userList.size();i++)
			{
				if(userdetails.getuserid().equals(userList.get(i).getuserid())){
					flag=false;
					
				}
						
			}
		if(flag) {
		interviewentity.addUser(userdetails);
		InterviewRepo.save(interviewentity);}else {throw new InvException("Attendee Exists!");}
		return interviewentity;
	}

	@Override
	public InterviewDTO showInterviewAttendees(int interviewid) throws InvException {
		
		if(!InterviewRepo.existsById(interviewid)) {
			
			throw new InvException("Interview Not Found");
		}
		
		Interview interviewentity = InterviewRepo.findById(interviewid).orElse(null);
		List<User> userList = interviewentity.getUser();
		if(userList.isEmpty())
		{
			throw new InvException("No Interview-Attendees Found");
		}
		else
		return converterService.convertToDto(interviewentity);
		
		
	}

	

	
	
}
