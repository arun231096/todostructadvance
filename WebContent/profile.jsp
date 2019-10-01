<%@page import="com.struct.todo.app.model.UserDetailsForm"%>
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
    </head>
    <script type="text/javascript" src="js/script.js"></script>
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
            <logic:notEmpty name="SignUpForm">
            <div class="row">
               <div class="col-sm-2"><h1>Update Profile</h1></div>
               <div class="col-sm-8">
                <div class="row">
                    <div class="col-sm-12" align="right" style="padding: 10px;">
                        <html:form action="/user/update?method=updateUser" styleId="form" onsubmit="return validateProfileForm()">
                            <div class="form-group"> 
                                <label>Username</label>
                                <html:hidden property="id" name="SignUpForm"/>
                                <html:text name="SignUpForm" property="username" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                 <html:text name="SignUpForm" property="name" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                 <html:password name="SignUpForm" property="password" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Designation</label>
                                 <html:text name="SignUpForm" property="designation" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <html:text name="SignUpForm" property="email" styleClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Mobile</label>
                                <html:text name="SignUpForm" property="mobile" styleClass="form-control"/>
                            </div>
                            <a href="#" onclick="deleteuser()">Deactivate</a>
                            <html:submit value="Save" styleClass="btn btn-primary"/>
                        </html:form>
                    </div>
                </div>
               </div>
               <div class="col-sm-2"></div>
            </div>
            </logic:notEmpty>
        </div>
    </body>
</html>