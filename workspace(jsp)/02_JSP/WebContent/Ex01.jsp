<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	
	<%-- 
		지시어(디렉티브) : JSP 페이지에 대한 설정 정보를 지정하는 공간.
		
		1. <%@ page %> ==> JSP 페이지에 대한 정보를 지정하는 공간.
			- 어떻게 처리해야 하는지, 전달하기 위한 내용도 담고 있는 공간.
			- 클라이언트의 요청에 JSP 페이지가 실행될 때 필요한 정보를
			  JSP 컨테이너(톰캣)에 알려주는 역할을 함.
		
		2. <%@ include %> ==> 현재 페이지에 다른 문서(JSP, HTML)를
							  가져와서 내용을 컴파일 할 때 사용되는디렉티브
			형식) <%@ include file = "포함할 파일의 url" %>
			- include 지시어를 사용한 JSP 페이지가 컴파일이 되는 과정에서 
			  include 되는 JSP 페이지의 소스 내용을 그대로 포함해서
			    컴파일을 함.
			- 즉, 복사 & 붙이기 방식으로 두 개의 파일이 하나의 파일로 구성이
			    된 후 같이 컴파일이 된다.
		
		3. <%@ taglib %> ==> 사용할 태그 라이브러리 지정
			(예, JSTL/EL 언어 사용 시 ==> 09번 프로젝트에서 수업 진행 예정)
			
		===================================================================
		1. 	페이지 지시어
		
			<%@ page language="java" contentType="text/html; charset=UTF-8"
    			pageEncoding="UTF-8"%>
    			
    		- language = "java" : 해당 JSP 페이지에서 사용되는 언어(java)
    		- contentType : 문서의 타입 ==> JSP 페이지의 내용을 어떤 형태로
    						출력할지를 웹 브라우저에게 알려주는 역할.
    		  charset : 문자셋(UTF-8, EUC-KR)
    		- import : 다른 패키지에 있는 클래스를 가져다가 사용할 때 지정
    		- session : HttpSession 속성의 사용 여부를 지정
    					==> <%@ page session = "true" %>
    		- isErrorPage : 에러가 발생했을 때 보여줄 페이지를 지정
    		- errorPage : 에러가 발생했을 때 보여줄 페이지를 지정
    		- pageEncoding = "UTF-8" : contentType의 charset 과 같음.
	 --%>
	
	<% // 스크립트릿 : 자바 코드가 들어가는 공간
		Calendar cal = Calendar.getInstance();
	%>
	
	<h2>
		<%-- JSP 표현식 : 변수의 값 또는 메서드의 결과값을 출력하는 공간 --%>
		<%=cal.get(Calendar.YEAR) %>년 <%=cal.get(Calendar.MONTH)+1 %>월 <%=cal.get(Calendar.DAY_OF_MONTH) %>일
	</h2>
	
	<hr>
	
	<h2>1 ~ 100까지의 합 구하기</h2>
	
	<%
		int sum = 0;
		
		for(int i=1;i<=100;i++){
			sum +=i;
		}
	%>
	
	<h3>1 ~ 100까지의 합 : <%=sum %></h3>
	
	<hr>
	
	<%!
		// 자바에서 변수 선언 및 메서드 선언하는 공간
		public int plus(int a, int b){
			return a+b;
		}
	%>
	
	<h3>7 + 5 = <%=plus(7,5) %></h3>
	
</body>
</html>