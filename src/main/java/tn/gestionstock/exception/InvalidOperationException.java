package tn.gestionstock.exception;

import java.util.List;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException{
	@Getter
	private ErrorCodes errorCode;
	@Getter
	private List<String> errors;
	public InvalidOperationException(String message) {
		super(message);
	}
	public InvalidOperationException(String message,Throwable cause) {
		super(message,cause);
	}
	public InvalidOperationException(String message,Throwable cause,ErrorCodes code) {
		super(message,cause);
		this.errorCode=code;
	}
	public InvalidOperationException(String message,ErrorCodes code) {
		super(message);
		this.errorCode=code;
	}
	public InvalidOperationException(String message,Throwable cause,ErrorCodes code,List<String> errors) {
		super(message);
		this.errorCode=code;
		this.errors=errors;
}

}
