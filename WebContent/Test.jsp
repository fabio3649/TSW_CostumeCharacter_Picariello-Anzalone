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
  
  AddressModelDS dao = new AddressModelDS();
  AddressBean bean = dao.doRetrieveMinByUser("pippobaudo2");
  
  
  
  %>
  
	<%= bean %>
	  
</body>
</html>