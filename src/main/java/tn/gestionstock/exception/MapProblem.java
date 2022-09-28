package tn.gestionstock.exception;

import lombok.Getter;

public class MapProblem extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	private ErrorCodes errorCode;

	public MapProblem(String mess) {
		super(mess);
	}
	public MapProblem(String mess,ErrorCodes code) {
		super(mess);
		this.errorCode=code;
	}

}
