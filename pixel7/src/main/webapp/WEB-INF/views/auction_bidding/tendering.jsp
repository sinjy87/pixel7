<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,tr,th{
border: 1px solid black;
margin: auto;
margin-bottom: 5px;
text-align: center;
}
div{
text-align: center;
}
</style>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
function submits(f){
	var bid=f.auction_bidmoney.value;
	console.log(bid);
	if(parseInt("${bidmoneycheck}")==0 && bid<=parseInt("${auction_dto.auction_smoney}")){
		alert("입찰금액이 시작금액보다 같거나 낮을수 없습니다."+"\n"+"\t"+"다시 입력해 주세요");
		f.auction_bidmoney.focus();
		return false;
	}else if(parseInt("${bidmoneycheck}")>0 && bid<=parseInt("${bidmoney}")){
		alert("입력한 값이 입찰값보다 낮거나 같을수 없습니다");
		f.auction_bidmoney.focus();
		return false;
		}
	if(bid>parseInt("${money_dto.auction_money}")){
		var tf=confirm("입찰하시는 금액이 보유 금액보다 낮습니다 .\n 충전하시겠습니까?\n 확인을 누르시면 충전 페이지로 이동합니다");
		if(tf==true){
			$(".form").attr('action','${pageContext.request.contextPath}/Auction/bid/moneyUpdate');
			$(".form").attr('method','GET');
		}else{
			return false;
		}
	}
	var tf=confirm("입찰을 진행하시겠습니까?");
	if(tf==true){
		return true;
	}else{
		return false;
	}
}

</script>
</head>
<body>
<div><strong>상품</strong>
<table>
<tr>
<th>번호<br>${auction_dto.auction_num }</th>
</tr>
<tr>
<th>팜매자<br>${auction_dto.id}</th>
</tr>
<tr>
<th>사진<br><img src="${pageContext.request.contextPath }/storage/auction/${auction_dto.auction_item }"></th>
</tr>
<tr>
<c:choose>
<c:when test="${bidmoneycheck==0}">
<th>시작금액<br>${auction_dto.auction_smoney }원</th>
</c:when>
<c:otherwise>
<th>입찰금액<br>${bidmoney }원</th>
</c:otherwise>
</c:choose>

</tr>
<tr>
<th>즉시구입금액<br>${auction_dto.auction_bmoney}원</th>
</tr>
</table>
</div>
<div><strong>회원정보</strong>
<table>
<tr>
<th>회원ID<br>${money_dto.id }</th>
</tr>
<tr>
<th>보유금액<br>${money_dto.auction_money }원</th>
</tr>
</table>
</div>
<form class="form" action="./tenderingProc" method="POST" name="f" onsubmit="return submits(this)">
<input type="hidden" value="${money_dto.id }" name="id"/>
<input type="hidden" value="${auction_dto.auction_num }" name="auction_num"/>
<table>
<tr>
<th>입찰금액<br><input type="text" name="auction_bidmoney"/>원</th>
</tr>
</table>
<div><input type="submit" value="입찰"></div>
</form>
</body>
</html>