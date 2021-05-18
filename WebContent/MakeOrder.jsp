<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*,model.*,control.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Complete Order </title>
</head>
<body>

	<% 
	if(request.getSession().getAttribute("validation").equals("true"))
	{
		
		
	OrderModelDS daoOrder = new OrderModelDS();
	RefOrderModelDS daoRef = new RefOrderModelDS();
	Cart cart = (Cart) request.getSession().getAttribute("cart");  // prendo il carrello
	ArrayList<ProductBean> products = cart.getProducts();   // prendo i prodotti dal carrello
	String username = request.getSession().getAtribute("currentUser");
	
	
	for ( int i=0 ; i < products.size() ; i++){
		ProductBean bean = new ProductBean();
		RefOrderBean ref = new RefOrderBean();
		ref.setProduct(products.get(i).getId());  // aggiungo l id prodotto al ref order
		ref.setQuantity(products.get(i))
		
		
		
	}
		
	
	//OrderBean order = daoOrder.doSave(bean)
	
	%>
	
	
	
	
	
	
	
	
	
	
	
	<% 
	request.getSession().removeAttribute("cart");
	%>
	<% 
}

	%>
</body>
</html>