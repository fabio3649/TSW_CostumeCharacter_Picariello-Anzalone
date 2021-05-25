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
		ArrayList<ProductBean> products =  daoProdotto.doRetrieveAll("name");
	 	Iterator<?> it = products.iterator();
	%>
	<body>
		<table>
			<caption><h1>CATALOG</h1></caption>
			<tr>
				<th>Name</th>
				<th>Availability</th>
				<th>Price</th>
				<th>Number of Copies</th>
				<th>Size</th>
				<th>Edit Product</th>
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
				<td><%=bean.getNumCopies() %></td>
				<td style=width:80px><%=bean.getSize() %></td>
				<td> <a href="editProduct.jsp?id=<%=bean.getId()%>"><button class="buttonAdd">Edit</button></a> </td>
				
			</tr>
			 <% } %>
		</table>
	</body>
</html>