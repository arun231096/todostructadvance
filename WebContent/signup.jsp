<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Signup ToDo</title>
      <link href="css/style.css" rel="stylesheet" type="text/css"/>
      <script type="text/javascript" src="js/script.js"></script>
   </head>
   <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6 form">
                    <div class="row">
                        <div class="col-sm-12" align="left">
                            <h1>ToDo SignUp</h1>
                        </div>
                    </div>
                    <html:form action="/signup" styleId="form" onsubmit="return validateProfileForm()">
                        <div class="form-group"> 
                            <label>Name</label>
                            <html:text name="SignUpForm" property="name" styleClass="form-control"/>
                        </div>
                        <div class="form-group"> 
                            <label>User Name</label>
                            <html:text name="SignUpForm" property="username" styleClass="form-control"/>
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
                        <html:submit value="SignUp" styleClass="btn btn-primary"/>
                        <a href="login.jsp">Login</a>
                    </html:form>      
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>
    </body>
    <script type="text/javascript">
    cleanForm();
    </script>
</html>