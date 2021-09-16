package com.cg.main.exception;

public class NotLoggedInException extends Exception {
	private static final long serialVersionUID = 1L;
	public NotLoggedInException() {}
	
	public NotLoggedInException(String msg) { super(msg); }
}
