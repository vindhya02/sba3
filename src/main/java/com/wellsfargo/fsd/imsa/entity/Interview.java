package com.wellsfargo.fsd.imsa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="interviews")
public class Interview implements Serializable{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="interviewid")
	private Integer interviewid;
	
	@Column(name="interviewname")
	private String interviewname;
	
	@Column(name="interviewername")
	private String interviewername;
		
	@Column(name="userskills")
	private String userskills;
	
	@Column(name="interviewstatus")
	private String interviewstatus;
	
	@Column(name="remarks")
	private String remarks;
	 
	//CascadeType.MERGE, CascadeType.PERSIST, 
	 @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST})
	 @JoinTable(name = "interview_attendees", joinColumns = { @JoinColumn(name = "interviewid") }, inverseJoinColumns = {
	            @JoinColumn(name = "userid") })
	    private List<User> attendees;
	 
	 
	public Interview() {
		//left unimplemented
	}

	public Interview(
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
	
	public void addUser(User user) {
        this.attendees.add(user);
        user.getInterviews().add(this);
    }
	
	public List<User> getUser()
	{
		return attendees;
	}
 
   // public void removeCourse(Course course) {
    //    this.getCourses().remove(course);
     //   course.getStudents().remove(this);
   // }

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
	
	 public void removeUser(User user) {
		 this.attendees.remove(user);
		 user.getInterviews().remove(this);
	 }
	 
	@Override
	public String toString() {
		return "Interview [interviewid=" + interviewid + ", interviewname=" + interviewname + ", interviewername="
				+ interviewername + ", userskills=" + userskills + ", interviewstatus=" + interviewstatus + ", remarks="
				+ remarks + "]";
	}

}
