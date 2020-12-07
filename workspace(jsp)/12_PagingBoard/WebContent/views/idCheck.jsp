<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.board2.model.*" %>
<%
	String userId = request.getParameter("userId");
	
	MemberDAO dao = MemberDAO.getInstance();
	int res = dao.checkMemberId(userId);
	
	out.println(res);
	out.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>