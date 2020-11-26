<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

/* 	String user_id = request.getParameter("id").trim();
	String user_name = request.getParameter("name").trim();
	String age = request.getParameter("age").trim(); */
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	

	<%--<div align = "center">
		<table border = "1" cellspacing = "0" width = "300">
			<tr>
				<th>아이디</th>
				<td><%=request.getParameter("id").trim() %></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=request.getParameter("name").trim() %></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><%=request.getParameter("age").trim() %></td>
			</tr>
		</table>
	</div> --%>
	
	<div align = "center">
		<h2>표현언어(EL)로 파라미터 값 출력하는 방법</h2>
		<table border = "1" cellspacing = "0" width = "300">
			<tr>
				<th>아이디</th>
				<td>${param.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${param.name }</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${param.age }</td>
			</tr>
		</table>
	</div>
</body>
</html>