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
<table id="tableForms">
    	<tr class="buttonBorder">
        	<td class="buttonBorder">
           	 	<form action="CartView.jsp" method="post">
    				<input class="button" type="submit" value="Cart">
		  		</form>
		  		
        	</td>
        	<td class="buttonBorder">
             	<form action="Catalog.jsp"method="post">
    				<input class="button" type="submit" value="Catalog">
		  		</form>
        	</td>
        	<td class="buttonBorder">
           	 	<form action="Login.jsp" method="post">
    				<input class="button" type="submit" value="Login">
		  		</form>
		  		
        	</td>
        	<td class="buttonBorder">
           	 	<form action="Register.jsp" method="post">
    				<input class="button" type="submit" value="Register">
		  		</form>
		  		
        	</td>
    	</tr>
	</table>
	<form action="Login" method="post">
		<label>Username:</label><input type="text" name="username" maxlength="16"  placeholder="max 16 chars"  required><br><br>
		<label>Password:</label><input type="password" name="password" maxlength="16"  placeholder="max 16 chars" required><br><br>
		<input type="submit" value="Login">
	</form>
	
		
	<%
	
	 if(request.getSession().getAttribute("validation")=="false"){
	%>
		<p style="Color:red">Password o Username errati, riprova o registrati</p>
	<%
		request.getSession().removeAttribute("validation");
	 }
		 
		 
		 
	%>
		<br><br>
	
	<a href="Register.jsp"><button>Register</button></a>
</body>
</html>