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
		<hr width = "50%" color = "orange">
			<h3>BBS 테이블 게시물 상세내역 페이지</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<c:set var = "dto" value = "${dto }" />
		
			<table border = "1" cellspacing = "0" width = "400">
			<c:if test="${!empty dto }">
			<tr>
				<th>작성자</th>
				<td>${dto.getBoard_writer() }</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${dto.getBoard_title() }</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
				<textarea rows="7" cols="30" name = "content" readonly>${dto.getBoard_cont() }</textarea>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.getBoard_hit() }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.getBoard_date() }</td>
			</tr>
			<tr>
				<th>Group</th>
				<td>${dto.getBoard_group() }</td>
			</tr>
			<tr>
				<th>Step</th>
				<td>${dto.getBoard_step() }</td>
			</tr>
			<tr>
				<th>Indent</th>
				<td>${dto.getBoard_indent() }</td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "button" value = "수정"
					onclick = "location.href = '${pageContext.request.contextPath}/bbs_update_form.do?no=${dto.getBoard_no() }'">
					&nbsp;&nbsp;
					<input type = "button" value = "삭제"
					onclick = "location.href = '${pageContext.request.contextPath}/bbs_delete_form.do?no=${dto.getBoard_no() }'">
					&nbsp;&nbsp;
					<input type = "button" value = "답변"
					onclick = "location.href = '${pageContext.request.contextPath}/bbs_reply.do?no=${dto.getBoard_no() }'">
					&nbsp;&nbsp;
					<input type = "button" value = "전체목록"
					onclick = "location.href = '${pageContext.request.contextPath}/bbs_list.do'">
				</td>
			</tr>
			</c:if>
		</table>
		
	</div>
</body>
</html>