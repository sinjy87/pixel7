<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">

function riCheck(reserachitem_num){
	
	document.frm.researchitem_num.value = reserachitem_num;
}

function chartview(){
	var url = "./view?research_num="+$("#research_num").val();
	location.href = url;
}

</script>

</head>
<body>
					
		<form name="frm" action="./create" method="post">
			<DIV class="container" style="width: 50%; text-align: center">
			
				<h2>설문 조사</h2>
			
			<TABLE class="table table-hover">
				<c:choose>
					<c:when test="${not flag}">
						이미 하셨습니다.	<input type="button" value="확인" onclick="history.back()">
					</c:when>
		
					<c:otherwise>
						<c:forEach items="${list}" var="ridto">
							<tr>
								<th>${ridto.research_num}</th>
								<th>${param.research_title}</th>
							</tr>
							<tr>
								<td colspan="2">
									<c:if test="${not empty ridto.result1}">
										<input type="radio" name="researchitem_content"	value="${ridto.result1}" onclick="riCheck(${ridto.result2})">${ridto.result1} &nbsp;&nbsp;&nbsp;                    
									</c:if> 
									<c:if test="${not empty ridto.result3}">
										<input type="radio" name="researchitem_content"	value="${ridto.result3}" onclick="riCheck(${ridto.result4})">${ridto.result3} &nbsp;&nbsp;&nbsp;
									</c:if> 
									<c:if test="${not empty ridto.result5}">
										<input type="radio" name="researchitem_content" value="${ridto.result5}" onclick="riCheck(${ridto.result6})">${ridto.result5} &nbsp;&nbsp;&nbsp;
									</c:if> 
									<c:if test="${not empty ridto.result7}">
										<input type="radio" name="researchitem_content"	value="${ridto.result7}" onclick="riCheck(${ridto.result8})">${ridto.result7} &nbsp;&nbsp;&nbsp;
									</c:if>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" value="확인 ">
									<input type="button" value="홈 " onclick="location.href='${pageContext.request.contextPath}'">
								</td>
							</tr>
							
							<input type="hidden" name="id" value="${sessionScope.id}">
							<input type="hidden" name="researchitem_num" value="">
							<input type="hidden" id="research_num" value="${ridto.research_num}">
							
						</c:forEach>
							
					</c:otherwise>
						
				</c:choose>
				
			</table>
			</DIV>
		</form>
			
		

</body>
</html>