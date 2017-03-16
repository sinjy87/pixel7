<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./create" method="post">
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
				<td><input type="text" name="id" value="${id }"></td>
			</tr>
		</table>
		<input type="submit" value="전송"> <input type="button"
			value="취소" onclick="close()">
	</form>
	<script type="text/javascript">
		function close() {
			window.close()
		}
	</script>
</body>
</html>