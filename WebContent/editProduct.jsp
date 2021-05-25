<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*, control.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
	
	<%
		ProductModelDS daoUser = new ProductModelDS();
		ProductBean product = new ProductBean();
		if(request.getParameter("id")!=null){
			request.getSession().setAttribute("id", request.getParameter("id"));
			product = daoUser.doRetrieveByKey(Integer.parseInt(request.getParameter("id")));
		}
		
	%>
	<%if(product.getId()!=-1){ %>
		<form action="EditProduct" method="post">
			<fieldset>
				<legend>Modifica il Prodotto - <%=product.getName() %></legend>
				<label> Name </label> <br> <input type="text" name="name" required value="<%=product.getName() %>"><br> <br>
				<label> Type </label> <br> 
				<select name="type" required> 
					<%if(product.getType().equals("Costume")){ %>
						<option value="Costume" selected> Costume </option>
					<%}else{ %>
						<option value="Costume"> Costume </option>
					<%} %>
					<%if(product.getType().equals("Maschera")){ %>
						<option value="Maschera" selected> Maschera </option>
					<%}else{ %>
						<option value="Maschera"> Maschera </option>
					<%} %>
					<%if(product.getType().equals("Accessorio")){ %>
						<option value="Accessorio" selected> Accessorio </option>
					<%}else{ %>
						<option value="Accessorio"> Accessorio </option>
					<%} %>
				</select> <br> <br>
				<label> Description </label> <br> <textarea rows="5" cols="60" name="description"> <%=product.getDescription() %> </textarea> <br> <br>
				<label> Age </label><br> <input type="text" name="age" value="<%=product.getAge() %>"> <br> <br>
				<label> Size </label> <br><input type="text" name="size" value="<%=product.getSize() %>"> <br> <br>
				<label> Number of copies </label><br> <input type="number" name="copies" value="<%=product.getNumCopies() %>"> <br> <br>
				<label> Iva </label><br> <input type="number" name="iva" value="<%=product.getIva() %>"> <br> <br>
				<label> Price </label> <br> <input type="number" step="0.01" name="price" value="<%=product.getPrice() %>" > <br><br>
				<label> Weight </label> <br> <input type="number" step="0.01" name="weight" value="<%=product.getWeight() %>"> <br><br>
				<label> Category</label> <br>
				<select name="category" required> 
					<%if(product.getCategory().equals("A")){ %>
						<option value="A" selected>Supereroi</option>
					<%}else{ %>
						<option value="A"> Supereroi </option>
					<%} %>
					<%if(product.getCategory().equals("B")){ %>
						<option value="B" selected> Film & Serie Tv </option>
					<%}else{ %>
						<option value="B"> Film & Serie Tv </option>
					<%} %>
					<%if(product.getCategory().equals("C")){ %>
						<option value="C" selected> Disney </option>
					<%}else{ %>
						<option value="C"> Disney </option>
					<%} %>
					<%if(product.getCategory().equals("D")){ %>
						<option value="D" selected> Teatro </option>
					<%}else{ %>
						<option value="D"> Teatro </option>
					<%} %>
					<%if(product.getCategory().equals("E")){ %>
						<option value="E" selected> Videogames </option>
					<%}else{ %>
						<option value="E"> Videogames </option>
					<%} %>
				</select> <br> <br>
				<input type="submit" name="insert" value="ADD"	>
			</fieldset>
		</form>
	
	<%}else{ %>
		<h1>Prodotto non trovato nel Catalogo</h1>
	<%} %>
</body>
</html>