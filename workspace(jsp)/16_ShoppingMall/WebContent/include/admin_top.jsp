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
		<hr width = "50%">
			<h2>관리자 페이지</h2>
		<hr width = "50%">
		<br>
		
		<table width = "800">
			<tr>
				<td>
					<a href = "${pageContext.request.contextPath }/admin_main.do">관리자 홈</a>
				</td>
				<td>
					<a href = "${pageContext.request.contextPath }/admin_cart_input.do">카테고리 등록</a>
				</td>
				<td>
					<a href = "${pageContext.request.contextPath }/admin_cart_list.do">카테고리 목록</a>
				</td>
				<td>
					<a href = "${pageContext.request.contextPath }/admin_prod_input.do">상품 등록</a>
				</td>
				<td>
					<a href = "${pageContext.request.contextPath }/admin_prod_list.do">상품 목록</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>