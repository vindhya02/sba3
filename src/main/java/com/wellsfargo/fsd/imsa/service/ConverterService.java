package com.wellsfargo.fsd.imsa.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.imsa.entity.Interview;
import com.wellsfargo.fsd.imsa.entity.InterviewDTO;
import com.wellsfargo.fsd.imsa.entity.User;
import com.wellsfargo.fsd.imsa.entity.UserDTO;

@Component
public class ConverterService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public InterviewDTO convertToDto(Interview interviewobj)
	{
		return modelMapper.map(interviewobj, InterviewDTO.class);
	}
		
	public Interview convertToEntity(InterviewDTO interviewdto)
	{
		return modelMapper.map(interviewdto, Interview.class);
	}

}
