<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
	function check(no){
		var del = confirm("정말로 삭제하시겠습니까?");
		
		if(del){
			location.href = "admin_cat_delete.do?cnum="+no;
		}else{
			return;
		}
	}
	
</script>
</head>
<body>

	<jsp:include page="../include/admin_top.jsp" />

	<div align = "center">
		<hr width = "50%" color = "maroon">
			<h3>카테고리 리스트</h3>
		<hr width = "50%" color = "maroon">
		<br>
		<table border = "1" cellspacing = "0" width = "500">
			<tr>
				<th>번호</th>
				<th>카테고리 코드</th>
				<th>카테고리 이름</th>
				<th>삭제</th>
			</tr>		
			<c:set var = "list" value = "${list }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var = "cat">
				<tr>
					<td>${cat.getCategory_num() }</td>
					<td>${cat.getCategory_code() }</td>
					<td>${cat.getCategory_name() }</td>
					<td>
					<input type ="button" value = "삭제"
							onclick = "check(${cat.getCategory_num() })">
					</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
			<tr>
				<td>카테고리가 없습니다.</td>
			</tr>
			</c:if>
		</table>
	</div>
	
	<jsp:include page="../include/admin_bottom.jsp" />
</body>
</html>