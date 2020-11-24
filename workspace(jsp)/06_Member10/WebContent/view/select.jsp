<%@page import="com.sist.model.Member10DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member10DTO> dto = (List<Member10DTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "violet">
			<h2>Member10 리스트</h2>
		<hr width = "50%" color = "violet">
		<br><br><br>
		
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>가입날짜</th>
			</tr>
				<%
					if(dto.size() != 0){
								for(int i = 0; i <dto.size(); i++){
									Member10DTO mem = new Member10DTO();
									
									mem = dto.get(i);
				%>
							<tr>
							<td><%=mem.getNum() %></td>
							<td><%=mem.getMemid() %></td>
							<td><a href = "<%=request.getContextPath()%>/content.do?no=<%=mem.getNum()%>"><%=mem.getMemname() %></a></td>
							<td><%=mem.getRegdate().substring(0, 10) %></td>
							</tr>
							<% 
						}
					}else {%>
						<tr>
						<td colspan = "4" align = "center"> <h3>레코드가 존재하지 않습니다.</h3></td>
						</tr>		
					<%}%>	
				<tr>
					<td colspan ="4" align = "right">
						<input type = "button" value = "회원등록"
						onclick = "location.href = 'view/member_write.jsp'">
					</td>
				</tr>	
		</table>
	</div>
</body>
</html>