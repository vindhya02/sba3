package com.wellsfargo.fsd.imsa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.imsa.entity.Interview;
import com.wellsfargo.fsd.imsa.entity.InterviewDTO;
import com.wellsfargo.fsd.imsa.entity.User;
import com.wellsfargo.fsd.imsa.entity.UserDTO;
import com.wellsfargo.fsd.imsa.exception.InvException;
import com.wellsfargo.fsd.imsa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService UserService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() throws InvException{
		return new ResponseEntity<List<UserDTO>>(UserService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("userid") int userid) throws InvException{
		ResponseEntity<UserDTO> response=null;
		
		UserDTO UserDTO = UserService.getUserById(userid); 
		
		if(UserDTO!=null) {
			response =new ResponseEntity<UserDTO>(UserDTO, HttpStatus.OK); 
		}else {
			response =new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable("userid") int userid) throws InvException{
		ResponseEntity<String> response=null;
		
		boolean isDeleted = UserService.deleteUser(userid);
		
		if(isDeleted) {		
			response =new ResponseEntity<String>("Id deleted!",HttpStatus.OK); 
		}else {
			response =new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO UserDTO) throws InvException{
		
		return new ResponseEntity<User>(UserService.add(UserDTO),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserDTO UserDTO) throws InvException{
		return new ResponseEntity<User>(UserService.save(UserDTO),HttpStatus.OK);
	}
	
}
