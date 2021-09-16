package com.cg.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.exception.CustomerNameEmptyException;
import com.cg.main.exception.CustomerNotFoundException;
import com.cg.main.beans.Customer;
import com.cg.main.repository.ICustomerRepositoryIntf;

/*
{
    "userId" : "123456",
	"name" : "Neel",
	"email" : "xyz",
	"contactNo" : "123",
	"dob" : "2021-08-25", 
	"address" : {
        "doorNo" : "456",
        "street" : "aaa",
        "area" : "bbb",
        "city" : "mmm",
        "state" : "ccc",
        "pincode" : 400000
    }
}
*/

@Service
public class ICustomerServiceImpl implements ICustomerServiceIntf {
	@Autowired
	private ICustomerRepositoryIntf cr;
	
	public void ICustomerRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			if(customer.getName().isEmpty() || customer.getName().length() == 0) {
				throw new CustomerNameEmptyException("Customer Name is empty, Please provide proper Customer Name");
			}
			return cr.saveAndFlush(customer);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}

	}

	@Override
	public Customer removeCustomer(String custId) {
		// TODO Auto-generated method stub
		Customer customer = cr.findById(custId).get();
		cr.deleteById(custId);
		return customer;
	}

	@Override
	public Customer updateCustomer(String custId, Customer customer) {
		// TODO Auto-generated method stub
		cr.deleteById(custId);
		return cr.saveAndFlush(customer);
		
	}

	@Override
	public Customer getCustomer(String custId) {
		// TODO Auto-generated method stub
		try {
			return cr.findById(custId).orElseThrow(()->new CustomerNotFoundException("Customer Not Found, Please provide proper Customer ID"));
		}
		catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

}
