<%@page import="com.conn.model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDTO> search = (List<BoardDTO>)request.getAttribute("search");
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
			<h2>게시판 검색 결과</h2>
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
				if(search.size() != 0){
					for(int i = 0; i <search.size(); i++){
						BoardDTO dto = new BoardDTO();
						
						dto = search.get(i);
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
		</table>
		<br>
		<input type= "button" value = "전체목록"
				onclick = "location.href = 'boardList'">
		<br><br>
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