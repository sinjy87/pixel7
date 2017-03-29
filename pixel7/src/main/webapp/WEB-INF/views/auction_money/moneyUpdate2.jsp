<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function WindowClose(){
	window.close();
}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/Auction/bid/moneyUpdateProc" method="POST">
<input type="hidden" name="id" value="${id }">
<input type="hidden" name="auction_num" value="${auction_num }">
<table>
<tr>
<th>
ID:
</th>
<td>
${id }
</td>
</tr>
<tr>
<th>보유금액:</th>
<td>${money }원</td>
</tr>
<tr>
<th>충전:</th>
<td><input type="text" name="auction_money">원</td>
</tr>
</table>
<div>
<input type="submit" value="충전"/>
<input type="button" value="나가기" onclick="WindowClose()"/>
</div>
</form>
</body>
</html>