<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align = "center">회원가입</h2>
	
	<form action = "join" method = "post">
	<table align = "center">
		<tr>
			<th>이름 </th>
			<td><input type = "text" size = "20" name = "name">
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type = "text" size = "20"  name = "id">
				<input type = "button" value = "중복확인">
			</td>	
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type = "password" size = "20" name = "pwd"><br/>
				 <font size = "2">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)</font>
			</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type = "password" size = "20"></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><input type = "date" name = "birth"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><input type = "radio" name = "gender" value = "여자"> 여자
				<input type = "radio" name = "gender" value = "남자"> 남자
		</tr>
		<tr>
			<th>주소</th>
			<td><input type = "text" size = "10" name = "postnum">
				<input type = "button" value = "우편번호"><br/>
				<input type = "text" size = "25" name = "addr1"><br/>
				<font size = "2">기본주소</font><br/>
				<input type = "text" size = "25" name = "addr2"><br/>
				<font size = "2">나머지주소</font><br/>
			</td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><select name = "phone1">
					<option value = "010">010</option>
					<option value = "011">011</option>
					<option value = "016">016</option>
					<option value = "017">017</option>
					<option value = "018">018</option>
					<option value = "019">019</option>
				</select> - 
				<input type = "text" size = "5" name = "phone2"> - 
				<input type = "text" size = "5" name = "phone3">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type = "email" id="email" name = "email"></td>
		</tr>
		<tr align = "center">
			<td colspan = "2"><input type = "submit" value ="회원가입"></td>
		</tr>
	</table>
	</form>
</body>
</html>