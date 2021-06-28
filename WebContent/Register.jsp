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
<%@ include file="header.html" %>

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
	
	<%
	if (request.getSession().getAttribute("exUsername")!=null && request.getSession().getAttribute("exUsername").equals("true")){
		request.getSession().removeAttribute("exUsername");
		%>
	<p>  Username gi&agrave; esistente , riprova con un altro username </p>
	 <% } else{ %>
		<p> exusername non confrontabile</p>
	<%} %>
	<div id="formRegister">
	<div id="errorData"> </div>
	<form action="CheckRegister" id="formReg" method="post" onsubmit=" return validation()" >
	
		<fieldset>
			<legend>Credenziali per l'accesso</legend><br>
			<label>Username : </label> <input type="text" onchange="  controlUser(this.value) " id="username" name="username" autocomplete="off" maxlength="16" required onfocus="focusRegister(this)">
				<br>
				<strong id="availability"> </strong> <br>
				<br>
			<label>Password : </label><input type="password" id="password1" name="password1" onfocus="focusRegister(this)" required autocomplete="off" maxlength="16"  placeholder="MAX 16 CHARS"><br>
			<br>
			<label>Password : </label><input type="password" id="password2" name="password2" onfocus="focusRegister(this)" required autocomplete="off" maxlength="16"  placeholder="MAX 16 CHARS"><br>
			
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
			<label>Nome : </label><input type="text" id="name" name="name" required maxlength="16" ><br>
			<br>
			<label>Cognome : </label><input type="text" id="surname" name="surname" required  maxlength="16"><br>
			<br>
			<label>Data di nascita : </label> <input type="date" id="birthdate" required name="birthdate" ><br><br> 
			<label>N°telefono : </label><input type="tel" id="telephon" name="telephon" placeholder="333-1111111" required maxlength="10"><br>
			<br>
			<label>E-Mail : </label><input type="text" id="email" name="email" required  maxlength="25"><br>
			<br>
			
		</fieldset>
		
		
		<fieldset>
			<legend></legend>
			<label>Indirizzo : </label><input type="text" id="address" name="address" required maxlength="16" ><br>
			<br>
			<label>CAP : </label><input type="number" id="cap" name="cap" required maxlength="5" ><br>
			<br>
			<label>Città : </label><input type="text" id="city" name="city" required maxlength="16" ><br>
			<br>
			<label>Provincia : </label><input type="text" id="province" name="province" required maxlength="2" ><br>
			<br>
			<input type="submit" value="Register" class="validation" >&nbsp;
			
		</fieldset> 

	</form>
	<script>
      	function validation(){
      		
      		var nome = $("#name").val();
      		var cognome = $("#surname").val();
      		var phone = $("telephon").val();
      		var password1 = $("#password1").val();
      		var confirmPassword = $("#password2").val();
      		var email = $("#email").val();
      		var cap = $("#cap").val();
      		var city = $("#city").val();
      		var prov = $("#province").val();
      		var username = $("#username").val();
      		var address = $("#address").val();
      		
      		// Validazione con espressioni regolari
      		
      		var patternUsername = /^[a-z0-9._]{6,18}$/;
      		if(!patternUsername.test(username)){
      			$("#username").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci una username valida, maiuscole / numeri / . / _");
      			return false;
      		} else { console.log("campo password1 corretto") ; }  
      		
      		var patternPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}/;
      		if(!patternPassword.test(password1)){
      			$("#password1").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci una password valida, maiuscole / numeri / . / lunghezza minima 8 ");
      			return false;
      		} else { console.log("campo password1 corretto") ; }  
      		
      		var patternName = /^[a-zA-Z ]+$/;
      		if(!patternName.test(nome)){
      			$("#name").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci un nome valido");
      			return false;
      			
      		} else { console.log("campo nome corretto");   }
      		
      		var patternCognome = /^[a-zA-Z ]+$/;
      		if(!patternCognome.test(cognome)){
      			$("#surname").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci un cognome valido");
      			return false;
      			
      		} else { console.log("campo cognome corretto");  }
      		
      		
      		
      		var patternEmail = /^[a-zA-Z0-9.%_-]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,10}$/;
      		if(!patternEmail.test(email)){
      			$("#email").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci una e-mail valida");
      			return false;
      			
      		} else { console.log("campo email corretto");  }
      		
      		var patternAddress = /^[a-zA-Z ]+$/;
      		if(!patternAddress.test(address)){
      			$("#address").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci un indirizzo valido");
      			return false;
      			
      		} else { console.log("indirizzo corretto");  }
      		
      		
      		var patternCAP = /^[0-9]{5}$/;
      		if(!patternCAP.test(cap)){
      			$("#cap").focus();
      			$("#errorData").show();
      			$("#errorData").text("CAP non valido, 5 numeri");
      			return false;
      		}
      		
      		var patternCity = /^[a-zA-Z ]+$/;
      		if(!patternCity.test(city)){
      			$("#city").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci un nome di città");
      			return false;
      			
      		} else { console.log("città corretta");  }
      		
      		var patternProv = /^[a-zA-Z ]{2}$/;
      		if(!patternProv.test(prov)){
      			$("#province").focus();
      			$("#errorData").show();
      			$("#errorData").text("inserisci una provincia valida");
      			return false;
      			
      		} else { console.log("provincia corretta");  }
      		
      		return true;
      		}
      		
      	

 			
		</script>

	</div>

	
	 
<script src="\CostumeCharacter\\script\regularExpressionForm.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>