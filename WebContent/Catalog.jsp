<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*,control.*" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="index.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Catalog</title>
</head>
<body>

	<% ProductModelDS dao = new ProductModelDS(); 
	   ImageModelDS daoImg = new ImageModelDS();
	   ArrayList<ProductBean> bean = dao.doRetrieveAllByType("Costume");
	   ArrayList<ProductBean> bean2 = dao.doRetrieveAllByType("Maschera");
	   ImageBean urlImage = new ImageBean();
	   
	%>
<%@ include file="header.html" %>   

	
	<div class="container">
	
		<%
		
		
		if ( Integer.parseInt(request.getParameter("type")) == 1) // se id = 1 allora mostra solo i costumi
		%> <h1> COSTUMI </h1> <br> <br>
		<%
			{
			ArrayList<ProductBean> temp = new ArrayList<ProductBean>();
				for( int i=0;i<bean.size();i++)
				{
					ProductBean costume = bean.get(i);
					String s = "ProductPage.jsp" + "?idProduct="+costume.getId();
					urlImage = daoImg.doRetrieveMain(costume.getId());
					if(costume.getName().equals(temp.get(i).getName()))
					{
						costume.setSize(costume.getSize().concat(" ").concat(temp.get(i).getSize()));
												
					}
					else temp.add(costume);
		%>
		

			
          <div class="item">
             <a href=<%=s%>> <%=temp.get(i).getName() %> <%= temp.get(i).getSize() %> <img src= "<%=urlImage.getUrl()%>"  alt="imgProduct" >    </a>  
                
          </div>
		
				<%
				}
				%>
				</div>
				<%
			}
				%>
	

 

	
	
	
	

	


<%@ include file="footer.html"%>
</body>
</html>