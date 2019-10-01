package com.struct.todo.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.struct.todo.app.dto.UserDto;
import com.struct.todo.app.model.UserDetailsForm;

public class UserProfileAction extends DispatchAction{

	private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private final static String DELETED = "deleted";

    public ActionForward readUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	String username = ((UserDto) request.getSession().getAttribute("user")).getUsername();
    	UserDetailsForm userDetail = new UserDetailsForm().read(username);
    	if(userDetail.getId() > 0) {
    		request.setAttribute("SignUpForm", userDetail);
    		return mapping.findForward(SUCCESS);
    	} else {
    		return mapping.findForward(FAILURE);
    	}
    }
    
    public ActionForward updateUser (ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	UserDetailsForm userForm = (UserDetailsForm)form;
    	UserDto dto = (UserDto) request.getSession().getAttribute("user");
    	if(userForm.update()) {
    		dto.setId(userForm.getId());
    		dto.setUsername(userForm.getUsername());
    		dto.setName(userForm.getName());
    		dto.setDesignation(userForm.getDesignation());
    		dto.setEmail(userForm.getEmail());
    		dto.setMobile(userForm.getMobile());
    		request.getSession().setAttribute("user", dto);
    		return mapping.findForward(SUCCESS);
    	}
    	return mapping.findForward(FAILURE);
    }
    
    public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	boolean deletedUser = new UserDetailsForm().delete(((UserDto) request.getSession().getAttribute("user")).getId());
    	if(deletedUser) {
    		return mapping.findForward(DELETED);
    	}
    	return mapping.findForward(FAILURE);
    }
}
