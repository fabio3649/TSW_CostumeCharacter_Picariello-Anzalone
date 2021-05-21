<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Register Page</title>
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
	<form action="CheckRegister" method="post">
	
	
		<fieldset>
			<legend>Username e Password</legend>
			<label>Username : </label><input type="text" name="username" autocomplete="off" maxlength="16" required>
				<%if(request.getSession().getAttribute("exUsername")==("true")){ %>
					<p style=Color:red>Invalid Username, try another word</p>
				<%
					request.getSession().removeAttribute("exUsername");
				}else{ %>
					<br><br>
				<%} %>
			<label>Password : </label><input type="password" name="password1" autocomplete="off" maxlength="16" required placeholder="MAX 16 CHARS"><br><br>
			<label>Password : </label><input type="password" name="password2" autocomplete="off" maxlength="16" required placeholder="MAX 16 CHARS">
				<%if(request.getSession().getAttribute("incorrectPasswords")==("true")){ %>
					<p style=Color:red>Passwords are different</p>
				<%
					request.getSession().removeAttribute("incorrectPasswords");
				}else{ %>
					<br><br>
				<%} %>
		</fieldset>
		
		
		<fieldset>
			<legend>Dati anagrafici</legend>
			<label>Name : </label><input type="text" name="name"  maxlength="16" required><br><br>
			<label>Surname : </label><input type="text" name="surname"  maxlength="16" required><br><br>
			<label>N°telefono : </label><input type="number" name="telephon" maxlength="16"><br><br>
			<label>E-Mail : </label><input type="text" name="email"  required maxlength="25"><br><br>
		</fieldset>
		
		
		<fieldset>
			<legend>Indirizzo</legend>
			<label>Address : </label><input type="text" name="address"  maxlength="16" required><br><br>
			<label>CAP : </label><input type="number" name="cap"  maxlength="16" required><br><br>
			<label>City : </label><input type="text" name="city" maxlength="16" required><br><br>
			<label>Province : </label><input type="text" name="province"  maxlength="2" required><br><br>
			<input type="submit" value="Register">
		</fieldset> 
		
		
	</form>
</body>
</html>