package com.cg.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Admin;
import com.cg.main.beans.Customer;
import com.cg.main.beans.SigninStatus;
import com.cg.main.beans.User;
import com.cg.main.exception.AdminNotFoundException;
import com.cg.main.exception.InvalidCredentials;
import com.cg.main.exception.NotLoggedInException;
import com.cg.main.repository.AdminRepository;

@Service

public class IAdminServiceImpl implements IAdminService{
	
	@Autowired
	private AdminRepository repository;
	
	private Admin a = new Admin();

	@Override
	public Admin signIn(String contactNo, String password) {
		boolean flag = false;
		try {
		if(a.getContactNo().equals(contactNo) && a.getPassword().equals(password)) {
				a.setStatus(SigninStatus.ADMININ);
				repository.save(a);
				flag = true;
			}
		else{
			flag = false;
			a.setStatus(SigninStatus.ADMINOUT);
			throw new InvalidCredentials("Invalid Credentials");	
		}
		}
		catch(InvalidCredentials i) {
			System.out.println(i);
		}
		if(flag)
			return a;
		return null;
	}
	
	@Override
	public Admin signout(String contactNo) {
		List<Admin> list = repository.findAll();
		boolean flag = false;
		try {
			for(Admin u : list) {
				if(u.getContactNo().equals(contactNo)) {
					u.setStatus(SigninStatus.ADMINOUT);
					repository.save(u);
					a = repository.findById(u.getContactNo()).get();
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
			return a;
		return null;
	}
	
	/*@Override
	public String signOut() {
		if(a.getStatus().equals(SigninStatus.ADMININ)) {
			a.setStatus(SigninStatus.ADMINOUT);
			repository.save(a);	
		} else {
			return "You need to login";
		}
		return "Logged out";
	}*/

	@Override
	public Admin updateAdmin(String contactNo, Admin admin){
		Admin temp=null;
		try {
			temp = repository.findById(contactNo).orElseThrow(()-> new AdminNotFoundException("No admin found with this contactNo: "+a.getContactNo()));
			if(temp.getStatus().compareTo(SigninStatus.ADMININ) == 0)
				{
				temp.setContactNo(a.getContactNo());
				 temp.setPassword(a.getPassword());
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
	
	/*@Override
	public Admin removeAdmin(String contactNo) {
		Admin deletedAdmin=null;
		try {
			deletedAdmin=repository.findById(contactNo).orElseThrow(()-> new AdminNotFoundException("Admin not found"));
			repository.delete(deletedAdmin);
		} catch (AdminNotFoundException e) {
			System.out.println(e.toString());
			//e.printStackTrace();
		}
	return deletedAdmin;
	}*/
}
