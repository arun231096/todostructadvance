package com.struct.todo.app.controller;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.struct.todo.app.model.ToDoForm;

public class ToDoAction extends DispatchAction{

	private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private final static String UPDATE = "update";
    
    List<ToDoForm> formList = new LinkedList<ToDoForm>();

    public ActionForward getList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	formList.add(new ToDoForm("1","AML","Technical Task","2",Date.valueOf("2019-09-25").toString(), Date.valueOf("2019-09-25").toString(), "completed", "1"));
    	request.setAttribute("formlist", formList);
    	if(formList.isEmpty()) {
    		return mapping.findForward(FAILURE);
    	}
    	return mapping.findForward(SUCCESS);
    }
    
    public ActionForward save(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ToDoForm doFrom = (ToDoForm)form;
    	doFrom.setId(""+formList.size()+1);
    	doFrom.setUserId(request.getSession().getAttribute("id").toString());
    	formList.add(doFrom);
    	request.setAttribute("formlist", formList);
    	return mapping.findForward(SUCCESS);
    }
    
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ToDoForm doFrom = (ToDoForm)form;
    	System.out.println(doFrom.getUserId());
    	request.setAttribute("formlist", formList);
    	return mapping.findForward(SUCCESS);
    }
    
    public ActionForward read(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ToDoForm doForm = formList.stream().filter(todo ->  todo.getId().equals(request.getParameter("id")))
    									   .collect(Collectors.toList()).get(0);
    	request.setAttribute("todo", doForm);
    	return mapping.findForward(UPDATE);
    }
    
}
