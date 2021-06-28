<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="model.*,java.util.*, java.sql.Date "  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%
  
  OrderModelDS dao = new OrderModelDS();
  OrderBean bean = dao.doRetrieveByName("fabio","picariello");
  
  
  
  %>
  
	<%= bean %>
	  
</body>
</html>