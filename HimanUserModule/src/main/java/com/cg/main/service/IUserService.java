package com.cg.main.service;

import java.util.List;

import com.cg.main.beans.User;
import com.cg.main.exception.UserNotFoundException;

public interface IUserService {
	public User addUser(User user);
	public List<User> getalluser();
	public User getUserById(String contactNo);
	public User removeUser(String contactNo) throws UserNotFoundException;
	public User updateUser(String contactNo, String newPassword);
	public User signin(String contactNo, String password);
	public User signout(String contactNo);
	}


