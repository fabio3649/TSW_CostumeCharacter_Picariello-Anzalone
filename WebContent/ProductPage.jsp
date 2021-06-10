<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*"%>
 

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
 
 <link rel="stylesheet" href="index.css" type="text/css"  >

<title> Page Product </title>
</head>
<body>
 <% int id =  Integer.parseInt(request.getParameter("idProduct"));
   ProductModelDS dao = new ProductModelDS();
   ProductBean bean = dao.doRetrieveByKey(id);
   ImageModelDS daoImg = new ImageModelDS();
   ArrayList<ImageBean> images= daoImg.doRetrieveAllByProduct(id);
  
	%>
	   
   <%@ include file="header.html" %>   		
		
	 <div class="container">
        
         
	 	
        
		<br><br><br><br><br><br>

		<% 
	  for(int i=0; i < images.size() ;i++)
	  {
		  %>
		  		<div class="item">
		 		<img src= "<%=images.get(i).getUrl()%>"  alt="img" >
		 		</div>
		 		<%
	  }
		  
		  		%>
		 
		
          <table  class="table">
               <tr> <td> <h1> <%=bean.getName() %> </h1> </td> <td > <a href="AddToCart?idProduct=<%=bean.getId()%>">
						 <button class="buttonADD" >ADD TO CART </button> </a> </td> </tr>
               <tr> <td> <h3> Details  </h3>  </td>  </tr>              	 
               <tr> <td> <p> <%=  bean.getDescription() %>  </p> </td> </tr>               	  
               <%if(!bean.getSize().equals("NULL")){ %>
               <tr> <td> <h3>  Size </h3>  </td> </tr>             	  
               <tr> <td> <p> <%= bean.getSize() %> </p>  </td>  </tr> 
               <%} %>
               <tr>  <td> <h3>  Price  </h3> </td> </tr>
               <tr>  <td> <p>  <%= bean.getPrice() %>$  </p> </td>  </tr>   			
		</table>	
	</div>
	
	<%@ include file="footer.html"%>
</body>
</html>