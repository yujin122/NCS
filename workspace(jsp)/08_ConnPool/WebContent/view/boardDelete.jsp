<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "yellow">
			<h3>게시물 삭제 페이지</h3>
		<hr width = "50%" color = "yellow">
		<br><br><br>
		<form method = "post" action = "<%=request.getContextPath() %>/boardDelete">
			<input type = "hidden" name = "num" value = "<%=num %>">		
			<table border = "1" cellspacing = "0" width = "300">
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pwd">
				</tr>
				<tr>
					<td colspan = "2" align = "center">
					<input type = "submit" value = "삭제">
					<input type = "reset" value = "취소">
				</tr>
			</table>	
		</form>
	</div>
</body>
</html>