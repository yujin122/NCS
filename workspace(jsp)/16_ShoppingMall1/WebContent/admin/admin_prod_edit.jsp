<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/admin_top.jsp"/>
	
	<div align = "center">
		<hr width = "50%" color = "blue">
			<h3>상품 수정 폼 페이지</h3>
		<hr width = "50%" color = "blue">
		<br>
		<form method = "post" action = "admin_prod_edit_ok.do" enctype = "multipart/form-data">
		<c:set var = "dto" value = "${dto }"/>
		<input type = "hidden" value = "${dto.getPnum() }" name = "p_num">
			<table border = "1" cellspacing = "0" width = "400">
				<tr>
					<th>카테고리</th>
					<td>
						<select name="p_category">
							<c:set var="list" value="${list }" />
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="cat">
									<option value="${cat.getCategory_code() }">${cat.getCategory_name() }[${cat.getCategory_code() }]</option>
								</c:forEach>
							</c:if>
							<c:if test="${empty list }">
								<option value = "">::: 카테고리 없음 :::</option>
							</c:if>
					</select>
					</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td><input type = "text" name = "p_name" size = "15" value = "${dto.getPname() }"></td>
				</tr>
				<tr>
					<th>제조사</th>
					<td><input type = "text" name = "p_company" size = "20" value = "${dto.getPcompany() }"></td>
				</tr>
				<tr>
					<th>상품 이미지</th>
					<td><input type = "file" name = "p_image"></td>
				</tr>
				<tr>
					<th>상품 수량</th>
					<td><input type = "number" name = "p_qty" min = "1" max = "100" value = "${dto.getPqty() }"></td>
				</tr>
				<tr>
					<th>상품 가격</th>
					<td><input type = "text" name = "p_price" maxlength = "8" value = "${dto.getPrice() }"></td>
				</tr>
				<tr>
					<th>상품 사양</th>
					<td>
						<select name = "p_spec">
							<option value = "none"
							<c:if test = "${dto.getPsec() == 'none' }"> selected</c:if>>일반</option>
							<option value = "hit"
							<c:if test = "${dto.getPsec() == 'hit' }"> selected</c:if>>인기</option>
							<option value = "new"
							<c:if test = "${dto.getPsec() == 'new' }"> selected</c:if>>최신</option>
							<option value = "recommand"
							<c:if test = "${dto.getPsec() == 'recommand' }"> selected</c:if>>추천</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>상품 소개</th>
					<td>
						<textarea rows="7" cols="30" name = "p_content">${dto.getPcontent() }</textarea>
					</td>
				</tr>
				<tr>
					<th>상품 포인트</th>
					<td><input type = "text" name = "p_point" value = "${dto.getPoint() }"></td>
				</tr>
				<tr>
					<td colspan = "2" align = 'center'>
						<input type = "submit" value = "등록">
						<input type = "reset" value = "취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:include page="../include/admin_bottom.jsp"/>
	
</body>
</html>