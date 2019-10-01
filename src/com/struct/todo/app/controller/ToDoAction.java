package com.struct.todo.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.struct.todo.app.dto.UserDto;
import com.struct.todo.app.model.ToDoForm;

public class ToDoAction extends DispatchAction{

	private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private final static String UPDATE = "update";
    

    public ActionForward getList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	List<ToDoForm> formList =  new ToDoForm().getList(((UserDto)request.getSession().getAttribute("user")).getId());
    	request.setAttribute("formlist", formList);
    	return mapping.findForward(SUCCESS);
    }
    
    public ActionForward save(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ToDoForm doFrom = (ToDoForm)form;
    	doFrom.setUserId(((UserDto)request.getSession().getAttribute("user")).getId());
    	if(doFrom.saveToDO()) {    		
    		return mapping.findForward(SUCCESS);
    	} else {
    		return mapping.findForward(FAILURE);
    	}
    }
    
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ToDoForm doFrom = (ToDoForm)form;
    	if(doFrom.Update())
    		return mapping.findForward(SUCCESS);
    	else 
    		return mapping.findForward(FAILURE);
    }
    
    public ActionForward read(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	int todoId = Integer.parseInt(request.getParameter("id"));
    	ToDoForm todoForm = new ToDoForm().readToDO(todoId);
    	request.setAttribute("todo", todoForm);
    	return mapping.findForward(UPDATE);
    }
    
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	int todoId = Integer.parseInt(request.getParameter("id"));
    	if(new ToDoForm().delete(todoId)) {
    		return mapping.findForward(SUCCESS);
    	} else {
    		return mapping.findForward(FAILURE);
    	}
    	
    }
    
}
