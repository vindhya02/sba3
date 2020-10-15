package com.wellsfargo.fsd.imsa.service;

import java.util.List;

import com.wellsfargo.fsd.imsa.entity.Interview;
import com.wellsfargo.fsd.imsa.entity.InterviewDTO;
import com.wellsfargo.fsd.imsa.exception.InvException;

public interface InterviewService {

	Interview add(InterviewDTO InterviewDTO) throws InvException;

	Interview save(InterviewDTO InterviewDTO) throws InvException;

	boolean deleteInterview(int id) throws InvException;

	InterviewDTO getInterviewById(int id) throws InvException;

	List<InterviewDTO> getAllInterviews() throws InvException;
	
	List<InterviewDTO> findAllByInterviewName(String interviewname) throws InvException;
	
	List<InterviewDTO> findAllByInterviewerName(String interviewername) throws InvException;
	
	Interview addInterviewAttendee(int interviewid, int userid) throws InvException;
	
	InterviewDTO showInterviewAttendees(int interviewid) throws InvException;
	
	
}
