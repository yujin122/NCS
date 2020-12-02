<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "../css/table.css">
</head>
<body>
	
	<div id = "top_login">
		<ul>
			<li><a href = "./views/main.jsp">홈</a> </li>
			<li><a href = "${pageContext.request.contextPath }/login.do">${name }님</a> </li>
			<li><a href = "${pageContext.request.contextPath }/join.do">회원가입</a> </li>
			<li><a href = "${pageContext.request.contextPath }/logout.do">로그아웃</a> </li>
		</ul>
	</div>
</body>
</html>