<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
	$(function(){
		$.ajax({
			type : "get",
			dataType : "json",
			url : "data/data.json",
			success : function(data){
				// index : data 객체 내의 인덱스
				// item : data 객체 내의 이름과 값을 가지는 객체
				$.each(data, function(index, item)){
					var txt = "<li>책제목 : " + item.title + "<li>"
					+ "<li>저자 : " + item.author + "<li>"
					+ "<li>가격 : " + item.price + "<li>";
				}
			},
			error : function(){
				alert("에러 발생");
			}
		});
	});
</script>
</head>
<body>

</body>
</html>