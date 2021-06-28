<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="costumi.css" type="text/css">
<meta charset="ISO-8859-1">
<title>CostumeCharacter</title>
</head>
<body>

	<% ProductModelDS dao = new ProductModelDS(); 
	   ImageModelDS daoImg = new ImageModelDS();
	   ArrayList<ProductBean> bean = dao.doRetrieveAllByType("Costume");
	   ImageBean urlImage = new ImageBean();
	   
	%>
<%@ include file="header.html" %>   

	
	
		
		 <h1> COSTUMI </h1> <br> <br>
		<%
				for( int i=0;i<bean.size();i++) {
					ProductBean costume = bean.get(i);
							String s = "ProductPage.jsp" + "?idProduct="+costume.getId();
							urlImage = daoImg.doRetrieveMain(costume.getId());
							
							
			%>
          
             <a href=<%=s%>> <%=costume.getName() %>  <img src= "<%=urlImage.getUrl()%>"  alt="imgProduct" >    </a>  
                
          
		
				<%
				}
		
			%>
				
				
	

 

	
	
	
	
<%@ include file="footer.html" %>   
	


</body>
</html>