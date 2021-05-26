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
		ProductBean bean = dao.doRetrieveByKey(1);
		bean.setId(14);
		dao.doSave(bean);
	%>
</body>
</html>