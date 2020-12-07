$(function(){
	// 여러 ajax에서 동일하게 사용되는 속성 설정
	$.ajaxSetup({
		ContentType : "application/x-www.form-urlencoded;cahrset=utf-8",
		type : "post"
	});


	function getData(){
		$.ajax({
			url : "/15_Ajax/select.do",
			dataType : "xml",
			success : function(data){
				// 테이블 태그의 첫번째 행을 제외하고 모두 제거하라는 의미
				$("#listTable tr:gt(0)").remove();
				var table = "";
				
				$(data).find("customer").each(function(index){
					table += "<tr>";
					table += "<td>" + $(this).find("no").text() + "</td>";
					table += "<td>" + $(this).find("id").text() + "</td>";
					table += "<td>" + $(this).find("name").text() + "</td>";
					table += "<td>" + $(this).find("age").text() + "</td>";
					table += "<td>" + $(this).find("tel").text() + "</td>";
					table += "<td>" + $(this).find("addr").text() + "</td>";
					table += "<td id = 'tdDel'><input type = 'button' value = '삭제' id = 'del' name = '"+$(this).find('no').text()+"'></td>";
					table += "</tr>";
				});
				
				// 테이블의 첫번째 행 뒤에 table을 추가
				$("#listTable tr:eq(0)").after(table);
			},
			error : function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	
	}
	
	$("#id").keyup(function(){
		$.ajax({
			url : "/15_Ajax/idCheck.do",
			dataType : "text",
			data : "id="+$("#id").val(),
			success : function(data){
				$("span").html(data);
			},
			error : function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
	
	$("#btn").click(function(){
		var data = $("#form").serialize();
		console.log(data);
		$.ajax({
			url : "/15_Ajax/insert.do",
			dataType : "text",
			data : $("#form").serialize(),
			success : function(data){
				if(data > 0){
					alert("가입완료");
					getData();
					
					$("input[type=text]").each(function(){
						$(this).valu("");
					});
					
				}else{
					alert("가입 실패");
				}
			},
			error : function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
	
	// 삭제 버튼은 동적으로 생성된 요소이므로 on() 함수를 이용
	$("table").on("click", "#del", function(){
		$.ajax({
			url : "/15_Ajax/delete.do",
			dataType : "text",
			data : "no="+$(this).attr("name"),
			success : function(data){
				if(data > 0){
					alert("삭제 완료");
					getData();
				}else{
					alert("삭제 실패");
				}
			},
			error : function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
			
		});
	});
	
	getData();
});	