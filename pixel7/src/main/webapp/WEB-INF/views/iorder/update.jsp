<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ut" uri="/ELFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="i_order_num" value="${dto.i_order_num}">
주문완료

<table border="1">
	<tr>

		<th>주문 상품 이미지</th>
		<th>주문 상품정보</th>
		<th>상품금액</th>
		<th>판매자</th>
		<th>주문상태</th>
	</tr>

	<tr>
		<td>${dto.i_order_num}</td>
		<td></td>
		<td><input name="i_order_total" type="text" value="${param.i_order_total}" readonly="readonly" border="0px;"></td>
		<td><input name="id" 			type="text" value="${param.id}" readonly="readonly" border="0px;"></td>
		<td>
		<c:if test="${param.i_order_information}" var="주문전">
		
		</c:if>
		<input name="i_order_information" type="text" value="${param.i_order_information}" readonly="readonly" border="0px;"></td>
	</tr>


	<tr>
		<td colspan="5" style="text-align: right;">
		 보유마일리지 :<input name="i_order_mileage" type="text" value="${param.i_order_mileage}" readonly="readonly" border="0px;">  <br>
		<input name="i_order_total" type="text" value="${param.i_order_total}" readonly="readonly" border="0px;"> - <input type="text" value="0" style="width: 20px"> =
		</td>
	</tr>
</table>
	<input type="submit" value="주문하기">
	<input type="button" value="주문취소" onclick="history.back()">
</body>
</html>