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
			<h2>좋아하는 자동차 선택하기</h2>
		<hr width = "50%" color = "blue">
		
		<form method = "post" action = "choiceCar">
			<input type = "checkbox" name = "car" value = "images/car1.gif">제네시스
			<input type = "checkbox" name = "car" value = "images/car2.gif">소나타
			<input type = "checkbox" name = "car" value = "images/car3.gif">그랜져(HG)
			<input type = "checkbox" name = "car" value = "images/car4.gif">아반떼
			<input type = "checkbox" name = "car" value = "images/car5.gif">i30
			<br><br>
			<input type = "submit" value = "선택">
		</form>
		
	</div>
</body>
</html>