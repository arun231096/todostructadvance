package com.struct.todo.app.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.struct.todo.app.model.UserDetailsForm;

public class SignUpAction extends Action{
	
	private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	UserDetailsForm signup = (UserDetailsForm) form;
    	if(signup.save()) {
    		return mapping.findForward(SUCCESS);
    	} else
    		return mapping.findForward(FAILURE);
    }
	
}
