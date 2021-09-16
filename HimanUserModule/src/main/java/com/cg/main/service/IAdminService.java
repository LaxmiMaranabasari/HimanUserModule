package com.cg.main.service;

import com.cg.main.beans.Admin;
import com.cg.main.beans.User;
public interface IAdminService {
	//public String signOut();
	public Admin signIn(String contactNo, String password);
	public Admin updateAdmin(String contactNo, Admin admin);
	//public Admin removeAdmin(String contactNo);
	//List<BookingDetails> getAllBookings();
    //List<BookingDetails> getBookingsByUser(Integer id);
	public Admin signout(String contactNo);
	
	
}
