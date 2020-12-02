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
		<hr width = "50%" color = "green">
			<h3>MVC-2 모델 게시판 게시글 상세 내역</h3>
		<hr width = "50%" color = "green">
		
		<table>
			<c:set var = "dto" value = "${dto }" />
			<c:if test="${!empty dto }">
				<tr>
					<th>작성자</th>
					<td>${dto.getWriter() }</td>
				</tr>
				<tr>
					<th>글제목</th>
					<td>${dto.getTitle() }</td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="7" cols="30" readonly>${dto.getBoard_cont() }</textarea></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${dto.getBoard_hit() }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${dto.getRegdate() }</td>
				</tr>
			</c:if>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "button" value = "글수정" 
					onclick = "location.href = 'board_edit.do?no=${dto.getBoard_no() }&page=${page}'">
					<input type = "button" value = "글삭제"
					onclick = "location.href = 'board_delete.do?no=${dto.getBoard_no() }&page=${page}'">
					<input type = "button" value = "전체 리스트"
					onclick = "location.href = 'board_list.do?no=${dto.getBoard_no() }&page=${page}'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>