package com.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.main.beans.Customer;

@Repository
public interface ICustomerRepositoryIntf extends JpaRepository<Customer,String> {
	 
}
