<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	/* 
		Ajax 형식
		$.ajax({
			type : 통신 타입을 설정 - get post
			async : 비동기식으로 처리할 지 결정 - false 동기 true 비동기
			url : 요청한 url을 설정
			data : 서버에 요청할 때 보낼 매개변수를 설정 - {서버로 전송할 데이터}
			dataType : 응답을 받을 데이터의 타입을 설정 - text, xml, json 등
			success : 요청 및 응답에 대해 성공했을 때 처리할 내용
			error : 요청 및 응답에 대해 실패했을 때 처리할 내용
			complete : 모든 작업을 마친 후에 처리할 내용 설정
		});
		
		json 파일 : - JavaScript Object Notation
				  - name / value 쌍으로 이루어진 데이터 객체를 전달하기
				  	위해 사람이 읽을 수 있는 텍스트를 사용하는 개방형 표준
				  	데이터 형식
				  - 비동기 브라우저/ 서버 통식을 위해 xml을 대체하는 데이터 
				  	전송 방식 중 하나
	*/
	
	function process(){
			
		$.ajax({
			type : "get",
			dataType : "text",
			url : "data/test.jsp",
			data : {param : "Hello Ajax"},
			success : function(data){
				$(".message").append(data);
			},
			error : function(data){
				alert("에러가 발생함.");
			},
			complete : function(data){
				alert("작업 완료");
			}
		});
	}
	
</script>
</head>
<body>
	<input type = "button" value = "전송하기" onclick = "process()">
	<br><br>
	<div class = "message">
		
	</div>
</body>
</html>