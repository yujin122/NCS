<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../include/member_top.jsp" />
	
	<table border = "1" cellspacing = "0" width = "600" align = "center">
		<tr>
			<td colspan = "7" align = "center">
				<h3>장바구니 보기</h3>
			</td>
		</tr>
		<tr>
			<th width = "10%">번호</th>
			<th width = "10%">상품 번호</th>
			<th width = "10%">상품명</th>
			<th width = "10%">수량</th>
			<th width = "10%">단가</th>
			<th width = "10%">합계</th>
			<th width = "10%">삭제</th>
		</tr>
		<c:set var = "list" value = "${list }" />
		<c:if test="${!empty list }">
			<c:forEach items="${list }" var = "dto">
				<tr>
					<td>${dto.getCart_num() }</td>
					<td>${dto.getCart_pnum() }</td>
					<td><img src = "${pageContext.request.contextPath }/upload/${dto.getCart_pimage() }"
							width = "50" height = "50"> <br>${dto.getCart_pname() }</td>
					<td>${dto.getCart_pqty() }</td>
					<td><fmt:formatNumber value = "${dto.getCart_price() }" />원</td>
					<td>
						<c:set var = "price" value = "${dto.getCart_price() }" />
						<c:set var = "qty" value = "${dto.getCart_pqty() }" />
						<fmt:formatNumber value = "${price * qty }" />
					</td>
					<td>
					<a href = "member_cart_delete.do?num=${dto.getCart_num() }">삭제</a>
					</td>
				</tr>
				<c:set var = "total" value = "${total + (price*qty) }" />
			</c:forEach>
			<tr>
				<td colspan = "4" align = "right">
					<b><font color = "red">장바구니 총액 : <fmt:formatNumber value = "${total }" />원 </font></b>
				</td>
				<td colspan = "3" align = "center">
					<a href = "#">주문하기</a>&nbsp;&nbsp;&nbsp;
					<a href = "javascript:history.go(-2);">계속 쇼핑</a>
				</td>
			</tr>
		</c:if>
		<c:if test="${empty list }">
			<tr>
				<td colspan = "7" align = "center">
					<h3>장바구니가 비었습니다.</h3>
				</td>
			</tr>
		</c:if>
	</table>
	
	
	<jsp:include page="../include/member_bottom.jsp" />
	
</body>
</html>