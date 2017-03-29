<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function bidwindowclose(){
	window.close();
}
</script>
<style type="text/css">
div{
text-align: center;
}
</style>
<script type="text/javascript">
function bidList(){
	var url="./tenderingList?auction_num="+${auction_num};
	location.href=url;
}
</script>
</head>
<body>
<div>
${id }님의 ${auction_num }번의 상품 입찰등록을 성공했습니다.<br>
입찰등록한 금액은${dto.auction_bidmoney }원 이고<br>등록한 시간은 ${dto.auction_btime }입니다.<br>
잔액은 ${updateMoney }원 남았습니다.<br>
감사합니다.
<br>
<input type="button" value="확인" onclick="bidwindowclose()"/>
<input type="button" value="입찰자목록" onclick="bidList()"/> 
</div>
</body>
</html>