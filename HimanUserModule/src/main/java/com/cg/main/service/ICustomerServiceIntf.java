package com.cg.main.service;

import java.util.List;

import com.cg.main.beans.Customer;

public interface ICustomerServiceIntf {
	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(String custId);
	public Customer updateCustomer(String custId, Customer customer);
	public Customer getCustomer(String custId);
	public List<Customer> getAllCustomers();
}