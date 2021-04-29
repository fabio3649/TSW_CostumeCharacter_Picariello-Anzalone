<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>prova DB</title>
</head>
<body>
<h1> Prova Risultato tuple tabella prodotto </h1>
<%
 ProductModelDS daoProdotto= new ProductModelDS();
Collection<?> products = (Collection<?>) daoProdotto.doRetrieveAll("idProduct");
 
Iterator<?> it = products.iterator();
while (it.hasNext()) {
	ProductBean bean = (ProductBean) it.next();
%>


<table border="1">
		<tr>
			<th>IdProduct</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Number of Copies</th>
		</tr>
		<tr>
			<td><%=bean.getId()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getDescription()%></td>
			<td><%=bean.getPrice()%></td>
			<td><%=bean.getNumCopies()%></td>
		</tr>
	</table>
<%
                 }

%>
</body>
</html>