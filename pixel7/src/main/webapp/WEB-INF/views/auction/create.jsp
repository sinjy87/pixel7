<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span{
color:red;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
function fileInfo(f){
	var file=f.files;
	var reader = new FileReader(); // FileReader 객체 사용
	reader.onload = function(rst){

		$('#fileAlert').html('<img src="' + rst.target.result + '">'); // append 메소드를 사용해서 이미지 추가
		// 이미지는 base64 문자열로 추가
		// 이 방법을 응용하면 선택한 이미지를 미리보기 할 수 있음
	}
	reader.readAsDataURL(file[0]); // 파일을 읽는다
	
}
</script>
<script type="text/javascript">//등록값여부
$(function(){
	$("#auction_title").blur(function(){
		if($("#auction_title").val()==""){
			$("#titleAlert").text("제목을 입력해 주세요");
			$("#titleAlert").attr("style","color:red");
			$("#auction_title").focus();
		}else{
			$("#titleAlert").html("완료");
			$("#titleAlert").attr("style","color:green");
			$("#auction_smoney").focus();
		};
	});
	$("#f").submit(function(){
		if($("#auction_title").val()==""){
			return false;
		}else{
			return true;
		}
	});
	
	$("#auction_smoney").blur(function(){
		if($("#auction_smoney").val()==""){
			$("#startmoneyAlert").text("시작금액을 입력해 주세요");
			$("#startmoneyAlert").attr("style","color:red");
			$("#auction_smoney").focus();
			
		}else{
			$("#startmoneyAlert").html("완료");
			$("#startmoneyAlert").attr("style","color:green");
			$("#auction_bmoney").focus();
		};
	  });	
	$("#f").submit(function(){
		if($("#auction_smoney").val()==""){
			return false;
		}else{
			return true;
		}
	});
	$("#auction_bmoney").blur(function(){
		if($("#auction_bmoney").val()==""){
			$("#bymoneyAlert").text("즉시 구매 금액을 입력해 주세요");
			$("#bymoneyAlert").attr("style","color:red");
			$("#auction_bmoney").focus();
		}else{
			$("#bymoneyAlert").html("완료");
			$("#bymoneyAlert").attr("style","color:green");
			
		}

	});
	$("#f").submit(function(){
		if($("#auction_bmoney").val()==""){
			return false;
		}else{
			return true;
		}
	});

});
	
</script>
<script type="text/javascript">//필수입력 깜빡이
setInterval(function(){
$("span").toggle();
}, 1000);
</script>
<script type="text/javascript">//사진업로드여부
function checkplz(f){
	if(f.auction_item.value==""){
		alert("사진을 업로드 해주세요");
		f.auction_item.focus();
		return false;
	}else{
		f.auction_title.focus();
	}
 }
</script>
</head>
<body>
		<form action="./createProc" id="f"name="f" method="post"	enctype="multipart/form-data" onsubmit="return checkplz(this)">
         <input type="hidden"name="id" value="${id }"/>
        <div>사진<span>*</span> </div>
        <div id="fileAlert"></div>
			<input type="file" id="auction_item" name="fileMF" onchange="fileInfo(this)" accept=".jpg,.png"  />
		   <div>제목<span>*</span></div>
			<input type="text" name="auction_title" id="auction_title" placeholder="제목 입력" />
			<div id="titleAlert"></div>
	
			<div>시작금액<span>*</span></div>
			<input type="text" name="auction_smoney" id="auction_smoney"placeholder="시작금액" />
		<div id="startmoneyAlert"></div>	
			
			<div>즉시구매금액<span>*</span></div>
			<input type="text" name="auction_bmoney" id="auction_bmoney" placeholder="즉시 구매 금액" />
		<div id="bymoneyAlert"></div>
		
			<div>코멘트	</div>
			<input type="text" name="auction_content" id="auction_content" placeholder="history" />
		
			<div>
			<input type="button" value="목록" /> <input type="submit" value="등록">
			<input type="reset" value="다시쓰기" />
			</div>
		</form>
</body>
</html>