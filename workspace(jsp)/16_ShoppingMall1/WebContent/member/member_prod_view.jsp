<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goCart(num){
		document.frm.action = "${pageContext.request.contextPath }/member_cart_add.do?pnum="+num;
		document.frm.submit();
	}
</script>
</head>
<body>
	<jsp:include page = "../include/member_top.jsp" />
	<br><br>
	
	<table border = "0" cellspacing = "0" width = "540">
		<c:set var = "dto" value =  "${dto }" />
		<c:if test="${!empty dto }">
			<tr>
				<td colspan = "2" align = "center">
					<b>[${dto.getPname() }] 상품 정보</b>
				</td>
			</tr>
			<tr>
				<td align = "center">
					<img src = "${pageContext.request.contextPath }/upload/${dto.getPimage() }"
						width = "200" height = "200">
				</td>
				<td>
					<form method = "post" name = "frm">
					<input type = "hidden" name = "p_spec" value = "${dto.getPspec() }">
					<input type = "hidden" name = "p_image" value = "${dto.getPimage() }">
						상품번호 : ${dto.getPnum() }<br>
						상품이름 : <input name = "p_name" value = "${dto.getPname() }"><br>
						상품가격 : <input name = "p_price" value = "${dto.getPrice() }"><br>
						<fmt:formatNumber value = "${dto.getPoint() }" var = "commaPoint" />
						상품포인트 : [${commaPoint }] point <br>
						상품 수량 : <input type = "number" name = "p_qty" min = "1" max = "20" value = "1">개<br><br>
						
						<table border = "0" cellspacing = "0" width = "90%" align = "center">
							<tr>
								<td>
									<a href = "javascript:goCart('${dto.getPnum() }')">
									<img src = "${pageContext.request.contextPath }/uploadFile/btn_cart.gif"
										border = "0">
									</a>
								</td>
								<td>
									<a href = "#">
									<img src = "${pageContext.request.contextPath }/uploadFile/btn_buy.png"
										border = "0">
									</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr height = "250" valign = "top">
				<td colspan = "2">
					<br>
					<b>상품 소개</b><br>
					${dto.getPcontent() }
				</td>
			</tr>
		</c:if>
	</table>
	
	
	<jsp:include page = "../include/member_bottom.jsp" />
</body>
</html>