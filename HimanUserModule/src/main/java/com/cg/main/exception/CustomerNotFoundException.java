package com.cg.main.exception;


public class CustomerNotFoundException extends Exception{
	
	CustomerNotFoundException() {}
	
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}

}
