<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>

	Hello world!  안녕하세요
</h1>
<c:if test="${not empty id}">
<h2>${id }님이 로그인하셨습니다</h2>
</c:if>
<input type="button" value="로그인"
					onclick="location.href = '${pageContext.request.contextPath}/member/agree'">
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
