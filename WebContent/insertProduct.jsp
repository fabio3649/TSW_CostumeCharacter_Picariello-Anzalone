<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product Page</title>
</head>
<body>
	<form action="InsertProduct" method="post">
		<fieldset>
			<legend>Inserimento nuovo prodotto</legend>
			<label> Name </label> <br> <input type="text" name="name" required placeholder="name">  </input> <br> <br>
			<label> Type </label> <br> 
			<select name="type" required> 
				<option value="Costume"> Costume </option>
				<option value="Maschera"> Maschera </option>
				<option value="Accessorio"> Accessorio </option>
			</select> <br> <br>
			<label> Description </label> <br> <textarea placeholder="insert a description" rows="5" cols="60" name="description"> </textarea> <br> <br>
			<label> Age </label><br> <input type="text" name="age"> <br> <br>
			<label> Size </label> <br><input type="text" name="size"> <br> <br>
			<label> Number of copies </label><br> <input type="number" name="copies"> <br> <br>
			<label> Iva </label><br> <input type="number" name="iva" > <br> <br>
			<label> Price </label> <br> <input type="number" step="0.01" name="price" > <br><br>
			<label> Weight </label> <br> <input type="number" step="0.01" name="weight"> <br><br>
			<label> Category</label> <br>
			<select name="category" required> 
				<option value="A"> Supereroi </option>
				<option value="B"> Film & Serie Tv </option>
				<option value="C"> Disney </option>
				<option value="D"> Teatro </option>
				<option value="E"> Videogames </option>
			</select> <br> <br>
			<input type="submit" name="insert" value="ADD"	>
		</fieldset>
	</form>
</body>
</html>