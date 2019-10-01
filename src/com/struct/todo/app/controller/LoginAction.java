/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struct.todo.app.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.struct.todo.app.dto.UserDto;
import com.struct.todo.app.model.LoginForm;

/**
 * @author arunkumar.angappan
 *
 */
public class LoginAction extends Action {

    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginForm = (LoginForm) form;
        UserDto user = loginForm.checkLogin();
        if (!(Objects.isNull(user))) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", user);
            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }
}
