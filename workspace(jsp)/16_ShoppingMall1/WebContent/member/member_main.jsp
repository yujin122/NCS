<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "../include/member_top.jsp" />
	
		<div align = "center">
			<h3>쇼핑몰에 오신 것을 환영합니다.</h3>
		</div>
		<c:set var = "list" value = "${list }" />
		<c:if test="${empty list }">
			<c:set var = "str" value = "상품 목록이 없습니다."></c:set>
			<span>${str }</span><br>
		</c:if>
		<c:if test="${!empty list }">
			<hr width = "50%" color = "red">
				<h3 align = "center">상품 목록 리스트</h3>
			<hr width = "50%" color = "red">
			<br>
			<table border = "1" cellspacing = "0" align = "center">
				<tr>
					<c:forEach items="${list }" var = "dto">
						<c:set var = "cnt" value = "${cnt+1 }" />
						<td>
							<a href = "member_prod_view.do?pnum=${dto.getPnum() }">
								<img src = "${pageContext.request.contextPath }/upload/${dto.getPimage() }"
									width = "120" height = "120" border = "0">
							</a> <br>
							${dto.getPname() }<br>
							<fmt:formatNumber value = "${dto.getPrice() }" />원<br>
							<fmt:formatNumber value = "${dto.getPoint() }" var = "commaPoint" />
							[${commaPoint }] 포인트 <br>
						</td>
						
						<c:if test="${cnt%3 == 0 }">
							</tr>
							<tr>
						</c:if>	
					</c:forEach>
				</tr>

			</table>
		</c:if>
		
	<jsp:include page = "../include/member_bottom.jsp" />
</body>
</html>