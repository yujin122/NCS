<%@page import="com.board2.model.BoardDTO"%>
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
		<hr width = "50%" color = "blue">
			<h3>BOARD 리스트</h3>
		<hr width = "50%" color = "blue">
		<table border = "1" cellspacing = "0" width = "500">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<%
				if(list.size() != 0){
					for(int i = 0; i < list.size(); i++){
						BoardDTO dto = new BoardDTO();
						
						dto = list.get(i);
						%>
						<tr>
							<td><%=dto.getBoard_no() %></td>
							<td><a href = "<%=request.getContextPath()%>/boardPost?no=<%=dto.getBoard_no() %>"><%=dto.getTitle() %></a></td>
							<td><%=dto.getBoard_hit() %></td>
							<td><%=dto.getRegdate() %></td>
						</tr>
						<%
					}
				}else { %>
					<tr>
						<td colspan = "4" align = "center">
							<h3>게시물이 존재하지 않습니다.</h3>
						</td>
					</tr>
					<% 
				}
			%>
		</table>
		<br>
		<hr width = "50%">
			<br>
			<input type= "button" value = "글쓰기"
				onclick = "location.href = 'view/board_write.jsp'">
		<br><br>
		
		<form method = "post" action = "<%=request.getContextPath()%>/search.do">
			<select name = "find_field">
				<option value = "title">제목</option>
				<option value = "cont">내용</option>
				<option value = "title_cont">제목+내용</option>
			</select>
			<input type = "text" name = "find_name" size = "15">
			<input type = "submit" value = "검색">
		</form>		
	</div>
</body>
</html>