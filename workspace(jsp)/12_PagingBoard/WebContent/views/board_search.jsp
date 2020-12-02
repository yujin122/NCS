<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "./css/table.css">
</head>
<body>
	
	<div align= "center">
		<jsp:include page="../include/header.jsp" />
		<div class = "clear"></div>
		<br>
		<hr width = "50%" color = "red">
			<h3>MVC-2 모델 BOARD 테이블 게시물 검색 리스트</h3>
		<hr width = "50%" color = "red">
		<br><br>
		<table>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:set var = "list" value = "${list }" />
			<c:if test="${!empty list }">
			<c:forEach items="${list }" var = "dto">
				<tr>
					<td>${dto.getBoard_no() }</td>
					<td><a href = "board_searchCont.do?no=${dto.getBoard_no() }&page=${page }&find_field=${find_field }&find_name=${find_name }">${dto.getTitle() }</a></td>
					<td>${dto.getBoard_hit() }</td>
					<td>${dto.getRegdate().substring(0,10) }</td>
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan = "4" align = "center">
						<h3>게시물이 없습니다.</h3>
					</td>
				</tr>
			</c:if>

		</table>
		<c:if test="${page > block }">
			<a href = "board_search.do?page=1&find_field=${find_field }&find_name=${find_name }">◀◀</a>
			<a href = "board_search.do?page=${startBlock-1 }&find_field=${find_field }&find_name=${find_name }">◀</a>
		</c:if>
		
		<c:forEach begin = "${startBlock }" end = "${endBlock }" step="1" var = "i">
			<c:if test="${i == page }">
				<b><a href = "board_search.do?page=${i }&find_field=${find_field }&find_name=${find_name }">${i }</a></b>
			</c:if>
			<c:if test="${i != page }">
				<a href = "board_search.do?page=${i }&find_field=${find_field }&find_name=${find_name }">${i }</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endBlock < allPage }">
			<a href = "board_search.do?page=${endBlock + 1 }&find_field=${find_field }&find_name=${find_name }">▶</a>
			<a href = "board_list.do?page=${allPage }&find_field=${find_field }&find_name=${find_name }">▶▶</a>
		</c:if>
		<a href = "board_list.do">[전체 리스트]</a>
	</div>
</body>
</html>