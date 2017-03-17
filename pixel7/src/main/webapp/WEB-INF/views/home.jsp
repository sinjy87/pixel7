<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  안녕하세염 ㅎㅎ~~!!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<input type="button" value="구매리스트" onclick="location.href='./iorder/list'">
<input type="button" value="구매" onclick="location.href='./iorder/create?id=normal&i_order_total=120&img_num=1&i_order_mileage=6&i_order_information=주문전'">
</body>
</html>
