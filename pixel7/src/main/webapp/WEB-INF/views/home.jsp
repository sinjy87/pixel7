<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  안녕하세요???
</h1>

<P>  The time on the server is ${serverTime}. </P>

	
	아이디 : ${id}  등급 : ${grade} <br><br>
	
	
	<input type="button" value="질문 게시판" onclick="location.href='./qna/list'"><br>
	<input type="button" value="설문조사" onclick="location.href='./chart/list'"><br>
	<input type="button" value="로그인" onclick="location.href='./login'"><br>

	
	
</body>
</html>
