<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/table.css">
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "violet">
			<h2>Member10 검색 리스트</h2>
		<hr width = "50%" color = "violet">
		<br><br><br>
		
		<table>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>가입날짜</th>
			</tr>
			<c:set var = "list" value = "${search }"/>
				<c:if test="${!empty list }">
					<c:forEach items="${list }" var="mem">
						<tr>
							<td>${mem.getNum() }</td>
							<td>${mem.getMemid() }</td>
							<td><a href = "${pageContext.request.contextPath }/member_info.do?no=${mem.getNum()}">${mem.getMemname() }</a></td>
							<td>${mem.getRegdate().substring(0, 10) }</td>
						</tr>
				</c:forEach>
				</c:if>
				<c:if test="${empty search }">
					<tr>
						<td colspan = "4" align = "center"> <h3>레코드가 존재하지 않습니다.</h3></td>
					</tr>	
				</c:if>
		</table>
		<hr width = "50%" color = "violet">
		<br><br>
		<a href = "${pageContext.request.contextPath }/member_list.do">[전체 리스트]</a>
	</div>
</body>
</html>