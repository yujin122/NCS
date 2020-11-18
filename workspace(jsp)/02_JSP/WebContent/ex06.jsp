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
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		// 원래 DB에서 id와 pwd가 맞는 회원인지 여부를 확인 후
		// 회원이면 메인 페이지로 이동
		
		String dbId = "hong";
		String dbPwd = "1234";
		
		if(id.equals(dbId)){
			if(pwd.equals(dbPwd)){
				request.setAttribute("name", "세종대왕");
				request.setAttribute("addr", "서울시 마포구");
				// 실제로 페이지 이동
				response.sendRedirect("ex07.jsp");
			}
			else{
				out.println("비밀번호가 틀렸습니다.");
			}
		}else{
			out.println("아이디가 틀렸습니다.");
		}
	%>
	
</body>
</html>