<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*,javax.swing.JOptionPane,java.lang.Math"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cart</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<%@ include file="header.html" %>

	<%
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(request.getSession().getAttribute("cart")!=null && cart.getProducts().isEmpty()==false){
	%>
	<table>
	
		<caption><h1>CART</h1></caption>
		
			<thead>
				<tr>
					<th>Name</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(int i=0;i<cart.getProducts().size();i++){
						double price = cart.getProducts().get(i).getPrice()*cart.getProducts().get(i).getQuantity();
						double temp = Math.pow(10, 2);
						price = Math.rint(price * temp) / temp;
				%>
				<tr>
					<td><%=cart.getProducts().get(i).getName()%></th>
					<td><a href="UpdateQuantity?id=<%=cart.getProducts().get(i).getId()%>&method=less"><button id="quantityUpdate1">-</button></a>   <%=cart.getProducts().get(i).getQuantity()%>   <a href="UpdateQuantity?id=<%=cart.getProducts().get(i).getId()%>&method=plus"><button id="quantityUpdate2">+</button></a></th>
					<td style=min-width:100px><%=price%>0 $</th>
				</tr>
				<%
					}
				
				%>
			</tbody>
		</table>
		<br><br><br>
		<%
			double total=0;
			double temp = Math.pow(10, 2);
			for(int i=0;i<cart.getProducts().size();i++){
				total +=(cart.getProducts().get(i).getPrice()*cart.getProducts().get(i).getQuantity());
			}
			total = Math.rint(total * temp) / temp;
		%>
		<h2>Total Price : <%=total %>0 $</h2>
		<a href="CheckOut.jsp"><button class="button" >Go to checkout</button></a>
		
	<%
	
	}else{
		%>
		<h1 align="center">The Cart is Empty :(</h1>
		<%
	}
	%>	
	<%@ include file="footer.html" %>
	
</body>
</html>