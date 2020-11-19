<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:forward page="ex02_1.jsp">
		<jsp:param value="test1234" name="id"/>
		<jsp:param value="1234" name="pwd"/>
	</jsp:forward>
	
	
</body>
</html>