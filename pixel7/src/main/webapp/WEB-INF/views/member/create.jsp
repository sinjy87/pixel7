<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/httpRequest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name='frm' method='POST' action='./create'
		enctype="multipart/form-data" onsubmit="return frmcheck(this)">
		<table>
			<tr>
				<th>프로필사진</th>
				<td><input type="file" value="파일업" name="photoMF" id="photo"></td>
			</tr>
			<tr>
				<th>배경사진</th>
				<td><input type="file" value="파일업" name="bgphotoMF"></td>
			</tr>
			<tr>
				<th>프로필글</th>
				<td><input type="text" name="profile">
			</tr>
			<tr>
				<th>*아이디</th>
				<td><input type="text" name="id" onkeydown="sendKeyword()"></td>
				<td><div id="id_aj">비동기</div></td>
			</tr>


			<tr>
				<th>*비밀번호확인</th>
				<td><input type="password" name="password"></td>

			</tr>
			<tr>
				<th>*비밀번호확인</th>
				<td><input type="password" name="passwd_check"  onkeyup="passwdcheck(document.frm.passwd_check.value)"></td>
				<td><div id="passwd_aj">비동기</div></td>
			</tr>
			<tr>
				<th>*E-mail</th>
				<td><input type="email" name="email"> <br> <input
					type="text" name="check" id="check" value="인증해주세요"
					readonly="readonly"></td>
				<td><input type="button" value="인증메일 발송"
					onclick="emailCheck(document.frm.email.value)"></td>
			</tr>

			<tr>
				<th>관심항목</th>
				<td><input type="checkbox" name="inter" value="인물">인물 <input
					type="checkbox" name="inter" value="동물">동물 <input
					type="checkbox" name="inter" value="자연">자연</td>
		</table>
		<div id="submit_botton"></div>
		<input type="button" value="취소" onclick="history.back()"> <input
			type="submit">
	</form>


	<script type="text/javascript">
 setTimeout("check(document.frm.check.value);",1000);
 function check(d){
	 if(d=='인증완료'){
		 $("#submit_botton").append( "<input type='submit' value='가입' >");
	 }else{
		 setTimeout("check(document.frm.check.value);",1000);
	 }
 }
 
 function emailCheck(email) {
		if (email == "") {
			alert("이메일을 입력하세요");
			document.frm.email.focus();
		} else {
			var url = "../mail";
			url += "?tomail=" + email;
			var wr = window.open(url, "이메일검색", "width=500, height=500");
			wr.moveTo((window.screen.width - 500) / 2, (window.screen.height - 500) / 2)

		}
	}
 
 function frmcheck(frm){
	alert(frm.inter.length)
	 var i=0;
	 for(var j=0; j<frm.inter.length;j++){
		 
	 if(frm.inter[j].checked ==true){
		i++;		
	 }
	 
	 }
		 if(i==0){
		 alert("체크"); return false;}
	 
	 
	 
	 if(frm.id.value ==""){
		 alert("id");
		 frm.id.focus();
		 return false;
	 }
	 if(frm.profile.value ==""){
		 alert("profile");
		 frm.profile.focus();
		 return false;
	 }
	 if(frm.password.value ==""){
		 alert("password");
		 frm.password.focus();
		 return false;
	 }
	 if(frm.passwd_check.value ==""){
		 alert("passwd_check");
		 frm.passwd_check.focus();
		 return false;
	 }
	 if(frm.inter.value ==""){
		 alert("inter");
		
		 return false;
	 }
	
	 
	 
	 if(frm.photoMF.value ==""){
		 alert("photo");
		 return false;
	 }
	 if(frm.bgphotoMF.value ==""){
		 alert("photo");
		 return false;
	 }
	 
 }
function passwdcheck(ck){
	
var pass=document.frm.password.value
	if(ck!=pass){
		var passms="달라요"
		var checkView = document.getElementById('passwd_aj');
		checkView.innerHTML = passms;
		show('passwd_aj');
	}else{
		var passms="같아요"
			var checkView = document.getElementById('passwd_aj');
			checkView.innerHTML = passms;
			show('passwd_aj');
	}
}
 function frmSend(f) {
		$(f).submit();}
</script>
	<script type="text/javascript">


	
	function sendKeyword() {
		
		var keyword = document.frm.id.value

		if (keyword == '') {
			lastKeyword = '';
			hide('id_aj');

		} else if (keyword != lastKeyword) {
			lastKeyword = keyword;
			var params = "keyword=" + encodeURIComponent(keyword);
			
			$(document).ready(function() {
				$.getJSON(
					"./id?keyword="+keyword,
					response);
	
	
			});
		}
		setTimeout("sendKeyword();", 100);
	}

	
	function response(result) {
		var html = result[0];
		var listView = document.getElementById('id_aj');
		listView.innerHTML = html;
		show('id_aj');
	}
		
	


</script>
</body>
</html>