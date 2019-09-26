<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
    <%@page import="org.apache.struts.Globals"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Sorry Error on page</h1>
    <html:errors property="error.global.message"/>
    <script type="text/javascript">
        alert("Internal Server Error please login again");
        window.location = "logout.do";
    </script>
</body>
</html>