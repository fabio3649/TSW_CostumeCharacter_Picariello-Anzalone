<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>

<body>
<%
	if(request.getSession().getAttribute("validation").equals("true"))
	{
		String username = (String ) request.getSession().getAttribute("currentUser");
	
%>
	<table id="tableForms">
    	<tr class="buttonBorder">
        	<td class="buttonBorder">
           	 	<form action=".jsp" method="post">
    				<input class="button" type="submit" value="Cart">
		  		</form>
		  		
        	</td>
        	<td class="buttonBorder">
             	<form action="Catalog.jsp"method="post">
    				<input class="button" type="submit" value="Catalog">
		  		</form>
        	</td>
    	</tr>
	</table>
	
	<form action="MakeOrder" method="post">
	<label > Payment meythod 
			<select name="payment">
				<option value="paypal"> Paypal </option>
				<option value="Debit Card"> Debit card </option>
		
			</select>
	</label>
	
	<label > Shipping Address
			
	</label>
	
	<input type="submit" value="Acquista">
	</form>
	
	<h1>Checkout...</h1>
<% }

else{
		RequestDispatcher req = ( RequestDispatcher) request.getRequestDispatcher("Login.jsp");
		req.forward(request,response);
	}
		 
	
	request.getSession().removeAttribute("cart");
%>




	
</body>
</html>