<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="style.css" type="text/css">
<title>Form</title>
</head>
<body>
 
	<%@include file="header.html" %> 
	
		
			<div class="centered">
			
			<form action="Login" method="post">
				<label>Username:</label><input type="text" name="username" maxlength="16"  placeholder="max 16 chars"  required><br><br>
				<label>Password:</label><input type="password" name="password" maxlength="16"  placeholder="max 16 chars" required><br><br>
				<input type="submit" value="Login">
			</form>
			
			
	       
		
	<%
	
	 if(request.getSession().getAttribute("validation")=="false"){
	%>
		
		<p style="Color:red">Password o Username errati, riprova o registrati</p>
		</div>
		
	<%
		request.getSession().removeAttribute("validation");
	 }
		 
		 
		 
	%>
		<br><br>
	
	<p>Se non sei ancora registrato nel nostro sito clicca <a href="Register.jsp">qui</button></a></p>
	
	
</body>
</html>