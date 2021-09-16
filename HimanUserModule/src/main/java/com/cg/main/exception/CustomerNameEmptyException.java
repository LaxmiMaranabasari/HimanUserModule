package com.cg.main.exception;


public class CustomerNameEmptyException extends Exception{
	
	CustomerNameEmptyException() {}
	
	public CustomerNameEmptyException(String msg)
	{
		super(msg);
	}

}
