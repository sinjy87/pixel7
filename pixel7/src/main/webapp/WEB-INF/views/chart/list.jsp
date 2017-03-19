<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


<form action="./create">
	<table border="1">
	
			<tr>
				<th>번호</th>
				<td>설문내용</td>
				<td>보기</td>
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
						<th>${dto.research_num}.&nbsp;</th>
						<td>${dto.research_title}</td>
						<td>
						
							
								<input type="radio" name="rdo${i=i+1}1">${ridto.researchitem_content} 
								
								<input type="radio" name="rdo${i}2">${ridto.result3} 
								 
								<input type="radio" name="rdo${i}3">${ridto.result5} 
								 
								<input type="radio" name="rdo${i}4">${ridto.result7} 
								 
							
						</td>
					</tr>
				</c:forEach>
				
			</c:otherwise>
		</c:choose>
	</table>
</form>





<input type="button" value="설문조사 결과" onclick="location.href='./view'">
</body>
</html>