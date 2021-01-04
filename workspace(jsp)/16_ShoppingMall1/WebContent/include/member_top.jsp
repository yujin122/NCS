<%@page import="com.shop.model.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CategoryDAO dao = CategoryDAO.getInstance(); 
	List<CategoryDTO> list = dao.getCategoryList();
	request.setAttribute("category", list);
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<table border = "1" cellspacing = "0" width = "800">
			<tr>
				<td colspan = "2" align = "center">
					<a href = "${pageContext.request.contextPath }/member_main.do">쇼핑몰 홈</a>
					<a href = "${pageContext.request.contextPath }/member_cart_list.do">장바구니</a>
					<a href = "#">${mem_name }님 환영합니다.</a>
					<a href = "${pageContext.request.contextPath }/member_logout.do">로그아웃</a>
				</td>
			</tr>
			<tr>
				<td width = "350" align = "center" valign = "top">
					<table cellspacing = "0">
						<c:set var = "list" value = "${category }" />
						<tr>
							<td>카테고리 코드</td>
						</tr>
						<c:if test="${!empty list }">
							<c:forEach items="${list }" var = "dto">
								<tr>
									<td>
										<a href = "member_category_list.do?code=${dto.getCategory_code() }">${dot.getCategory_name() }[${dto.getCategory_code() }]</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</td>
				<td>