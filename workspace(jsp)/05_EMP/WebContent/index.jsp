<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align = "center">
		<hr width = "50%" color = "blue">
			<h2>EMP 테이블 메인 페이지</h2>
		<hr width = "50%" color = "blue">
		<br><br><br>
		
		<!-- request.getContextPath() : 현재 프로젝트 명을 반환하는 메서드 -->
		<a href = "<%=request.getContextPath()%>/select">[전체 레코드]</a>
		
	</div>
	
</body>
</html>