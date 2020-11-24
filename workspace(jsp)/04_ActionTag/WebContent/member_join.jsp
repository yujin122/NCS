<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class = "com.sist.model.MemberDTO" scope = "request" />
<%-- <jsp:setProperty property="memid" name="member"/>
<jsp:setProperty property="memname" name="member"/>
<jsp:setProperty property="pwd" name="member"/>
<jsp:setProperty property="age" name="member"/>
<jsp:setProperty property="mileage" name="member"/>
<jsp:setProperty property="job" name="member"/>
<jsp:setProperty property="addr" name="member"/> --%>

<jsp:setProperty property="*" name="member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입이 되었습니다.</h2>
	
	<h3><%=member.getMemid() %>님의 회원 정보 입니다.</h3>
	<table border = "1" cellspacing = "0">
		<tr>
			<th>아이디</th>
			<td><%=member.getMemid() %>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=member.getMemname() %>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=member.getPwd() %>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=member.getAge() %>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><%=member.getMileage() %>
		</tr>
		<tr>
			<th>직업</th>
			<td><%=member.getJob() %>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=member.getAddr() %>
		</tr>
	</table>
</body>
</html>