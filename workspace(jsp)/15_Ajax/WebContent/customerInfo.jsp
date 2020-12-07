<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	span {
		width : 150px;
		color : red;
	}
	
	input {
		border : 1px solid gray;
	}
	
	table {
		width : 80%;
	}
	
	th, td {
		border : 1px solid gray;
		text-align : center;
		padding : 3px;
	}
	
</style>
<script type="text/javascript" src = "http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src = "js/customer.js"></script>
</head>
<body>

	<div align = "center">
		<hr width = "50%">
			<h3>회원 정보 입력</h3>
		<hr width = "50%">
		<br><br><br>
		<form name = "form" id = "form" method = "post">
			<table cellspacing = "0">
				<tr bgcolor = "pink">
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>전화번호</th>
					<th>주소</th>
				</tr>
				<tr>
					<td>
					<input type = "text" name = "id" id = "id" size = "10">
					<span>중복 결과 여부</span>
					</td>
					<td><input type = "text" name = "name" id = "name" size = "10"></td>
					<td><input type = "text" name = "age" id = "age" size = "3"></td>
					<td><input type = "text" name = "tel" id = "tel" size = "20"></td>
					<td><input type = "text" name = "addr" id = "addr" size = "30"></td>
				</tr>
				<tr>
					<td colspan = "5" align = "center">
						<input type = "submit" value = "가입하기" id = "btn">
					</td>
				</tr>
			</table>
		</form>
		<br><br>
		<hr width = "50%">
		<br><br>
		<h2>고객 리스트</h2>
		<table id = "listTable" cellspacing = "0">
			<tr bgcolor = "pink">
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>삭제</th>
			</tr>
		</table>
	</div>
</body>
</html>