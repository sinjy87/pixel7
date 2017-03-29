<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="util" uri="/Auction_ELF" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 리스트이동
function alist(){
   var url="./list";
	location.href=url;
}
//title 입력값 체크
function titles(f){
    if(f.auction_content.value==""){
    	alert("수정할 타이틀 값을 입력해주세요");
    	f.auction_content.focus();
	    return false;
    }
}
</script>
</head>
<body>
<form action="./updateProc" Method="POST" onsubmit="return titles(this)">
<input type="hidden" name="auction_num" value="${dto.auction_num }">
<table>
<tr>
<th colspan="2">경매 상품</th>
</tr>
<tr>
<td rowspan="6"><img src="${pageContext.request.contextPath }/storage/auction/${dto.auction_item}"></td>
</tr>
<tr><td>글번호:${dto.auction_num }</td></tr>
<tr><td>등록자:${dto.id }</td></tr>
<tr><td>제목:${dto.auction_title }</td></tr>
<tr><td>등록날짜:${util:DateCut(dto.auction_stime)}</td></tr>
<tr><td>시작가:${dto.auction_smoney }원</td></tr>
<tr><td>현제입찰자수:</td></tr>
<tr><th>코멘트:${dto.auction_content}</th><td>수정할 코멘트:<input type="text" name="auction_content" ></td></tr>
</table> 
<input type="button" value="목록" onclick="alist()">
<input type="submit" value="수정">
</form>
</body>
</html>