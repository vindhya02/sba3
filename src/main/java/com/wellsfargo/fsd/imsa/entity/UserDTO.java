package com.wellsfargo.fsd.imsa.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO  implements Serializable {
	
	
	@NotNull(message = "User id  can not be omited")
	@Min(value = 1,message = "User id cna not be zeroor negative")
	@JsonProperty(value = "userid")
	private Integer userid;
	
	@NotNull(message = "firstname can not be omitted")
	@NotBlank(message = "firstname can not be omitted")
	@Size(min = 5,max=30,message = "firstname must be of 5 to 30 chars in length")
	@JsonProperty(value = "firstname")
	private String firstname;
	
	@NotNull(message = "lastname can not be omitted")
	@NotBlank(message = "lastname can not be omitted")
	@Size(min = 3,max=25,message = "lastname must be of 3 to 25 chars in length")
	@JsonProperty(value = "lastname")
	private String lastname;
	
	//@Size(min = 5,max=20,message = "email must be of 5 to 20 chars in length")
	@NotNull(message = "email can not be omitted")
	@NotBlank(message = "email can not be omitted")
	@Email
	@JsonProperty(value = "email")
	private String email;

	@Size(min = 10,max=10,message = "mobile must be of 10 chars in length")
	@NotNull(message = "mobile can not be omitted")
	@NotBlank(message = "mobile can not be omitted")
	@JsonProperty(value = "mobile")
	private String mobile;
	
	
	public UserDTO() {
		//left unimplemented
	}

	

	public UserDTO(
			Integer userid,
			 String firstname,
			 String lastname,
			 String email,
			String mobile) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public Integer getuserid() {
		return userid;
	}

	public void setuserid(Integer userid) {
		this.userid = userid;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	
	
}
