package com.cg.main.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Validated
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "status")
@Table(name="UserModule")
public class User {

@Id
@Column
@NotNull(message="Enter Contact Number")
private String contactNo;

@Column
@NotNull(message="Enter password")
private String password;

@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name = "customer", referencedColumnName = "id")
private Customer userId;

@Enumerated
private SigninStatus status;

public User() {
	super();
}

public User(String contactNo, String password, Customer userId) {
	super();
	this.contactNo = contactNo;
	this.userId = userId;
	this.password = password;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public Customer getUserId() {
	return userId;
}

public void setUserId(Customer userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public SigninStatus getStatus() {
	return status;
}

public void setStatus(SigninStatus status) {
	this.status = status;
}
}

