package tn.gestionstock.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{
	@Getter
	private ErrorCodes errorCode;

	public EntityNotFoundException(String message) {
		super(message);
	}
	public EntityNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	public EntityNotFoundException(String message,Throwable cause,ErrorCodes code) {
		super(message,cause);
		this.errorCode=code;
	}
	public EntityNotFoundException(String message,ErrorCodes code) {
		super(message);
		this.errorCode=code;
	}
}
