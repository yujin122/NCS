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
		<hr width = "50%" color = "orange">
			<h3>UPLOAD 테이블 게시물 글쓰기 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<form method = "post" action="${pageContext.request.contextPath }/upload_write_ok.do"
		enctype = "multipart/form-data">
		<%-- enctype : 이진 파일 업로드를 위한 속성 --%>
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>작성자</th>
				<td><input name = "writer"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input name = "title"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
				<textarea rows="7" cols="30" name = "content"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type = "file" name = "file"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "submit" value = "등록">
					&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>