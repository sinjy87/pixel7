<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  Reply!
</h1>
<h2>${id }</h2> 
<a href="${pageContext.request.contextPath}/reply/list">댓글목록</a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
