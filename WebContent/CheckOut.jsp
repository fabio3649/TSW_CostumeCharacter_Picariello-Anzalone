<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>

<body>

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
	
<%
	if(request.getSession().getAttribute("validation")==("true"))
	{
		
	
%>
	
	
	
	<form action="MakeOrder" method="post">
		
		<label > Payment meythod 
				<select name="payment">
					<option value="paypal"> Paypal </option>
					<option value="Debit Card"> Debit card </option>
			
				</select>
		</label>
		<br> <br> <br>
	
	<%
	String username = (String ) request.getSession().getAttribute("currentUser");
	UserModelDS dao = new UserModelDS();   
	UserBean user = (UserBean) dao.doRetrieveByKey(username);
	AddressModelDS daoAd = new AddressModelDS();
	ArrayList<AddressBean> allAddress =  daoAd.doRetrieveAllByUser(username);	
	{ 
	%>
	<h4 style="color:red" > Seleziona l'indirizzo di spedizione </h4>
	<input type="radio" name="address" value="billing" >  <h4> Billing address: </h4> 
	    	<p> <h3> <%= user.getBillingAddress() %>  
			    <%=user.getBillingCity() %> 	
			    <%=user.getBillingProvince() %> 	
	 			<%=user.getBillingCAP() %>  </h3> </p> 
	  
      <br> <br>
	
	<h4> Altri indirizzi </h4>
	
	<%
	if(allAddress!=null){
	for(int i = 0 ; i< allAddress.size() ; i++){
	%>

	 <input type="radio" name="address" value="<%=allAddress.get(i).getIdAddress() %>" >
	              
	              
	 			  <h3> <%= allAddress.get(i).toStringReduce() %> </h3> 
	  			
	
	
	
	
		<% }
	      }
	       
	    %>
		
		
		
		
		
		
	


	  <br><br>
	  <input type="radio" name ="address" value="newAddress" >
			  <h4> Aggiungi un nuovo indirizzo </h4> <br>
						Address: <input type="text" name="via" > <br>
						City: <input type="text" name="city" > <br>
					    CAP: <input type="number" name="cap" maxlength="5"> <br>
						Province: <input type="text" name="province" > <br>	
						
			
	   </input>
	   
	   
		
			
		
	
	<input type="submit" value="Acquista">
	
	</form>
	
	
 <% } %>

<% }


else{
		RequestDispatcher req = ( RequestDispatcher) request.getRequestDispatcher("Login.jsp");
		req.forward(request,response);
	}
		 
	
	
%>




	
</body>
</html>