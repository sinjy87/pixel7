<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="util" uri="/Auction_ELF"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#show {
	height: 300px;
	width: 300px;
}
#css-moneyUpdate{
	text-align:center;
 	margin-bottom: 50px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".hide").hide();
		$(".show").mouseover(function() {
			$(".hide").not($(this).next(".hide").slideToggle()).slideUp();
		}).mouseout(function() {
			$(".hide").hide();
		});
	});
	
	function auction_read(auction_num) {
		url = "./read";
		url += "?auction_num=" + auction_num;
		location.href = url;
	}
</script>

<script type="text/javascript">
function moneyupdate(){
	var id="${id}";
	console.log(id)
	var url="./moneyUpdate?id="+id;
	window.open(url,'MoneyUpdate',"height=500,width=500,left=500,top=150");
}
</script>
</head>
<body>
<div id="css-moneyUpdate">
<button onclick="javascript:moneyupdate()">충전</button>
</div>

	<c:choose>
		<c:when test="${fn:length(list)>0 }">
			<c:forEach items="${list }" var="dto">
			<input type="hidden" name="auction_num" value="${dto.auction_num }" class="num"/>
				<div class="show" id="show">
					<table >
						<tr>
							<th><a href="javascript:auction_read('${dto.auction_num}')"><img src="${pageContext.request.contextPath }/storage/auction/${dto.auction_item}" width="300px" height="300px"></a></th>
						</tr>
					</table>
				</div>
				<div class="hide" id="hide">
					<table >
						<tr>
							<th>아이디:</th>
							<td id="id">${dto.id }</td>
						</tr>
						<tr>
							<th>제목:</th>
							<td>${dto.auction_title }</td>
						</tr>
						<tr>
						<c:set var="bidmc" value="${util:bidMoneyCheck(bidDAO,dto.auction_num) }" />
						<c:set var="bidmoney" value="${util:bidmoney(bidDAO,dto.auction_num)}"/>
						<c:choose>
						<c:when test="${bidmc>0}">
						<th>입찰가:</th>
						<c:forEach items="${bidmoney }" var="bm">
						<td>${bm.auction_bidmoney}원</td>
						</c:forEach>
						</c:when>
						<c:otherwise>
						<th>시작금액:</th>
						<td>${dto.auction_smoney }원</td>
						</c:otherwise>
						</c:choose>
						</tr>
						<tr>
						<th>마감시간:</th>
							<td>${dto.auction_time }</td>
						</tr>
					</table>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
	<div style="height: 50000px"></div>
	<div id="floatMenu">test</div>
</body>
</html>