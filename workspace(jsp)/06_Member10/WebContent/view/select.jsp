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
		
		<table border = "1" cellspacing = "0" width = "700">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>나이</th>
				<th>마일리지</th>
				<th>직업</th>
				<th>주소</th>
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
							<td><%=mem.getMemname() %></td>
							<td><%
								if(mem.getPwd().length() != 0){
									for(int j=1; j<= mem.getPwd().length(); j++){
								%>	
										*
										<%
									}
								}
							%></td>
							<td><%=mem.getAge() %></td>
							<td><%=mem.getMileage() %></td>
							<td><%=mem.getJob() %></td>
							<td><%=mem.getAddr() %></td>
							<td><%=mem.getRegdate().substring(0, 10) %></td>
							</tr>
							<% 
						}
					}else {%>
						<tr>
						<td colspan = "9" align = "center"> <h3>레코드가 존재하지 않습니다.</h3></td>
						</tr>		
					<%}%>	
				<tr>
					<td colspan ="9" align = "right">
						<input type = "button" value = "회원등록"
						onclick = "location.href = 'view/member_write.jsp'">
					</td>
				</tr>	
		</table>
	</div>
</body>
</html>