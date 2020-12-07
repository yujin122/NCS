<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
	// 웹문서가 브라우저로 로딩될 때 문서의 본문을 읽고 난 후 jquery를 실행
	$(function(){
		// 회원가입 폼 중에서 아이디 중복 체크라는 버튼에 마우스가 
		// 올라갔을 때 호출되는 무명함수
		$("#idcheck_btn").mouseover(function(){
			$("#idcheck").hide(); // span 태그 영역을 숨겨라.
			
			var userId = $("#mem_id").val();
			
			// 입력 길이 체크
			if($.trim($("#mem_id").val()).length < 4){
				var warningTxt = '<font color = "red">아이디는 4자 이상이어야 합니다.</font>';
				$("#idcheck").text('');	
				$("#idcheck").show();	
				$("#idcheck").append(warningTxt);	
				$("#mem_id").val("").focus();
			}
			
			// 입력 길이 체크
			if($.trim($("#mem_id").val()).length < 16){
				var warningTxt = '<font color = "red">아이디는 16자 이하이어야 합니다.</font>';
				$("#idcheck").text('');	
				$("#idcheck").show();	
				$("#idcheck").append(warningTxt);	
				$("#mem_id").val("").focus();
			}
			
			// 아이디 중복 여부 확인 - Ajax 기술(비동기 통신)
			$.ajax({
				type : "post",
				url : "views/idCheck.jsp",
				data : {"userId" : userId},
				//dataType : "jsp",
				success : function(data){
					if(data == 1){
						console.log(data);
						var warningTxt = '<font color = "red">중복 아이디입니다.</font>';
						$("#idcheck").text('');	
						$("#idcheck").show();	
						$("#idcheck").append(warningTxt);	
						$("#mem_id").val("").focus();
					}else{
						console.log(data);
						var warningTxt = '<font color = "red">사용 가능한 아이디입니다.</font>';
						$("#idcheck").text('');	
						$("#idcheck").show();	
						$("#idcheck").append(warningTxt);
					}
				},
				error : function(request, status, error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
			
		});
	})
</script>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "red">
			<h3>회원가입</h3>
		<hr width = "50%" color = "red">
		<br><br>
		
		<form method = "post" action = "join_ok.do">
			<table border = "1" cellspacing = "0" width = "600">
				<tr>
					<th>회원 아이디</th>
					<td>
						<input name = "id" id = "mem_id" size = "15">
						<input type = "button" value = "아이디 중복 확인"
							id = "idcheck_btn">
						<br>
						<span id = "idcheck"></span>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>