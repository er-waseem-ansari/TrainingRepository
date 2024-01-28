package com.hexaware.myexceptions;

public class AccountNumberInvalidException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

    public AccountNumberInvalidException() {
        super("Account number invalid");  
        this.message = "Account number invalid";
    }

    public AccountNumberInvalidException(String message) {
        super(message + ": Account number invalid");  
        this.message = message + ": Account number invalid"; 
    }
    public String getMessage() {
        return message;
    }
}
