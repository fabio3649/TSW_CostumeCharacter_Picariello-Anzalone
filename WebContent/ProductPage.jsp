<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*"%>
 

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styleProductPage.css" type="text/css">


<title> Page Product </title>
</head>
<body>
 <% int id =  Integer.parseInt(request.getParameter("id"));
   ProductModelDS dao = new ProductModelDS();
   ProductBean bean = dao.doRetrieveByKey(id);
   
	   %>
	   
   <div id="header">
	    
	    <img src="/CostumeCharacter/images/logo.png" alt="logo">
	    
	      <div id="buttonPos">
		    <table align="right">
				    <tr>
				        <td>
				            <form action="CartView.jsp" method="post">
				                <input class="button" type="submit" value="Cart">
				            </form>
				        </td>
				        <td>
				            <form action="Catalog.jsp" method="post">
				                <input class="button" type="submit" value="Catalog">
				            </form>
				        </td>
				    </tr>
	            </table>
		    </div>
	  	</div>
	  		
		
	 <div id="container">
        
         
	 	<img  src= <%=bean.getUrlImage() %> alt="image"  >
        
		<br><br><br><br><br><br>

          <table  class="table">
               <tr> <td> <h1> <%=bean.getName() %> </h1> </td> <td > <a href="AddToCart?id=<%=bean.getId()%>"> <button class="buttonADD" >ADD TO CART </button> </a> </td> </tr>
               <tr> <td> <h3> Details  </h3>  </td>  </tr>              	 
               <tr> <td> <p> <%=  bean.getDescription() %>  </p> </td> </tr>               	  
               <%if(!bean.getSize().equals("NULL")){ %>
               <tr> <td> <h3>  Size </h3>  </td> </tr>             	  
               <tr> <td> <p> <%= bean.getSize() %> </p>  </td>  </tr> 
               <%} %>
               <tr>  <td> <h3>  Price  </h3> </td> </tr>
               <tr>  <td> <p>  <%= bean.getPrice() %>0 $  </p> </td>  </tr>   			
		</table>	
	</div>
</body>
</html>