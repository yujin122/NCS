<%@page import="com.conn.model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "tomato">
			<h2>Board 전체 리스트</h2>
		<hr width = "50%" color = "tomato">
		<br><br><br>
		<table border = "1" cellspacing = "0" width = "450">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<%
				if(list.size() != 0){
					for(int i = 0; i <list.size(); i++){
						BoardDTO dto = new BoardDTO();
						
						dto = list.get(i);
						%>
						<tr>
							<td><%=dto.getNum() %></td>
							<td><a href = "<%=request.getContextPath()%>/boardPost?no=<%=dto.getNum() %>"><%=dto.getTitle() %></a></td>
							<td><%=dto.getWriter() %></td>
							<td><%=dto.getHit() %></td>
							<td><%=dto.getRegdate() %>
						</tr>
						<%
					}
				}else {
					%>
					<tr>
					<td colspan = "5">
						<h3>게시물이 존재하지 않습니다.</h3>
					</td>
					</tr>
					<%
				}
			%>
			<tr	align = "right">
				<td colspan = "5">
				<input type = "button" onclick = "location.href = 'view/boardWrite.jsp'" value = "글쓰기">
			</tr>
		</table>
		<br>
		<form method = "post" action = "<%=request.getContextPath() %>/boardSearch">
		<div align = "center">
			<select name = "category">
				<option value = "title">제목</option>
				<option value = "writer">작성자</option>
				<option value = "content">내용</option>
				<option value = "title_content">제목+내용</option>
			</select>
			<input type = "text" name = "search" size = "15">
			<input type = "submit" value = "검색">
		</div>
		</form>
	</div>
</body>
</html>