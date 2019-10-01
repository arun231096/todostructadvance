package com.struct.todo.app.exception;

import java.util.List;

/**
 * @author arunkumar.angappan
 *
 */
public class AppException extends RuntimeException{

	private static final long serialVersionUID = 6625803778144572198L;

	private ErrorCode errorCode;
	private List<ErrorCode> errorCodes;
	
	public AppException() {}

	public AppException(ErrorCode code) {
		super();
		this.errorCode = code;
	}
	
	public AppException(ErrorCode code, Throwable cause) {
		super(cause);
		this.errorCode = code;
	}

	public AppException(List<ErrorCode> errorCodes) {
		super();
		this.errorCodes = errorCodes;
	}
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	public List<ErrorCode> getErrorCodes() {
		return errorCodes;
	}
	public void setErrorCodes(List<ErrorCode> errorCodes) {
		this.errorCodes = errorCodes;
	}
	
}
