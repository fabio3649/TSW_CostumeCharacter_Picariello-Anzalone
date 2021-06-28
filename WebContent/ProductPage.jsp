<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*"%>
 

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
 
<link rel="stylesheet" href="styleProductPage.css" type="text/css"  >

	
<title> Product </title>
</head>
<body>



 <% int id =  Integer.parseInt(request.getParameter("idProduct"));
   ProductModelDS dao = new ProductModelDS();
   ProductBean bean = dao.doRetrieveByKey(id);
   ImageModelDS daoImg = new ImageModelDS();
   ArrayList<ImageBean> images= daoImg.doRetrieveAllByProduct(id);
   ImageBean mainImage = daoImg.doRetrieveMain(id);
   ArrayList<ProductBean> products = dao.doRetrieveAllByName(bean.getName());
   String size = "";
   request.getSession().setAttribute("product",id);
   
  
	%>
	   
   <%@ include file="header.html" %>  
    		
		<div class="user">
	        <ul>
              <li> <a href="Login.jsp"> <img src="\CostumeCharacter\\images\user.png" alt="user"  > </a> </li>
              <li> <a href="CartView.jsp"> <img src="\CostumeCharacter\\images\cart.png" alt="cart"  > </a> </li>
            </ul>
        </div>
         
	 	<div class="small-container">
	 		<div class="row">
	 			<div class="col-2">
	 				<img src="<%=mainImage.getUrl() %>" alt="img" id="ProductImg" > 
	 				
	 				
	 			</div>
	 	    </div>
	 			<div class="col-2">
	 			<h6> <%=bean.getName() %> </h6>
	 			<p> <%=  bean.getDescription() %> </p>
	 			<h4> <%= bean.getPrice() %>&#8364 <br><br> Iva inclusa  </h4>
	 			
	 			<%if(!bean.getSize().equals("NULL")){ %>
                <h3 >  Size </h3> 
                <form action="AddToCart" method="get">           	  
	                 <select name="size">
	                 		<option> Select Size </option>
	                 		<%
	                 		for( int i=0;i<products.size();i++){
	                 			
	                 		   size = products.get(i).getSize();
	                 		   %>
	                 		   <option value="<%=size%>"> <%=size %> </option>
	                          <%} } %>
	                 </select>
                		 <input type="number" value="1"> 
                 <%
                 
                 
                 
                 %>
                 	<input type="submit" class="btn" value="Add to Cart"></input>
                 </form>
                 <h3></h3>
              <a href="">   <h5> Guida alle taglie </h5>  </a>
	 		 </div>
	 		<div class="small-img-row">	
	 				 <%
						  for(int i=0; i < images.size() ;i++)
						  {
					 %>
		  				   <div class="small-img-col">
			               		<img src= "<%=images.get(i).getUrl()%>"  width="100%" alt="img" class="small-img"> 
		 		           </div>
		 		         <%
						  }
		  
		  		           %>
	 					
	 	    </div>
	 	    
	    </div>
	 		
        
		<br><br><br><br><br><br>
	
		  		
		 		
<%@ include file="footer.html" %> 
	

</body>
</html>