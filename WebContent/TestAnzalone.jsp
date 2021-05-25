<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  ProductModelDS dao = new ProductModelDS(); 
		ProductBean bean = new ProductBean();
		bean.setId(11);
		dao.doSave(bean);
	%>
</body>
</html>