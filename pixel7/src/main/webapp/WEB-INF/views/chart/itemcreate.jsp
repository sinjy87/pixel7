<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



<script type="text/javascript">

$(function viewcontent(){
	
	$(document).ready(function() {
		$.getJSON("./view?research_num="+${dto.research_num}, response);
	});
	function response(result, textStatus) {
	   alert("response");
		document.getElementById("penaltitle").innerHTML = result[1];
		document.getElementById("penalcontent1").innerHTML = result[1];
		document.getElementById("penalcontent2").innerHTML = result[1];
		document.getElementById("penalcontent3").innerHTML = result[1];
		document.getElementById("penalcontent4").innerHTML = result[1];
	}
	
});


</script>




<script type="text/javascript">


$(function(){
	$("#titlefrm").append('<input type="text" id="research_title" name="research_title" value="${dto.research_title}">');
	$("#titlefrm").append('<input type="button" id="title_btn" class="btn btn-default" value="추가">');

});

$(function(){
	
	if($("#research_title").val()!=""){
// 		$("#titlefrm").append("${dto.research_title}");
		$("#contentfrm").append("<input type='text' name='researchitem_content' id='researchitem_content'>");
		$("#contentfrm").append('<input type="button" id="content_btn" class="btn btn-default" value="추가">');
	}
	
	 if($("#researchitem_content").val()!=""){
// 			$("#contentfrm").append("${ridto.researchitem_content} + <br>");
			$("#contentfrm").append("<input type='text' name='researchitem_content' id='researchitem_content' >");
			$("#contentfrm").append('<input type="button" id="content_btn" class="btn btn-default" value="추가">');
		}
	 
	
	
	
	$("#title_btn").click(function(){

		alert("title 생성 및 title생성버튼 제거");
		$("#title_btn").remove();
		document.getElementById("titlefrm").submit();

		
	});
	
	 $("#content_btn").click(function viewcontent(){
			
		alert("content 생성 및 content생성버튼 제거");
		$("#contentfrm").innerHTML += "<br>" +  $("researchitem_content").val();
		$("#content_btn").remove();
		document.getElementById("contentfrm").submit();

	 });
	
	
	
	
});
</script>

</head>
<body>



		
<form id="titlefrm" action="./titlecreate" method="POST">
	설문제목 : 
</form>


<div id="penaltitle"></div>
<div id="penalcontent1"></div>
<div id="penalcontent2"></div>
<div id="penalcontent3"></div>
<div id="penalcontent4"></div>


<form id="contentfrm" action="./contentcreate" method="POST">
	research_num: ${dto.research_num + ridto.research_num} <br>
	<input type="hidden" name="research_num" value="${(dto.research_num+ridto.research_num)}">
	
</form>


</body>
</html>