<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>표현 언어로 여러 가지 데이터 출력하기</h1>
	<h2>
		\${100 }>>> ${100 }<br>
		\${"안녕하세요" } >>> ${"안녕하세요" }<br>
		\${10+1 } >>> ${10+1 } <br>
		<!-- 문자열과 숫자가 더해질 때는 결합이 아니라
			  문자열을 우선 숫자로 변환한 뒤 더해진다. -->
		\${"10""+1 } >>> ${"10"+1 } <br>
		
	</h2>
	
</body>
</html>