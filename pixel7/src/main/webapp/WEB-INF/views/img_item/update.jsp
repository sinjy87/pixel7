<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<FORM name='frm' method='POST' action='./update'>
		<table>

			<tr>
				<td rowspan="7"><img id="Rimg"
					src="../img_item/storage/${dto.img_photo }"></td>
			</tr>
			<tr>
				<td>내용 : <input type="text" name = "img_content"></td>
			</tr>

			<tr>
				<td><input type="submit" value="update">
				<td>
			<tr>
		</table>
	</FORM>

</body>
</html>