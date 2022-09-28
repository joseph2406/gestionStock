package tn.gestionstock.exception;

import lombok.Getter;

public class ListIsEmptyOrNullException extends RuntimeException{
	@Getter
	private ErrorCodes errorCode;

	public ListIsEmptyOrNullException(String message) {
		super(message);
	}
	public ListIsEmptyOrNullException(String message,Throwable cause) {
		super(message,cause);
	}
	public ListIsEmptyOrNullException(String message,Throwable cause,ErrorCodes code) {
		super(message,cause);
		this.errorCode=code;
	}
	public ListIsEmptyOrNullException(String message,ErrorCodes code) {
		super(message);
		this.errorCode=code;
	}
}
