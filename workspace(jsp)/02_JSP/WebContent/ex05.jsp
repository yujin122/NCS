<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>
		아이디 : <%=request.getParameter("id") %>
		비밀번호 : <%=request.getParameter("pwd") %>
		이름 : <%=request.getAttribute("name") %>
		거주지 : <%=request.getAttribute("addr") %>
	</h2>
	
</body>
</html>