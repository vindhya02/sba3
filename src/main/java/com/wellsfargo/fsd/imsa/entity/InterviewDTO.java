package com.wellsfargo.fsd.imsa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class InterviewDTO implements Serializable{
	
	@Min(value = 1,message = "Interview id can not be zero or negative")
	@JsonProperty(value = "interviewid")
	private Integer interviewid;
	
	@Size(min = 3,max=30,message = "interviewname must be of 3 to 30 chars in length")
	@NotNull(message = "interviewname can not be omitted")
	@NotBlank(message = "interviewname can not be omitted")
	@JsonProperty(value = "interviewname")
	private String interviewname;
	
	
	@Size(min = 5,max=30,message = "interviewername must be of 5 to 30 chars in length")
	@NotNull(message = "interviewername can not be omitted")
	@NotBlank(message = "interviewername can not be omitted")
	@JsonProperty(value = "interviewername")
	private String interviewername;
		
	
	@Size(min = 5,max=30,message = "userskills must be of 5 to 30 chars in length")
	@NotNull(message = "userskills can not be omitted")
	@NotBlank(message = "userskills can not be omitted")
	@JsonProperty(value = "userskills")
	private String userskills;
	
	
	@Size(min = 5,max=100,message = "interviewstatus must be of 5 to 100 chars in length")
	@NotNull(message = "interviewstatus can not be omitted")
	@NotBlank(message = "interviewstatus can not be omitted")
	@JsonProperty(value = "interviewstatus")
	private String interviewstatus;
	
	
	@Size(min = 5,max=100,message = "remarks must be of 5 to 100 chars in length")
	@NotNull(message = "remarks can not be omitted")
	@NotBlank(message = "remarks can not be omitted")
	@JsonProperty(value = "remarks")
	private String remarks;
	
	@JsonProperty(value = "attendees")
	//@JsonIgnore
	private List<User> user;
	

	

	public InterviewDTO() {
		//left unimplemented
	}

	public InterviewDTO(
			Integer interviewid,
			String interviewname,
			String interviewername,
			String userskills,
			String interviewstatus,
			String remarks) {
		super();
		this.interviewid = interviewid;
		this.interviewname = interviewname;
		this.interviewername = interviewername;
		this.userskills = userskills;
		this.interviewstatus = interviewstatus;
		this.remarks = remarks;
	}
	

	public Integer getinterviewid() {
		return interviewid;
	}



	public String getInterviewername() {
		return interviewername;
	}



	public void setInterviewername(String interviewername) {
		this.interviewername = interviewername;
	}



	public String getUserskills() {
		return userskills;
	}



	public void setUserskills(String userskills) {
		this.userskills = userskills;
	}



	public String getInterviewstatus() {
		return interviewstatus;
	}



	public void setInterviewstatus(String interviewstatus) {
		this.interviewstatus = interviewstatus;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public void setinterviewid(Integer interviewid) {
		this.interviewid = interviewid;
	}

	public String getinterviewname() {
		return interviewname;
	}

	public void setinterviewname(String interviewname) {
		this.interviewname = interviewname;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> userList) {
		this.user = userList;
	}
	@Override
	public String toString() {
		return "Interview [interviewid=" + interviewid + ", interviewname=" + interviewname + ", interviewername="
				+ interviewername + ", userskills=" + userskills + ", interviewstatus=" + interviewstatus + ", remarks="
				+ remarks + "]";
	}


}
