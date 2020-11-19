<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 세션 설정
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
	
	%>

	id와 pwd 세션 속성 설정 완료 <br>
	
	<script type="text/javascript">
		location.href = "ex02_2.jsp";
		
	</script>
	
</body>
</html>