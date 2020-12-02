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
	<div align = "center">
		<hr width = "50%" color = "red">
			<h3>BOARD 테이블 전체 게시물 리스트</h3>
		<hr width = "50%" color = "red">
		<br><br><br>
		<table>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:set var = "list" value = "${list }" />
			<c:if test="${!empty list }">
				<c:forEach items = "${list }" var = "dto">
					<tr>
						<td>${dto.getBoard_no() }</td>
						<td><a href = "board_post.do?no=${dto.getBoard_no() }">${dto.getTitle() }</a></td>
						<td>${dto.getBoard_hit() }</td>
						<td>${dto.getRegdate().substring(0,10) }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan = "4" align = "center">
						<h3>검색된 레코드가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
		</table>
		
		<hr width = "50%" color = "blue">
		<br>
		<input type = "button" value = "글쓰기" onclick = "location.href = '<%=request.getContextPath() %>/board_write.do'">
		<br><br>
		<form method = "post" action = "board_search.do">
			<select name = "search">
				<option value = "title">제목</option>
				<option value = "writer">작성자</option>
				<option value = "cont">내용</option>
				<option value = "title_cont">제목+내용</option>
			</select>
			<input name = "text" size = "15">
			<input type = "submit" value = "검색"> 
		</form>
	</div>
</body>
</html>