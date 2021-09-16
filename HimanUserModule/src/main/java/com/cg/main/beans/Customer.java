package com.cg.main.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
//customer table should know if they are logged in or not
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
@Table
public class Customer {
	@Id
    @Column(name="id")
	private String userId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address",referencedColumnName = "id")
    private Address address;
	
	@OneToOne(mappedBy = "userId")
	private User status;
		
	//private Order order;
	
	public Customer() {}
	
	public Customer(String userId, String name, String email, LocalDate dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}
	
	public User getStatus() {
		return status;
	}

	public void setStatus(User status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", address="
				+ address + "]";
	}



}
