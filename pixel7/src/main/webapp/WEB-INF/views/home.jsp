<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body style="padding-top: 20px;text-align: center">

<h1>
	Hello world! Calender <br>
	   
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  <a href="./cal/create">일정등록</a> </P>

<hr>
<c:import url="/cal/notice_home"></c:import>


</body>
</html>
