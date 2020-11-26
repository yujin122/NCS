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
	
	<%--
		기본적인 JSTL 태그 ==> 출력은 EL을 사용
		1. 변수 태그(set)
		   <c:set var="변수명" value = "값" />
		      예) <c:set var = "su" value = "11"> ==> int su = 11;
		      예) <c:set var = "str" value = "Hello"> ==> String str = "Hello";
		      
		2. 출력 태그(out)
		   <c:out value = "변수명" />
		       예) <c:out value = "str"> ==> Hello
		
		3. 삭제 태그(remove)
		   <c:remove var = "변수명" />
		      예) <c:remove var = "str">
		
		4. 조건 처리 태크(if) ==> else문이 없음.
		   <c:if test = "조건식" var = "변수명" />
		
		5. 조건 처리 태그(choose문) ==> switch~case문과 유사
		   <c:choose>
		      <c:when test = "조건식1"> 조건식1이 참인 경우 실행문장 </c:when>
		      <c:when test = "조건식2"> 조건식2이 참인 경우 실행문장 </c:when>
		      <c:when test = "조건식3"> 조건식3이 참인 경우 실행문장 </c:when>
		      <c:when test = "조건식4"> 조건식4이 참인 경우 실행문장 </c:when>
		      <c:otherwise>상기 조건식 이외의 경우 실행문장 </c:otherwise>
		   </c:choose>
		
		6. 반목문 태그(forEach문) : for문
		   <c:forEach begin = "시작값" end = "끝값" step = "증감값" var = "변수명">
		   <c:forEach items = "객체명" var = "변수명">
	 --%>
	 
	 <h2>JSTL의 기본적인 태그들</h2>
	 
	 <h3>
	 	<c:set var = "test" value="Hello JSTL!" />
	 	JSTL 값 출력 : <c:out value="test" /><br>
	 	JSTL 값 출력 : <c:out value = "${test }" /><br>
	 	JSTL 값 삭제 : <c:remove var="test"/><br>
	 	JSTL 값 출력 : <c:out value = "${test }" /><br>
	 </h3>
	 <hr>
	 <h3>
	 	<c:if test="${10 > 5 }" var = "k" />
	 	
	 	조건식 결과 : <c:out value="${k }" />
	 </h3>
	 <hr>
	 <h3>
	 	<c:set var = "test2" value = "77" />
	 	<c:choose>
	 		<c:when test="${test2 >= 90 }">학점 : A</c:when>
	 		<c:when test="${test2 >= 80 }">학점 : B</c:when>
	 		<c:when test="${test2 >= 70 }">학점 : C</c:when>
	 		<c:when test="${test2 >= 60 }">학점 : D</c:when>
	 		<c:otherwise>학점 : F</c:otherwise>
	 	</c:choose>
	 </h3>
	 <hr>
	 <h3>
	 	<c:forEach begin="1" end="10" step="1" var="i"> 
	 		${i } &nbsp;&nbsp;&nbsp;
	 	</c:forEach>
	 </h3>
	 <hr>
	 <h3>
	 	<%
	 		String[] str = {"홍길동", "이순신", "유관순", "김유신", "김연아"};
	 		pageContext.setAttribute("list", str);
	 	%>
	 	<c:forEach items = "${list }" var="str">
	 		${str } &nbsp;&nbsp;&nbsp;
	 	</c:forEach>
	 </h3>
	 
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>