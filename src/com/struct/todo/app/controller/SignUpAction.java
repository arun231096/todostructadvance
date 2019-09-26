package com.struct.todo.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.struct.todo.app.model.SignUpForm;

public class SignUpAction extends Action{
	
	private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	SignUpForm signup = (SignUpForm) form;
    	if(signup.getUsername().length() != 0) {
    		return mapping.findForward(SUCCESS);
    	}
    	return mapping.findForward(FAILURE);
    }
	
}
