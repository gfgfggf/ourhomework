package com.buaa.exception;

public class ExistsException extends RuntimeException {
	public ExistsException(){
		
	}
	public ExistsException(String message){
		super(message);
	}
}
