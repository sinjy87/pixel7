<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<th>보낸사람</th>
			<TH>${dto.id }</TH>
		</tr>
		<tr>
		<th>내용</th>
		<TD>${dto.message_content }</TD>
		</tr>
		<tr>

	</table>
	<input type="button" value="쪽지목록" onclick="location.href='./list'">
	<input type="button" value="쪽지보내기" onclick="location.href='./create'">
</body>
</html>