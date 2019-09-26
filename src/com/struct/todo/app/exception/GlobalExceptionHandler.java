package com.struct.todo.app.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

/**
 * @author arunkumar.angappan
 *
 */
public class GlobalExceptionHandler extends ExceptionHandler{
	
	@Override
	  public ActionForward execute(Exception ex, ExceptionConfig ae,
		ActionMapping mapping, ActionForm formInstance,
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException {
		if (ex instanceof AppException) {
			System.out.println(((AppException) ex).getErrorCode());
		}
		return super.execute(ex, ae, mapping, formInstance, request, response);
	  }
}
