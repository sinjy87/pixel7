<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table, tr, th, td {
	border: 1px solid black;
	margin: auto;
}

div {
	text-align: center;
	margin-bottom: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>입찰자 목록</div>
	<c:choose>
		<c:when test="${fn:length(list)>0 }">
			<c:forEach items="${list }" var="dto">
				<c:forEach items="${dto.auctionList }" var="adto">
					<div>
						<table>
							<tr>
								<th>아이디</th>
								<th>시간</th>
								<th>입찰금액</th>
							</tr>
							<tr>
								<td>${dto.id }</td>
								<td>${dto.auction_btime }</td>
								<td>${dto.auction_bidmoney }원</td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</c:forEach>
		</c:when>
	</c:choose>
</body>
</html>