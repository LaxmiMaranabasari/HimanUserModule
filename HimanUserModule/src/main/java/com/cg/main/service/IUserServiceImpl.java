package com.cg.main.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.repository.ICustomerRepositoryIntf;
import com.cg.main.repository.UserRepository;
import com.cg.main.beans.Customer;
import com.cg.main.beans.SigninStatus;
import com.cg.main.beans.User;
import com.cg.main.exception.*;
import java.util.List;

@Transactional
@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	UserRepository repository;
	@Autowired
	private ICustomerServiceImpl icsi;
	@Autowired
	private ICustomerRepositoryIntf cr;
	
	User user = new User();

	@Override
	public User addUser(User user) {	
		user.setStatus(SigninStatus.SIGNEDIN);
		Customer c = user.getUserId();
		c.setStatus(user);
		return repository.saveAndFlush(user);
	}

	@Override
	public User removeUser(String contactNo) {
		User deletedUser=null;
		try {
			deletedUser=repository.findById(contactNo).orElseThrow(()-> new UserNotFoundException("User not found"));
			if(deletedUser.getStatus().compareTo(SigninStatus.SIGNEDIN) == 0)
				repository.delete(deletedUser);
			else
				throw new NotLoggedInException("Please login to delete!!");
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
			//e.printStackTrace();
		}
	return deletedUser;
	}

	@Override
	public List<User> getalluser() {
		return (List<User>) repository.findAll();
	}
	
	@Override
	public User getUserById(String contactNo) {
		User u=null;
		try {
			u = repository.findById(contactNo).orElseThrow(()-> new UserNotFoundException("User not found"));
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
    public User signin(String contactNo, String password) {
		List<User> list = repository.findAll();
		boolean flag = false;
		try {
			for(User u : list) {
				if(u.getContactNo().equals(contactNo) && u.getPassword().equals(password)) {
					u.setStatus(SigninStatus.SIGNEDIN);
					Customer c = u.getUserId();
					c.setStatus(u);
					repository.save(u);
					user = repository.findById(u.getContactNo()).get();
					flag = true;
				} else {
					flag = false;
					throw new InvalidCredentials("Invalid Credentials");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(flag)
			return user;
		return null;
	}
	

	@Override
	public User signout(String contactNo) {
		List<User> list = repository.findAll();
		boolean flag = false;
		try {
			for(User u : list) {
				if(u.getContactNo().equals(contactNo)) {
					u.setStatus(SigninStatus.SIGNEDOUT);
					Customer c = u.getUserId();
					c.setStatus(u);
					repository.save(u);
					user = repository.findById(u.getContactNo()).get();
					flag = true;
				} else {
					flag = false;
					throw new InvalidCredentials("Invalid Credentials");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(flag)
			return user;
		return null;
	}
	
	@Override
	public User updateUser(String contactNo, String newPassword) {
		User temp=null;
		try {
			temp = repository.findById(contactNo).orElseThrow(()-> new UserNotFoundException("No user found with this contactNo: "+user.getContactNo()));
			if(temp.getStatus().compareTo(SigninStatus.SIGNEDIN) == 0)
			{
				temp.setPassword(newPassword);
				Customer c = temp.getUserId();
				c.setStatus(temp);
				return repository.saveAndFlush(temp);
			}
			else
			{
				throw new NotLoggedInException("Please login to update values!!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}