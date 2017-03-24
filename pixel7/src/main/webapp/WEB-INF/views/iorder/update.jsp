<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ut" uri="/ELFunctions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="./update" method="POST">
		<c:if test="${empty dto}">

			<c:forEach items="${list}" var="dto">

				<input type="hidden" name="i_order_num" value="${dto.i_order_num}">
				<input type="hidden" name="img_num" value="${param.img_num}">
				<input type="hidden" name="i_order_total" value="${param.i_order_total}">
				<input type="hidden" name="orderid" value="${param.id}">
				<input type="hidden" name="i_order_mileage" value="${param.i_order_mileage}">
				<input type="hidden" name="i_order_information" value="${param.i_order_information}">

<table border="1">
					<tr>
						<th>주문번호</th>
						<th>주문 상품 이미지</th>
						<th>주문 상품정보</th>
						<th>상품금액</th>
						<th>판매자</th>
						<th>주문상태</th>
					</tr>

					<tr>
						<td>${dto.i_order_num}</td>
						<td>${ut:getPhoto(param.img_num,dao)}</td>
						<td>${ut:getContent(param.img_num,dao)}</td>
						<td><input name="i_order_total" type="text" value="${i_order_total}" readonly="readonly" border="0px;"></td>
						<td><input name="orderid" type="text" value="${orderid}" readonly="readonly" border="0px;"></td>
						<td><c:choose>
								<c:when test="${ empty dto}">${i_order_information}</c:when>
								<c:otherwise>${dto.i_order_information }</c:otherwise>
							</c:choose> 
						</td>
					</tr>


					<tr>
						<td colspan="5" style="text-align: right;">보유마일리지 :
						<input name="i_order_mileage" type="text" value="${i_order_mileage}" readonly="readonly" border="0px;"> <br> 
						<input name="i_order_total" type="text" value="${i_order_total}" readonly="readonly" border="0px;"> - 
						<input type="text" value="0" style="width: 20px"> =
						</td>
					</tr>
				</table>
				<input type="submit" value="주문하기">
				<input type="button" value="주문취소" onclick="location.href='./delete?i_order_num=${dto.i_order_num}'">
			</c:forEach>
	</c:if>
	</form>
	
	<!-- ------------------------------------------------------------------------------------------- -->
	
	
	
	<c:if test="${empty list}">
	
		

				<input type="hidden" name="i_order_num" value="${dto.i_order_num}">


주문완료

<table border="1">
					<tr>
						<th>주문번호</th>
						<th>주문 상품 이미지</th>
						<th>주문 상품정보</th>
						<th>상품금액</th>
						<th>판매자</th>
						<th>주문상태</th>
					</tr>

					<tr>
						<td>${dto.i_order_num}</td>
						<td>${ut:getPhoto(param.img_num,dao)}</td>
						<td>${ut:getContent(param.img_num,dao)}</td>
						<td><input name="i_order_total" type="text" value="${i_order_total}" readonly="readonly" border="0px;"></td>
						<td><input name="id" type="text" value="${id}" readonly="readonly" border="0px;"></td>
						<td><c:choose>
								<c:when test="${empty dto}">${i_order_information}</c:when>
								<c:otherwise>${dto.i_order_information}</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>
						<td colspan="5" style="text-align: right;">보유마일리지 :
						<input name="i_order_mileage" type="text"value="${i_order_mileage}" readonly="readonly"border="0px;"> <br> 
						<input name="i_order_total"type="text" value="${i_order_total}" readonly="readonly"border="0px;"> - 
						<input type="text" value="0"style="width: 20px"> =
						</td>
					</tr>
				</table>
				<input type="button" value="홈으로" onclick="location.href='../'"> 
	</c:if>
</body>
</html>