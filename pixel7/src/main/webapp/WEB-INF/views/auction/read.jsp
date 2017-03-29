<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="/Auction_ELF"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
function aupdate(auction_num,id){
   var url="./update";
      url+="?auction_num="+auction_num;
   location.href=url;
};
function alist(){
	var url="./list";
	location.href=url;
};
</script>
<script type="text/javascript">
$(document).ready(function() {
	var timetest = $("#timetest");
	var num=${dto.auction_num};
	var auction_num={"auction_num":num};
	$.ajax({
		url : './closeTime',  
		data:auction_num,
		success : function(data) {
			$("#timetest").html(data);
		}
	});

});

</script>
<script type="text/javascript">
function windowOpne(num){
	var url="./tendering?id="+"${id}&auction_num="+num;
	window.open(url,'bid',"height=500,width=500,left=500,top=150");
	};
</script>
<script type="text/javascript">
function bidList(num){
	var url="./tenderingList?auction_num="+num;
	window.open(url,'BidList',"height=500,width=500,left=500,top=150");
};
</script>
</head>
<body>
	<table>
		<tr>
			<th colspan="2">경매 상품</th>
		</tr>
		<tr>
			<td rowspan="8"><img
				src="${pageContext.request.contextPath }/storage/auction/${dto.auction_item}"></td>
		</tr>
		<tr>
			<td>글번호:${dto.auction_num }</td>
		</tr>
		<tr>
			<td>등록자:${id }</td>
		</tr>
		<tr>
			<td>제목:${dto.auction_title }</td>
		</tr>
		<tr>
<%-- 			<td>등록날짜:${util:DateCut(dto.auction_stime)}</td> --%>
		</tr>
		<tr>
			<c:choose>
			<c:when test="${bidcheck==0}">
			<td>시작가: ${dto.auction_smoney }원</td>
			</c:when>
			<c:otherwise>
			<c:forEach items="${bmlist }" var="bm">
			<td>입찰최소값: ${bm.auction_bidmoney}원</td>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		
		</tr>
		<tr>
			<td>입찰자:${bid }명</td>
			<td>
			<c:if test="${bid>0 }">
			<input type="button" value="입찰자 목록" onclick="bidList(${dto.auction_num})"/>
			</c:if>
			</td>
		</tr>
		<tr>
		<td id="timetest"></td>
		</tr>
		<tr>
			<th>코멘트</th>
		</tr>
		<tr>
			<th>${dto.auction_content }</th>
		</tr>
		
	</table>
		<div >
		<input type="button" value="수정" onclick="aupdate(${dto.auction_num})" />
		<input type="button" value="리스트" onclick="alist()"/>
		<input type="button" value="입찰" onclick="windowOpne(${dto.auction_num})">
		</div>
</body>
</html>