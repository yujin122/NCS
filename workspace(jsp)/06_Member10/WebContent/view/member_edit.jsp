<%@page import="com.sist.model.Member10DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member10DTO dto = (Member10DTO)request.getAttribute("edit");
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
			<h3>MEMBER10 테이블 회원 수정 폼</h3>
		<hr width = "50%" color = "gray">
		<br><br><br>
		
		<form method = "post" action = "<%=request.getContextPath() %>/updateOk.do">
			<input type = "hidden" name = "num" value = <%=dto.getNum() %>>
			<table border = "1" cellsapcing = "0" width = "400">
				<tr>
					<th>회원아이디</th>
					<td><input type = "text" name = "mem_id"
					value = "<%=dto.getMemid() %>" readonly></td>
				</tr>
				<tr>
					<th>회원이름</th>
					<td><input type = "text" name = "mem_name"
					value = "<%=dto.getMemname() %>" readonly></td>
				</tr>
				<tr>
					<th>회원비밀번호</th>
					<td><input type = "password" name = "mem_pwd"
					value = "<%=dto.getPwd() %>"></td>
				</tr>
				<tr>
					<th>회원나이</th>
					<td><input type = "text" name = "mem_age"
					value = "<%=dto.getAge() %>"></td>
				</tr>
				<tr>
					<th>회원마일리지</th>
					<td><input type = "text" name = "mem_mileage"
					value = "<%=dto.getMileage()%>"></td>
				</tr>
				<tr>
					<th>회원직업</th>
					<td><input type = "text" name = "mem_job"
					value = "<%=dto.getJob() %>"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type = "text" name = "mem_addr"
					value = "<%=dto.getAddr() %>"></td>
				</tr>
				<tr>
					<td colspan = "7" align = "center">
						<input type = "submit" value = "회원수정">
						&nbsp;&nbsp;&nbsp;
						<input type = "reset" value = "다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>