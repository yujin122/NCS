<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align= "center">
		<jsp:include page="../include/header.jsp" />
		<div class = "clear"></div>
		<br><br>
		<hr width = "50%" color = "skyblue">
			<h3>MVC-2 모델 방식의 BOARD 테이블 메인 페이지</h3>
		<hr width = "50%" color = "skyblue">
		<br><br><br>
		
		<a href = "${pageContext.request.contextPath }/board_list.do">[전체 게시물 목록]</a>
	
	</div>
</body>
</html>