package com.struct.todo.app.exception;

import com.struct.todo.app.util.ErrorConstants;

public enum ErrorCode {

	   INTERNAL_ERROR(500, ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE),
	   TITLE_EMPTY(401, ErrorConstants.TITLE_IS_EMPTY),
	   MESSAGE_EMPTY(401, ErrorConstants.MESSAGE_IS_EMPTY),
	   ESTIMATION_EMPTY(401, ErrorConstants.ESTIMATION_IS_EMPTY),
	   STARTDATE_ERROR(401, ErrorConstants.WRONG_START_DATE),
	   ENDDATE_ERROR(401, ErrorConstants.WRONG_END_DATE),
	   STATUS_EMPTY(401, ErrorConstants.STATUS_IS_EMPTY),
	   USERID_EMPTY(401, ErrorConstants.USER_ID_IS_EMPTY),
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
