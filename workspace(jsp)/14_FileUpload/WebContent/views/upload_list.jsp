<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "blue">
			<h3>UPLOAD 테이블 전체 게시물 리스트</h3>
		<hr width = "50%" color = "blue">
		<br><br><br>
		<table border = "1" cellspacing = "0" width = "600">
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
						<td>${dto.getUpload_no() }</td>
						<td>
						<a href = "upload_cont.do?no=${dto.getUpload_no() }">${dto.getUpload_title() }</a>
						</td>
						<td>${dto.getUpload_hit() }</td>
						<td>${dto.getUpload_date().substring(0,10) }</td>
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
			<tr>
				<td colspan = "7" align = "right">
				<input type = "button" value = "글쓰기" 
				onclick = "location.href = '${pageContext.request.contextPath}/upload_write.do'">
			</tr>
		</table>
		<%-- <c:if test="${page > block }">
			<a href = "bbs_list.do?page=1">◀◀</a>
			<a href = "bbs_list.do?page=${startBlock-1 }">◀</a>
		</c:if>
		
		<c:forEach begin = "${startBlock }" end = "${endBlock }" step="1" var = "i">
			<c:if test="${i == page }">
				<b><a href = "bbs_list.do?page=${i }">${i }</a></b>
			</c:if>
			<c:if test="${i != page }">
				<a href = "bbs_list.do?page=${i }">${i }</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endBlock < allPage }">
			<a href = "bbs_list.do?page=${endBlock + 1 }">▶</a>
			<a href = "bbs_list.do?page=${allPage }">▶▶</a>
		</c:if> --%>
		<hr width = "50%" color = "blue">
		<br>
		<form method = "post" action = "upload_search.do">
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