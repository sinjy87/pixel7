<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#atestupdate").click(function(){
		$("#researchitem_contentUpdate").text("확인");
		$("#researchitem_contentDelete").text("취소");
		$("#divcontent1").text("");
		$("#divcontent1").append("<input type='text' name='content1'>");
		$("#test1").text("");
		$("#test2").text("");

		var researchitem_num = $("#hiddenresearchitem_num").val();
		
		$("#test1").append("<a id='atestupdatefinsh' href='javascript:researchitem_update("+researchitem_num+")'>확인</a>");
		$("#test2").append("<a id='atestupdatefinsh' href='#'>취소</a>");
	});
});

</script>


<script type="text/javascript">
function researchitem_update(researchitem_num){
	var url = "/chart/update";
	var form = document.createElement("form");
	form.method= "POST";
	form.action= url;

	form.submit();



}
</script>

</head>
<body>

		<table border="1">
			<c:forEach items="${list}" var="ridto">
				<tr>
					<th>${dto.research_num}</th>
					<th>${dto.research_title}</th>
					<th>관리</th>
				</tr>
				
					<c:if test="${not empty ridto.result1}">
						<tr>
							<th>1번 보기</th>
							<td>
								<div id="divcontent1">${ridto.result1}</div>
							</td>
							<td><a id="atestupdate" href="#"><span id="test1">수정</span></a>/
								<a id="atestdelete"  href="#"><span id="test2">삭제</span></a>
								<input type="hidden" id="hiddenresearchitem_num" value="${ridto.result2}">
							</td>
						</tr>
					</c:if> 
					
					
					
<%-- 					<c:if test="${not empty ridto.result3}"> --%>
<!-- 						<tr> -->
<!-- 							<th>2번 보기</th> -->
<!-- 							<td> -->
							
<%-- 								<div id="divcontent2">${ridto.result3}</div> --%>

<!-- 							</td> -->
<!-- 							<td><a href="javascript:researchitem_update()"><span id="researchitem_contentUpdate">수정</span></a>/ -->
<!-- 								<a href="javascript:researchitem_delete()"><span id="researchitem_contentDelete">삭제</span></a> -->
<!-- 							</td> -->
<!-- 						</tr>						 -->
<%-- 					</c:if>  --%>
<%-- 					<c:if test="${not empty ridto.result5}"> --%>
<!-- 						<tr> -->
<!-- 							<th>3번 보기</th> -->
<!-- 							<td> -->
							
<%-- 								<div id="divcontent3">${ridto.result5}</div> --%>

<!-- 							</td> -->
<!-- 							<td><a href="javascript:researchitem_update()"><span id="researchitem_contentUpdate">수정</span></a>/ -->
<!-- 								<a href="javascript:researchitem_delete()"><span id="researchitem_contentDelete">삭제</span></a> -->
<!-- 							</td> -->
<!-- 						</tr>						 -->
<%-- 					</c:if>  --%>
<%-- 					<c:if test="${not empty ridto.result7}"> --%>
<!-- 						<tr> -->
<!-- 							<th>4번 보기</th> -->
<!-- 							<td> -->
							
<%-- 								<div id="divcontent4">${ridto.result7}</div> --%>

<!-- 							</td> -->
<!-- 							<td><a href="javascript:researchitem_update()"><span id="researchitem_contentUpdate">수정</span></a>/ -->
<!-- 								<a href="javascript:researchitem_delete()"><span id="researchitem_contentDelete">삭제</span></a> -->
<!-- 							</td> -->
<!-- 						</tr>						 -->
<%-- 					</c:if> --%>
					
					
					
					
					
			</c:forEach>
		</table>
</body>
</html>