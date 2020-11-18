<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 클라이언트 폼 페이지에서 넘어온 데이터를 처리해 주면 됨
	String userId = request.getParameter("id").trim();
	String userPwd = request.getParameter("pwd").trim();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>
		아이디 : <%=userId %>
		비밀번호 : <%=userPwd %>
	</h2>
</body>
</html>