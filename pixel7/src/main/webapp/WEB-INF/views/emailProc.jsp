<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${flag=='성공' }">
			<input type="button" onclick="use()">
			<h2>인증이 성공 하셨습니다</h2>
		</c:when>
		<c:otherwise>
			<h2>인증이 실패 하셨습니다</h2>
			<input type="button" onclick="history.back()">
		</c:otherwise>
	</c:choose>

	<script type="text/javascript">
		function use() {
			opener.frm.check.value = '인증완료';

			window.close();
		}
	</script>
</body>
</html>