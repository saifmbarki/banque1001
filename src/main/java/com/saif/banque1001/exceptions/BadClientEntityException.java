package com.saif.banque1001.exceptions;

public class BadClientEntityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public BadClientEntityException(String message) {
        super(message);
    }

    public BadClientEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
