package tn.gestionstock.exception;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException{
	@Getter
	private ErrorCodes errorCode;
	@Getter
	private List<String> errors;
	public InvalidEntityException(String message) {
		super(message);
	}
	public InvalidEntityException(String message,Throwable cause) {
		super(message,cause);
	}
	public InvalidEntityException(String message,Throwable cause,ErrorCodes code) {
		super(message,cause);
		this.errorCode=code;
	}
	public InvalidEntityException(String message,ErrorCodes code) {
		super(message);
		this.errorCode=code;
	}
	public InvalidEntityException(String message,Throwable cause,ErrorCodes code,List<String> errors) {
		super(message);
		this.errorCode=code;
		this.errors=errors;
}
}
