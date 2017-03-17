<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ut" uri="/ELFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function input(f){
	var url = "./iorder/update";
	url = url + "?img_num=${param.img_num}";
	url = url + "&i_order_total=${i_order_total}";
	url = url + "&id=${param.id}";
	url = url + "&i_order_mileage=${param.i_order_mileage}";
	url = url + "&i_order_information=${param.i_order_information}";
	location.href=url;
}
</script>
<meta content="charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<FORM name='frm'
	  method='POST'
	  action='./create'
	  onsubmit="return input(this)">
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
		<td></td>
		<td></td>
		<td><input name="i_order_total" type="text" value="${param.i_order_total}" readonly="readonly" border="0px;"></td>
		<td><input name="id" type="text" value="${param.id}" readonly="readonly" border="0px;"></td>
		<td><input name="i_order_information" type="text" value="${param.i_order_information}" readonly="readonly" border="0px;"></td>
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
</FORM>


</body> 
</html>