<%@page import="com.struct.todo.app.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
    <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>ToDo</title>
      <link href="css/style.css" rel="stylesheet" type="text/css"/>
      <script type="text/javascript" src="js/script.js"></script>
      <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
    </head>
    <body>
    <%  UserDto user = (UserDto)session.getAttribute("user"); %>
        <div class="container" style="padding:20px;">
        <h1 onclick="home()" id="pointer">Welcome <% out.print(user.getName()); %>!</h1>
            <div class="row" style="padding: 10px;">
                <div class="col-sm-12" align="right">
                    <html:link href="logout.do"><button class="btn btn-danger">Logout</button></html:link>
                </div>
            </div>
            
            <!-- Update ToDo Action -->
            <logic:notEmpty name="todo">
            <div class="row">
               <div class="col-sm-2"><h1>Update ToDo</h1></div>
               <div class="col-sm-8">
                <div class="row">
                    <div class="col-sm-12" align="left" style="padding: 10px;">
                        <html:form action="/todo?method=update" styleId="form" onsubmit="return validateForm()">
                            <div class="form-group"> 
                                <label>Title</label>
                                <html:hidden property="id" name="todo"/>
                                <html:text name="todo" property="title" styleClass="form-control" styleId="title"/>
                            </div>
                            <div class="form-group">
                                <label>Message</label>
                                 <html:text name="todo" property="message" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Estimation in days</label>
                                 <html:text name="todo" property="estimation" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Start Date</label>
                                <input type="date" name="startDate" class="form-control" placeholder="yyyy-mm-dd" 
                                    value="<bean:write name="todo" property="startDate" />" />
                                    
                            </div>
                            <div class="form-group">
                                <label>End Date</label>
                                <input type="date" name="endDate" class="form-control" placeholder="yyyy-mm-dd" 
                                    value="<bean:write name="todo" property="endDate" />" />
                                   
                            </div>
                            <div class="form-group">
                                <label>Status</label>
                                <html:select name="todo" property="status" styleClass="form-control"> 
                                    <html:option value="Completed">Completed</html:option>
                                    <html:option value="Not Completed">Not Completed</html:option>
                                </html:select>
                                <html:hidden property="userId" name="todo"/>
                            </div>
                            <html:submit value="Save" styleClass="btn btn-primary"/>
                        </html:form>
                    </div>
                </div>
               </div>
               <div class="col-sm-2"></div>
            </div>
            </logic:notEmpty>

            <!-- Add Todo Action -->
            <logic:empty name="todo">
            <div class="row">
               <div class="col-sm-2"><h1>Add ToDo</h1></div>
               <div class="col-sm-8">
                <div class="row">
                    <div class="col-sm-12" align="left" style="padding: 10px;">
                        <html:form action="/todo?method=save" styleId="form" onsubmit="return validateForm()">
                            <div class="form-group"> 
	                            <label>Title</label>
	                             <input type="text" name="title" class="form-control" placeholder="Enter title" 
                                    value="<bean:write name="ToDoForm" property="title" />" />
                                    
	                        </div>
	                        <div class="form-group">
	                            <label>Message</label>
	                            <input type="text" name="message" class="form-control" placeholder="Enter message" 
                                    value="<bean:write name="ToDoForm" property="message" />" />
                                 
	                        </div>
	                        <div class="form-group">
	                            <label>Estimation in days</label>
	                            <input type="text" name="estimation" class="form-control" placeholder="Enter estimation" 
                                    value="<bean:write name="ToDoForm" property="estimation" />" />
                                    
	                        </div>
	                        <div class="form-group">
	                            <label>Start Date</label>
	                            <input type="date" name="startDate" class="form-control" placeholder="yyyy-mm-dd" 
                                    value="<bean:write name="ToDoForm" property="startDate" />" />
                                    
	                        </div>
	                        <div class="form-group">
                                <label>End Date</label>
                                <input type="date" name="endDate" class="form-control" placeholder="yyyy-mm-dd" 
                                    value="<bean:write name="ToDoForm" property="endDate" />" />
                                   
	                        </div>
	                        <div class="form-group">
                                <label>Status</label>
                                <html:select name="ToDoForm" property="status" styleClass="form-control"> 
                                    <html:option value="Completed">Completed</html:option>
                                    <html:option value="Not Completed">Not Completed</html:option>
                                </html:select>
                            </div>
	                        <html:submit value="Save" styleClass="btn btn-primary"/>
                        </html:form>
                    </div>
                </div>
               </div>
               <div class="col-sm-2"></div>
            </div>
            </logic:empty>
        </div>
    </body>
</html>