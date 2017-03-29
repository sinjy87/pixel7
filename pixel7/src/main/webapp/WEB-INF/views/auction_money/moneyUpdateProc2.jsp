<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function WindowClose(){
	location.href='${pageContext.request.contextPath}/Auction/tendering?id='+"${id}&auction_num="+${auction_num};
}
</script>
</head>
<body>
<div>
${id }남의
현제 보유중인 금액은${ReadValue}원이고<br>
충전할려는금액은${FormValue }원입니다<br>
충전이 완료되었습니다<br> 
총금액은 ${UpdateValue}원 입니다<br>
완료를 누르시면 경매상품리스트로 이동합니다 <br>
이용해주셔서 감사합니다<br>
<input type="button" value="완료" onclick="WindowClose()"/>
</div>
</body>
</html>