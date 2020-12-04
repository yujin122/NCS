<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포맷팅 태그 라이브러리 사용하기</title>
</head>
<body>
	
	<%-- 
		포맷팅 라이브러리 종류
		- <fmt:timeZone> : 지정한 국가의 시간을 지정하는 태그
						      태그를 열고 닫는 영역에서만 적용이 됨.
		- <fmt:setTimeZone> : 지정한 국가의 시간을 지정하는 태그 
		- <fmt:formatNumber> : 표시할 숫자의 형식을 지정
		- <frm:formatDate> : 지정한 형식의 날짜를 표시
	 --%>
	
	<%--
		<fmt:formatNumber> 태그의 여러 가지 속성
		- value : 출력될 숫자의 형식 지정
		- type : 출력될 타입을 지정
				 * percent : %
				 * number : 숫자
				 * currency : 통화 형식
		- currencyCode :  통화 코드를 지정함. 한국 원하는 KRW임.
		- currencySymbol : 통화를 표시할 때 기호를 표시
		- var : <formatNumber> 태그의 결과를 저장할 변수 이름 지정
		- scope : 변수의 접근 범위 지정
		- pattern : 숫자가 출력될 양식을 지정
	 --%>
	 
	 <div align = "center">
	 	<hr width = "50%" color = "blue">
	 		<h3>커피 주문</h3>
	 	<hr width = "50%" color = "blue">
	 	<br><br>
	 	<form method = "post" action = "ex03.jsp">
	 		<table boerder = "1" cellspacing = "0" width = "400">
	 			<tr>
	 				<th>커피종류</th>
	 				<td>
	 					<select name = "coffee_str">
	 						<option value = "1">아메리카노 - 3,0000원</option>
	 						<option value = "2">카페라떼 - 3,5000원</option>
	 						<option value = "3">카푸치노 - 4,0000원</option>
	 						<option value = "4">카라멜마끼아또 - 4,5000원</option>
	 					</select>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>수량</th>
	 				<td><input type = "number" min = "1" max = "20" name = "num"></td>
	 			</tr>
	 			<tr>
	 				<td colspan = "2" align= "center">
	 					<input type = "submit" value = "계산">
	 					<input type = "reset" value = "취소">
	 				</td>
	 			</tr>
	 		</table>
	 	
	 	</form>
	 </div>
	 
</body>
</html>