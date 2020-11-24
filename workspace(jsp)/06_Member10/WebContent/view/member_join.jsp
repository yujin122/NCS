<%@page import="com.sist.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class = "com.sist.model.Member10DTO" scope = "request" />
<jsp:setProperty property="*" name="member"/>    
<%
	MemberDAO dao = MemberDAO.getInstance();
	dao.insertMem(member);
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