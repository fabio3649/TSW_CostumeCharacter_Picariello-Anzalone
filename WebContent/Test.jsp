<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="model.*,java.util.*, java.sql.Date "  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <% 
  

  ProductModelDS dao = new ProductModelDS();
  ImageModelDS daoImg = new ImageModelDS();
  ArrayList<ImageBean> imgIronMan = daoImg.doRetrieveAllByProduct(6);
 
  %>
   
  <% 
  for(int i=0; i < imgIronMan.size() ;i++)
  {
	  %>
	  
	 		<img src ="<%=imgIronMan.get(i).getUrl()%>" alt="image" height="300px" width="300px" > <br> <br>
	 		<%
  }
	  
	  		%>
	
	  
</body>
</html>