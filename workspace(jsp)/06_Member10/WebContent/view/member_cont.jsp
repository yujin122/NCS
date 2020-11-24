<%@page import="com.sist.model.Member10DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member10DTO dto = (Member10DTO)request.getAttribute("cont");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align = "center">
		<hr width = "50%" color = "red">
			<h3>MEMBER10 테이블 회원 상세 정보</h3>
		<hr width = "50%" color = "red">
		<br><br><br>
		
		<table border = "1" cellspacing = "0" width = "400">
			<%
				if(dto != null){
					%>
					<tr>
						<th>회원번호</th>
						<td><%=dto.getNum()%></td>
					</tr>
					<tr>
						<th>회원아이디</th>
						<td><%=dto.getMemid()%></td>
					</tr>
					<tr>
						<th>회원이름</th>
						<td><%=dto.getMemname()%></td>
					</tr>
					<tr>
						<th>회원비밀번호</th>
						<td>
							<%
								if(dto.getPwd().length() != 0){
									for(int i=1;i<dto.getPwd().length();i++){
										%>
										*
										<%
									}
								}
							%>
							</td>
					</tr>
					<tr>
						<th>회원나이</th>
						<td><%=dto.getAge()%></td>
					</tr>
					<tr>
						<th>회원마일리지</th>
						<td><%=dto.getMileage()%></td>
					</tr>
					<tr>
						<th>회원직업</th>
						<td><%=dto.getJob()%></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><%=dto.getAddr()%></td>
					</tr>
					<%
				}else {
					%>
					<tr>
						<td colspan = "2" align = "center">
							<h3>검색된 레코드가 없습니다.</h3>
						</td>
					</tr>
					<%
				}
			%>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "button" value = "회원 수정" 
					onclick = "location.href = '<%=request.getContextPath() %>/update.do?no=<%=dto.getNum()%>'">
					<input type = "button" value = "회원 삭제"
					 onclick = "if(confirm('삭제 하시겠습니까?')){
						 location.href = '<%=request.getContextPath() %>/delete.do?no=<%=dto.getNum()%>'
					 }else {return;}">
					 <!-- 자바스크립트에서 window 객체 하위의 confirm() 메서드는
					 확인/ 취소 버튼을 가진 경고창을 만들어 줌. 확인버튼을 클릭하면 반환값으로
					 true를 리턴하고 취소버튼을 클릭하면 반환값으로 false를 리턴함
					 즉, 삭제 유무를 다시 한번 확인하기 위해서 주로 사용 -->
				</td>
			</tr>
		</table>
	</div>
</body>
</html>