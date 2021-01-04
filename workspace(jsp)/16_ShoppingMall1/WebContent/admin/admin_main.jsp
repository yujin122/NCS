<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../include/admin_top.jsp"/>
	
	<div align = "center">
		<ul>
			<li><a href = "${pageContext.request.contextPath }/admin_cat_input.do">쇼핑 카테고리 등록</a></li>
			<li><a href = "${pageContext.request.contextPath }/admin_cat_list.do">쇼핑 카테고리 목록</a></li>
			<li><a href = "${pageContext.request.contextPath }/admin_prod_input.do">상품 등록</a></li>
		</ul>
	</div>
	
	<jsp:include page="../include/admin_bottom.jsp"/>
	
</body>
</html>