<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인증이 ${sts }하셨습니다</h2>
<input type="button" onclick="use()">


	<script type="text/javascript">
function use() {
		opener.frm.check.value = '인증완료';
		
		window.close();
	}
</script>
</body>
</html>