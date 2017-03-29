<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form  name='frm' method='POST' action='./login'>
			<table>
				<tr>
					<th>아이디</th>
					<th><input type="text" name="id"></th>
				</tr>
				<tr>
					<th>비밀번호</th>
					<th><input type="password" name="password"></th>
				</tr>
			</table>
			<input type="submit" value="로그인">
			<input type="button"
				value="취소" onclick="history.back()">
	</form>
</body>
</html>