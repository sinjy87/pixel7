<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">

function research_read(research_num, research_title){
	
	var url = "./read?research_num="+research_num;
	url += "&research_title="+research_title;
	url += "";
	
	location.href= url;
	
}

function research_update(research_num){
	var url = "./update?research_num="+research_num;
	url += "";
	
	location.href= url;
}

function research_delete(research_num){
	
	alert("진짜 삭제하시겠습니까??");
	
	var url = "./delete?research_num="+research_num;
	url += "";
	
	location.href= url;
}


</script>


</head>
<body>


<form action="./create" method="POST">
	<table border="1">
	
			<tr>
				<th>번호</th>
				<td>설문내용</td>
				<td>조회수</td>
				<c:if test="${not empty sessionScope.id && sessionScope.grade == 'admin'}">
					<td>관리</td>	
				</c:if>
			</tr>
		<c:choose>
			<c:when test="${empty fn:length(list)}">
				<tr>
					<td colspan="3">어무것도 없습니다.</td>
				<tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.research_num}</td>
						<td><a href="javascript:research_read(${dto.research_num},'${dto.research_title}')">${dto.research_title}</a></td>
						<td></td>
						<c:if test="${not empty sessionScope.id && sessionScope.grade == 'admin'}">
							<td><a href="javascript:research_update(${dto.research_num})">수정</a>/<a href="javascript:research_delete(${dto.research_num})">삭제</a></td>	
						</c:if>
					</tr>
				</c:forEach>
				
			</c:otherwise>
		</c:choose>
	</table>
	
	
	<input type="hidden" name=research_content value="${research_content}">
	
	<input type="submit" value="확인">
	<input type="button" value="홈" onclick="location.href='${pageContext.request.contextPath}'">
	
	
</form>


</body>
</html>