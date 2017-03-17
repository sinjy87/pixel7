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
<table border="1">
	<tr>
		<th><input type="checkbox"></th>
		<th>주문번호</th>
		<th>주문 상품 이미지</th>
		<th>주문 상품정보</th>
		<th>상품금액</th>
		<th>판매자</th>
		<th>주문상태</th>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr>
	
		<td><input type="checkbox"></td>
		<td>${dto.i_order_num}</td>
		<td>${ut:getPhoto(dto.img_num,dao)}</td>
		<td>${ut:getContent(dto.img_num,dao)}</td>
		<!--  <td><input type="number" value="1" style="width: 40px"></td>  -->
		<td>${ut:getPrice(dto.img_num,dao)}</td>
		<td>${ut:getId(dto.img_num,dao)}</td>
		<td><input type="button" value="삭제"></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7" style="text-align: right;">
		<c:set var="i" value="0"/>
		<c:forEach items="${list}" var="dto" >
		<c:set var="i" value="${i=i+(ut:getPrice(dto.img_num,dao))}"/>
		</c:forEach>
		상품총합계 : ${i}
		</td>
	</tr>

</table>
	<input type="button" value="주문하기">
	<input type="button" value="">
	<input type="button" value="쇼핑계속">
</body>
</html>