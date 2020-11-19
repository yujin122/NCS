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
		out.println("----- getAttribute() 메서드 사용 결과 -----<br>");
	
		String id = (String)session.getAttribute("id");	
		String pwd = (String)session.getAttribute("pwd");
		
		out.println("session id : " + id + "<br>");
		out.println("session pwd : " + pwd + "<br><br>");
		
		out.println("----- 세션 유효 시간 사용 결과 -----<br>");
		
		int time = session.getMaxInactiveInterval();
		
		out.println("sessoin 유효 시간 : " + time + "<br><br>");
		
		out.println("----- removeAttribute() 메서드 사용 결과 -----<br>");
		
		session.removeAttribute("pwd");
		String p = (String)session.getAttribute("pwd");
		
		out.println("session pwd : " + p + "<br><br>");
		
	%>
	
</body>
</html>