
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
			  <a href="Admin.jsp?id=3">Edit product </a>
			  <a href="Admin.jsp?id=4">View product</a>
        </div>
	
	
	<div class="view">
	<%if(request.getParameter("id")!=null){ %>
		<% if(request.getParameter("id").equals("1")){
		%>	
				<%@ include file="Catalog.jsp"%>
			
		<%} %>
		<% if(request.getParameter("id").equals("2")){
		%>	
				<%@ include file="insertProduct.jsp"%>
			
		<%} %>
		<% if(request.getParameter("id").equals("3")){
		%>	
				<%@ include file="editProduct.jsp"%>
			
		<%} %>
		<% if(request.getParameter("id").equals("4")){
		%>	
				<%@ include file="viewProduct.jsp"%>
			
		<%} %>
	<%} %>
	</div>
	


</body>
</html>