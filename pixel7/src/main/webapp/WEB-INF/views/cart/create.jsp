<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ut" uri="/ELFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
이 항목을 장바구니에 넣으시겠습니까?
<FORM name='frm'
	  method='POST'
	  action='./create'>
<input type="hidden" name="img_num" value="${param.img_num}">

<table border="1">
	<tr>
		<th>주문 상품 이미지</th>
		<th>주문 상품정보</th>
		<th>상품금액</th>
		<th>판매자</th>
		<th>주문상태</th>
	</tr>

	<tr>
		<td>${ut:getPhoto2(param.img_num,dao)}</td>
		<td>${ut:getContent2(param.img_num,dao)}</td>
		<td><input name="img_price" type="text" value="${ut:getPrice2(param.img_num,dao)}" readonly="readonly" border="0px;"></td>
		<td><input name="id" type="text" value="${param.id}" readonly="readonly" border="0px;"></td>
		<td><input name="i_order_information" type="text" value="${param.i_order_information}" readonly="readonly" border="0px;"></td>
	</tr>

</table>
	<input type="submit" value="장바구니 넣기">
	<input type="button" value="장바구니 취소" onclick="history.back()">
</FORM>
</body>
</html>