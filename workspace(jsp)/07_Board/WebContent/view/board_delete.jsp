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
		<hr width = "50%" color = "orange">
			<h3>BOARD 테이블 게시글 삭제 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		
		<form method = "post" action = "<%=request.getContextPath()%>/deleteOk.do">
		<input type = "hidden" value = <%=num%> name = "num">
			<table border = "1" cellspacing = "0" width = "400">
				<tr>
					<th>삭제할 비밀번호</th>
					<td><input type = "password" name = "pwd"></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type = "submit" value = "글삭제">
						&nbsp;&nbsp;&nbsp;
						<input type = "reset" value = "취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>