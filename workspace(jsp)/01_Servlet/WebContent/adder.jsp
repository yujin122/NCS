<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>두 수 더하기(web.xml 파일에 등록)</h2>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<%-- 입력된 데이터를 서블릿 매핑 이름이 adder1인 서블릿으로 전송 --%>
	<%-- method 속성이 없으면 method = "get" 방식임. --%>
	<form method = "get" action = "adder1">
		<%-- 텍스트 박스에 입력된 첫번째 숫자를 num1이라는 변수에 저장하여
		 서블릿으로 전송을 함. --%>
		<p>첫번 째 수 : <input type = "text" name = "num1"></p>
		<%-- 텍스트 박스에 입력된 첫번째 숫자를 num2이라는 변수에 저장하여
		 서블릿으로 전송을 함. --%>
		<p>두번 째 수 : <input type = "text" name = "num2"></p>
		<input type = "submit" value = "더하기">
	</form>
	
	<hr>
	
	<h2>두 수 더하기(애노테이션(1:1) 등록)</h2>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<%-- 입력된 데이터를 서블릿 매핑 이름이 adder1인 서블릿으로 전송 --%>
	<form method = "post" action = "adder2">
		<%-- 텍스트 박스에 입력된 첫번째 숫자를 num1이라는 변수에 저장하여
		 서블릿으로 전송을 함. --%>
		<p>첫번 째 수 : <input type = "text" name = "num1"></p>
		<%-- 텍스트 박스에 입력된 첫번째 숫자를 num2이라는 변수에 저장하여
		 서블릿으로 전송을 함. --%>
		<p>두번 째 수 : <input type = "text" name = "num2"></p>
		<input type = "submit" value = "더하기">
	</form>
	
</body>
</html>