<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<form action="Login" method="post">
		<label>Username:</label><input type="text" name="username"><br><br>
		<label>Password:</label><input type="text" name="password"><br><br>
		<input type="submit" value="Login">
	</form>
	<%
	
	 if(request.getSession().getAttribute("validation")=="false" && request.getSession().getAttribute("validation")!=null){
	%>
		<p style="Color:red">Password o Username errati, riprova o registrati</p>
	<%
		request.getSession().removeAttribute("validation");
	 }else{
	%>
		<br><br>
	<%} %>
	<a href="Register.jsp"><button>Register</button></a>
</body>
</html>