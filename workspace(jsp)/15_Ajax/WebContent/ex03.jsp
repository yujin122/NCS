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
			dataType : "xml",
			url : "data/book.xml",
			success : function(data){
				// $(data)는 $.ajax() 메서드가 book.xml 파일에서
				// 불러온 데이터 객체임 find() 메서드로 하위 book
				// 태그를 찾음 작성된 book 태그만큼 each() 함수를
				// 이용해서 반복 안의 내용을 수행하게 됨
				$(data).find("book").each(function(){
					// this는 현재 book 객체를 의미하고, title은 
					// book 객체 안의 title 태그를 선택한다는 의미
					var title = $("title", this).text();
					var author = $("author", this).text();
					var price = $("price", this).text();
					var txt = "<li>책제목 : " + title + "<li>"+ "<li>저자 : " + author + "<li>"+ "<li>가격 : " + price + "<li>";
					$("body").append(txt);
				});
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