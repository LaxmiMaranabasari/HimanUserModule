package com.cg.main.beans;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private String userId = "admin123";
	private String password = "Admin@123";
	private String contactNo = "1234567890";
	
	@Enumerated
	private SigninStatus status;
		
	public Admin() {}

	public Admin(String userId, String password, String contactNo, SigninStatus status) {
		super();
		this.userId = userId;
		this.password = password;
		this.contactNo = contactNo;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public SigninStatus getStatus() {
		return status;
	}

	public void setStatus(SigninStatus status) {
		this.status = status;
	}

	

}
