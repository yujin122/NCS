<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여러 가지 관계 연산자</h1>
	<h2>
		\${10 == 10 } >>> ${10 == 10 }<br>
		\${10 eq 10 } >>> ${10 eq 10 }<br>
		\${"hello" == "hello" } >>> ${"hello" == "hello" }<br>
		
		\${20 != 10 } >>> ${20 != 10 }<br>
		<%-- \${20 ne 10 } >>> ${20 ne 10 }<br> --%>
		
		\${10 < 10 } >>> ${10 < 10 }<br>
		\${100 > 10 } >>> ${100 > 10 }<br>
		\${100 < 10 } >>> ${100 < 10 }<br>
		
	</h2>
</body>
</html>