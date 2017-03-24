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
<FORM name='frm'
	  method='POST'
	  action='./create'
	 >
<input type="hidden" name="img_num" value="${param.img_num}">
<input type="hidden" name="i_order_total" value="${param.i_order_total}">
<input type="hidden" name="orderid" value="${param.id}">
<input type="hidden" name="i_order_mileage" value="${param.i_order_mileage}">
<input type="hidden" name="i_order_information" value="${param.i_order_information}">
<table border="1">
	<tr>
		<th>주문 상품 이미지</th>
		<th>주문 상품정보</th>
		<th>상품금액</th>
		<th>판매자</th>
		<th>주문상태</th>
	</tr>

	<tr>
		<td>${ut:getPhoto(param.img_num,dao)}</td>
		<td>${ut:getContent(param.img_num,dao)}</td>
		<td><input name="i_order_total" type="text" value="${param.i_order_total}" readonly="readonly" border="0px;"></td>
		<td>${param.id}</td>
		<td>${param.i_order_information}</td>
	</tr>


	<tr>
		<td colspan="5" style="text-align: right;">
		 보유마일리지 :<input name="i_order_mileage" type="text" value="${param.i_order_mileage}" readonly="readonly" border="0px;">  <br>
		<input name="i_order_total" type="text" value="${param.i_order_total}" readonly="readonly" border="0px;"> - <input type="text" value="0" style="width: 20px"> =
		</td>
	</tr>
</table>

		
	<input type="submit" value="주문하기">
	<input type="button" value="취소" onclick="history.back()">
</FORM>


</body> 
</html>