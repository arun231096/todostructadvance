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
    <script type="text/javascript">
      function getData(id) {
    	  tr = document.getElementById("listTable").rows[id];
    	  id = tr.childNodes[1].value;
    	  console.log(id);
    	  window.location = "list.do?method=read&id="+id;
      }
    </script>
    <body>
     <%
         int count =1;
     %>
        <div class="container" style="padding:20px;">
        <h1>Welcome <%=session.getAttribute("user") %>!</h1>
            <div class="row" style="padding: 10px;">
                <div class="col-sm-12" align="right">
                    <html:link href="logout.do"><button class="btn btn-danger">Logout</button></html:link>
                </div>
            </div>
            <div class="row">
               <div class="col-sm-2"></div>
               <div class="col-sm-8">
				<div class="row">
					<div class="col-sm-12" align="right" style="padding: 10px;">
						<a href="addtodo.jsp"><button class="btn btn-info" id="addtodo">Add ToDo</button></a>
					</div>
				</div>
				<table border="1" class="table table-striped" id="listTable">
                      <tr>
                          <th>S.No</th>
                          <th>Title</th>
                          <th>Message</th>
                          <th>Estimation</th>
                          <th>Start Date</th>
                          <th>End Date</th>
                          <th>Status</th>
                     </tr>
                    <logic:iterate name="formlist" id="todo">
                       <tr>
	                        <html:hidden property="id" name="todo" styleId="id"/>
	                        <td><% out.println(count);%></td>
	                        <td><bean:write name="todo" property="title"/></td>
	                        <td><bean:write name="todo" property="message"/></td>
	                        <td><bean:write name="todo" property="estimation"/></td>
	                        <td><bean:write name="todo" property="startDate"/></td>
	                        <td><bean:write name="todo" property="endDate"/></td>
	                        <td><bean:write name="todo" property="status"/></td>
	                        <td><button onclick="getData(<% out.print(count); count++; %>)" class="btn">Edit</button></td>
                       </tr>
                    </logic:iterate>
                    </table>
               </div>
               <div class="col-sm-2"></div>
            </div>
        </div>
    </body>
</html>