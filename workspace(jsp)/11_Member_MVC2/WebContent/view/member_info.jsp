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
		<hr width = "50%" color = "red">
			<h3>MEMBER10 테이블 회원 상세 정보</h3>
		<hr width = "50%" color = "red">
		<br><br><br>
		
		<table>
			<c:set var="dto" value="${info }" />
			<c:if test="${!empty dto }">
				<tr>
					<th>회원번호</th>
					<td>${dto.getNum() }</td>
				</tr>
				<tr>
					<th>회원아이디</th>
					<td>${dto.getMemid() }</td>
				</tr>
				<tr>
					<th>회원이름</th>
					<td>${dto.getMemname() }</td>
				</tr>
				<tr>
					<th>회원비밀번호</th>
					<td><c:forEach begin="1" end="${dto.getPwd().length() }"
							step="1" var="i">
						*
						</c:forEach></td>
				</tr>
				<tr>
					<th>회원나이</th>
					<td>${dto.getAge() }</td>
				</tr>
				<tr>
					<th>회원마일리지</th>
					<td>${dto.getMileage() }</td>
				</tr>
				<tr>
					<th>회원직업</th>
					<td>${dto.getJob() }</td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td>${dto.getAddr() }</td>
				</tr>
			</c:if>
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>검색된 레코드가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "button" value = "회원 수정" 
					onclick = "location.href = '${pageContext.request.contextPath }/member_update.do?no=${dto.getNum() }'">
					<input type = "button" value = "회원 삭제"
					 onclick = "location.href = '${pageContext.request.contextPath }/member_delete.do?no=${dto.getNum() }'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>