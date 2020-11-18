<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("id").trim();
	String userPwd = request.getParameter("pwd").trim();
	String name = request.getParameter("name").trim();
	String gender = request.getParameter("gender").trim();
	String addr = request.getParameter("addr").trim();
	String email = request.getParameter("email").trim();
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align = "center">
		<hr width = "50%" color = "gray">
			<h2>가입 회원 정보</h2>
		<hr width = "50%" color = "gray">
		<table border = "1" cellspacing = "0" width = "400">
				<tr>
					<th>아이디</th>
					<td><%=userId %></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><%=userPwd %></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><%=name %></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><%=gender %></td>
				</tr>
				<tr>
					<th>거주지</th>
					<td><%=addr %></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><%=email %></td>
				</tr>
			</table>
	</div>
	
	
</body>
</html>