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
import com.wellsfargo.fsd.imsa.entity.UserDTO;
import com.wellsfargo.fsd.imsa.entity.InterviewDTO;
import com.wellsfargo.fsd.imsa.exception.InvException;
import com.wellsfargo.fsd.imsa.service.InterviewService;
import com.wellsfargo.fsd.imsa.service.UserService;

@RestController
@RequestMapping("/interview")
public class InterviewsRestController {

	@Autowired
	private InterviewService InterviewService;
	
	@GetMapping
	public ResponseEntity<List<InterviewDTO>> getAllInterviews() throws InvException{
		return new ResponseEntity<List<InterviewDTO>>(InterviewService.getAllInterviews(), HttpStatus.OK);
	}
	
	@GetMapping("/interviewname/{interviewname}")
	public ResponseEntity<List<InterviewDTO>> findAllByInterviewName(@PathVariable("interviewname") String interviewname) throws InvException{
		List<InterviewDTO> response = InterviewService.findAllByInterviewName(interviewname);
		if(response.isEmpty()) {
			throw new InvException("interviewname does not exists! Give correct value");
		}else
		{
			return new ResponseEntity<List<InterviewDTO>>(InterviewService.findAllByInterviewName(interviewname), HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping("/interviewername/{interviewername}")
	public ResponseEntity<List<InterviewDTO>> findAllByInterviewerName(@PathVariable("interviewername") String interviewername) throws InvException{
		List<InterviewDTO> response = InterviewService.findAllByInterviewerName(interviewername);
		if(response.isEmpty()) {
			throw new InvException("interviewer-name does not exists! Give correct value");
		}else
		{
		return new ResponseEntity<List<InterviewDTO>>(InterviewService.findAllByInterviewerName(interviewername), HttpStatus.OK);}
	}
	
	@GetMapping("/{interviewid}")
	public ResponseEntity<InterviewDTO> getInterview(@PathVariable("interviewid") int interviewid) throws InvException{
		ResponseEntity<InterviewDTO> response=null;
		
		InterviewDTO InterviewDTO = InterviewService.getInterviewById(interviewid); 
		
		if(InterviewDTO!=null) {
			response =new ResponseEntity<InterviewDTO>(InterviewDTO, HttpStatus.OK); 
		}else {
			response =new ResponseEntity<InterviewDTO>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@GetMapping("/totalcount")
	public ResponseEntity<Integer> getAllInterviewsTotal() throws InvException{
		List<InterviewDTO> InterviewList = InterviewService.getAllInterviews();
		return new ResponseEntity<Integer>(InterviewList.size(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{interviewid}")
	public ResponseEntity<String> deleteInterview(@PathVariable("interviewid") int interviewid) throws InvException{
		ResponseEntity<String> response=null;
		
		boolean isDeleted = InterviewService.deleteInterview(interviewid);
		
		if(isDeleted) {		
			response =new ResponseEntity<String>("Id deleted!",HttpStatus.OK); 
		}else {
			response =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@PostMapping
	public ResponseEntity<Interview> createInterview(@Valid @RequestBody InterviewDTO InterviewDTO) throws InvException{
		
		return new ResponseEntity<Interview>(InterviewService.add(InterviewDTO),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Interview> updateInterview(@Valid @RequestBody InterviewDTO InterviewDTO) throws InvException{
		return new ResponseEntity<Interview>(InterviewService.save(InterviewDTO),HttpStatus.OK);
	}
	
	
	@PutMapping("update/{interviewid}/{status}")
	public ResponseEntity<InterviewDTO> getInterview(@PathVariable("interviewid") int interviewid, @PathVariable("status") String status) throws InvException{
		ResponseEntity<InterviewDTO> response=null;
		
		InterviewDTO InterviewDTO = InterviewService.getInterviewById(interviewid); 
		if(InterviewDTO!=null) {
			InterviewDTO.setInterviewstatus(status);
			InterviewService.save(InterviewDTO);
			response =new ResponseEntity<InterviewDTO>(InterviewDTO, HttpStatus.OK); 
		}else {
			response =new ResponseEntity<InterviewDTO>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	
	@PutMapping("addattendee/{interviewid}/{userid}")
	public ResponseEntity<Interview> addAttendee(@PathVariable("interviewid") int interviewid, @PathVariable("userid") int userid) throws InvException{
		    ResponseEntity<Interview> response=null;
			response =new ResponseEntity<Interview>(InterviewService.addInterviewAttendee(interviewid, userid), HttpStatus.OK); 
			return response;
	}
	
	@GetMapping("showattendees/{interviewid}")
	public ResponseEntity<InterviewDTO> showattendees(@PathVariable("interviewid") int interviewid) throws InvException{
		ResponseEntity<InterviewDTO> response=null;
		
		InterviewDTO InterviewDTO = InterviewService.showInterviewAttendees(interviewid);
				
		if(InterviewDTO!=null) {
			response =new ResponseEntity<InterviewDTO>(InterviewDTO, HttpStatus.OK); 
		}else {
			response =new ResponseEntity<InterviewDTO>(HttpStatus.NOT_FOUND);
		}
		
		return response;	
	}
	
	
	
}
