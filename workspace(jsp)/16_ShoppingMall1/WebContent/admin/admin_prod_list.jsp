<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%
	String imgPath = request.getContextPath()+"/upload/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../include/admin_top.jsp" />

	<div align = "center">
		<hr width = "50%" color = "blue">
			<h3>상품 리스트</h3>
		<hr width = "50%" color = "blue">
		<br>
		<table border = "1" cellspacing = "0" width = "700">
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>상품명</th>
				<th>제조사</th>
				<th>상품 이미지</th>
				<th>상품 수량</th>
				<th>상품 가격</th>
				<th>수정 | 삭제</th>
			</tr>		
			<c:set var = "list" value = "${list }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var = "prod">
				<tr>
					<td>${prod.getPnum() }</td>
					<td>${prod.getPcategory() }</td>
					<td>${prod.getPname() }</td>
					<td>${prod.getPcompany() }</td>
					<td><img src = "<%=imgPath %>${prod.getPimage() }" width = "60" height = "60"></td>
					<td>${prod.getPqty() }</td>
					<td><fmt:formatNumber value = "${prod.getPrice() }" />원 </td>
					<td>
						<a href = "admin_prod.edit.do?pnum=${prod.getPnum() }">수정</a>
						<a href = "admin_prod.delete.do?pnum=${prod.getPnum() }">삭제</a>
					</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
			<tr>
				<td colspan = "9" align = "center">카테고리가 없습니다.</td>
			</tr>
			</c:if>
		</table>
	</div>
	
	<jsp:include page="../include/admin_bottom.jsp" />
	
</body>
</html>