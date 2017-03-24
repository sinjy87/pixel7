<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	
</head>
<body>
<h1>
	Hello world!
</h1>



<input type="text" name ="id" value="${id}">
<input type="text" name ="i_order_mileage" value="${dto.i_order_mileage}">
<P>  The time on the server is ${serverTime}. </P>




<input type="button" value="구매리스트" onclick="location.href='./iorder/list'">
<input type="button" value="구매" onclick="location.href='./iorder/create?id=vip&i_order_total=200&img_num=2&i_order_mileage=10&i_order_information=주문전'">
<input type="button" value="장바구니 담기" onclick="location.href='./cart/create?id=normal&img_num=1'">
<input type="button" value="장바구니 목록" onclick="location.href='./cart/list'">
<input type="button" value="로그인" onclick="location.href='./iorder/login'">
<input type="button" value="로그아웃" onclick="location.href='./iorder/logout'">
</body>
</html>
