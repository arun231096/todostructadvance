package com.struct.todo.app.exception;

public enum ErrorCode {

	   INTERNAL_ERROR(500, ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE),
	   ACCESS_DENIED(401, ErrorConstants.ACCESS_DENIED_ERROR_MESSAGE);

	    private long code;
	    private String message;

	    ErrorCode(long errorCode, String errorMessage) {
	        this.code = errorCode;
	        this.message = errorMessage;
	    }

	    public long getCode() {
	        return code;
	    }

	    public void setCode(long errorCode) {
	        this.code = errorCode;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String errorMessage) {
	        this.message = errorMessage;
	    }

	    @Override
	    public String toString() {
	        return String.format("%o : %s", this.code, this.message);
	    }
}
