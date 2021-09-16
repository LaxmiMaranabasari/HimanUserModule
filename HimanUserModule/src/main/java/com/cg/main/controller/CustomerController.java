package com.cg.main.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.cg.main.beans.Customer;
import com.cg.main.service.ICustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerServiceImpl icsi;
	
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer)
	{
		icsi.addCustomer(customer);
	}
	
	@DeleteMapping("/removeCustomer/{custId}")
	public Customer removeCustomer(@PathVariable String custId)
	{
		return icsi.removeCustomer(custId);
	}
	
	@PutMapping("/updateCustomer/{custId}")
	public Customer updateCustomer(@PathVariable String custId, @RequestBody Customer customer)
	{
		return icsi.updateCustomer(custId, customer);
	}
	
	@GetMapping("/getCustomer/{custId}")
	public Customer getCustomer(@PathVariable String custId)
	{
		return icsi.getCustomer(custId);
		
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers()
	{
		return icsi.getAllCustomers();
	}
	
}
