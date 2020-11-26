<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	table {
		border : 1px solid #000;
		border-collapse: collapse;
		width : 400px;
	}
	
	th, td {
		border : 1px solid #000;
		border-collapse: collapse;
		text-align: center;
	}
	
</style>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "orange">
			<h3>BOARD 테이블 게시물</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<table>
		<c:set var="post" value = "${post }" />
		<c:if test="${!empty post }" >
			<tr>
				<th>작성자</th>
				<td>${post.getWriter() }</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${post.getTitle() }</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows = "7" cols = "30" name = "content" readonly>${post.getBoard_cont() }</textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				<c:forEach begin="1" end="${post.getBoard_pwd().length() }" step="1" var="i">
				*
				</c:forEach>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${post.getBoard_hit() }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${post.getRegdate() }</td>
			</tr>
		</c:if>
			<tr>
				<td colspan = "2" align = "center">
					<a href = "<%=request.getContextPath() %>/board_list.do">[전체 게시물]</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>