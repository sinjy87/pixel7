<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./create" method="post" onsubmit="return frm(this)">


		<table>
			<tr>
				<td>받는사람</td>
				<td><input type="text" name="message_id"></td>
			</tr>
			<tr>
				<td>쪽지내용</td>
				<td><textarea rows="10" cols="50" name="message_content"></textarea></td>
			</tr>
			<tr>
				<td>보내는사람</td>
				<td><input type="text" name="id" value="${id }" disabled="disabled"></td>
			</tr>
		</table>
		<input type="submit" value="전송"> <input type="button"
			value="취소" onclick="history.back()">
	</form>
	<script type="text/javascript">
	function frm(f){
		if(f.message_id.value==""){
			alert("받는사람을 입력해주세요");
			f.message_id.focus();
			return false;
		}
		if(f.message_content.value==""){
			alert("받는사람을 입력해주세요");
			f.message_content.focus();
			return false;
		}
	}
	
	</script>
</body>
</html>