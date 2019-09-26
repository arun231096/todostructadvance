<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6 form">
                    <div class="row">
                        <div class="col-sm-12" align="left">
                            <h1>ToDo Login</h1>
                        </div>
                    </div>
                    <html:form action="/Login">
                        <div class="form-group"> 
                            <label>User Name</label>
				            <html:text name="LoginForm" property="userName" styleClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
				             <html:password name="LoginForm" property="password" styleClass="form-control"/>
                        </div>
			            <html:submit value="Login" styleClass="btn btn-primary"/>
			            <a href="signup.jsp">Sign Up</a>
			        </html:form>      
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>
    </body>
</html>
