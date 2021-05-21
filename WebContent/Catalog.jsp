<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Catalog</title>
		<link rel="stylesheet" href="style.css" type="text/css">
	</head>

	<%
	 	ProductModelDS daoProdotto= new ProductModelDS();
		ArrayList<ProductBean> products =  daoProdotto.doRetrieveAll("type");
	 	Iterator<?> it = products.iterator();
	%>
	<body>
		<% if(request.getParameter("notAvailable")!=null){%>
		<script>
 			 alert("We're sorry, but the selected product has no copies available");
		</script>
		<%} %>
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
		<table>
			<caption><h1>CATALOG</h1></caption>
			<tr>
				<th>Name</th>
				<th>Availability</th>
				<th>Price</th>
				<th>Add to Cart</th>
			</tr>
			<%  
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
					String s = "ProductPage.jsp" + "?id="+bean.getId();
					Cart cart = (Cart) request.getSession().getAttribute("cart");
					boolean added = false;
					if(cart!=null){
						added = cart.productContain(bean.getId());
					}
					
			%>
			<tr>
				<td><a href=<%=s%>><%=bean.getName() %></a></td>
				<%if(bean.getNumCopies()<=0){ %>
					<td class="NotAvailable">Not Available</td>
				
				<%}else{ %>
					<td class="Available">Available</td>
				<% } %>
				<td><%=bean.getPrice()+"$"%></td>
				<td style=min-width:100px> <a href="AddToCart?id=<%=bean.getId()%>"><button class="buttonAdd">ADD</button></a> <%if(added){%><br><label style=color:green>added to cart</label><%} %></td>
				
			</tr>
			 <% } %>
		</table>
	</body>
</html>