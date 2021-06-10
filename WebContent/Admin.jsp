
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="admin.css" type="text/css"  >
<title>Admin Panel</title>
</head>
<body>
	
		<div class="vertical-menu">
			  <a href="index.jsp" class="active">Home</a>
			  <a href="Admin.jsp?id=1">Catalog view</a>
			  <a href="Admin.jsp?id=2">Insert new product</a>
			  <a href="Admin.jsp?id=3">View Users</a>
        </div>
	
	
	<div class="view">
	<%if(request.getParameter("id")!=null){ %>
		<% if(request.getParameter("id").equals("1")){
		%>	
				<%@ include file="CatalogAdmin.jsp"%>
			
		<%} %>
		<% if(request.getParameter("id").equals("2")){
		%>	
				<%@ include file="insertProduct.jsp"%>
			
		<%} %>
		<% if(request.getParameter("id").equals("3")){
		%>	
				
			
		<%} %>
	<%} %>
	</div>
	


</body>
</html>