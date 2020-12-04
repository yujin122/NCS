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
			type : "post",
			dataType : "html",
			url : "data/data.html",
			success : function(data){
				document.body.innerHTML = data;
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