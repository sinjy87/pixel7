<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- 전체 스타일 -->
<style type="text/css">
* { 
	font-family: gulim;
	font-size: 20px;
}
</style>
</head>
<body>
<div class="title">등록</div>

<form name='frm' method="POST" action='./create' enctype="multipart/form-data">
	<table>
		<tr>
			<th>ID</th>
			<td>${id}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea type="text" name="reply_content"></textarea></td>
		</tr>
	</table>
	
	<div class='bottom'>
		<input type='submit' value='등록'>
		<input type="button" value='취소'>
	</div>

</form>

</body>
</html>