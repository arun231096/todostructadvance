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
    </head>
    <body>
        <div class="container" style="padding:20px;">
        <h1>Welcome <%=session.getAttribute("user") %>!</h1>
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
                    <div class="col-sm-12" align="right" style="padding: 10px;">
                        <html:form action="/todo?method=update">
                            <div class="form-group"> 
                                <label>Title</label>
                                <html:hidden property="id" name="todo"/>
                                <html:text name="todo" property="title" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Message</label>
                                 <html:text name="todo" property="message" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Estimation</label>
                                 <html:text name="todo" property="estimation" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Start Date</label>
                                 <html:text name="todo" property="startDate" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>End Date</label>
                                <html:text name="todo" property="endDate" styleClass="form-control"/>
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
                    <div class="col-sm-12" align="right" style="padding: 10px;">
                        <html:form action="/todo?method=save">
                            <div class="form-group"> 
	                            <label>Title</label>
	                            <html:text name="ToDoForm" property="title" styleClass="form-control"/>
	                        </div>
	                        <div class="form-group">
	                            <label>Message</label>
	                             <html:text name="ToDoForm" property="message" styleClass="form-control"/>
	                        </div>
	                        <div class="form-group">
	                            <label>Estimation</label>
	                             <html:text name="ToDoForm" property="estimation" styleClass="form-control"/>
	                        </div>
	                        <div class="form-group">
	                            <label>Start Date</label>
	                             <html:text name="ToDoForm" property="startDate" styleClass="form-control"/>
	                        </div>
	                        <div class="form-group">
                                <label>End Date</label>
                                <html:text name="ToDoForm" property="endDate" styleClass="form-control"/>
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