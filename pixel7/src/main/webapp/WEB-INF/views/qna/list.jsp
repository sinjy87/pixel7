<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>


<script type="text/javascript">

	function check(qna_check, qna_num, qna_id){
			if(qna_check == 0 || qna_id == '${id}' || '${grade}' == 'admin'){
				var url= "./read?qna_num="+qna_num;
				url += "&col=${col}";
				url += "&word=${word}";
				url += "&nowPage=${nowPage}";
				
				location.href=url;
			}
			else {
				alert("비밀글입니다."+ qna_id);
			}
		}
</script>

</head>
<body>

	질문게시판<br><br> 
	
	현재 로그인<br>


	

	 <table class="table" border="1">
    <thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>작성일</th>
			<th>비밀글 체크</th>
		</tr>
		    </thead>
		
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="5">작성 글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
                <tr class="success">
				
						<td>${dto.qna_num}</td>
						<td><a href="javascript:check(${dto.qna_check},${dto.qna_num},'${dto.id}')">${dto.qna_title}</a>
						</td>
						<td>${dto.id}</td>
						<td>${fn:substring(dto.qna_date,0,10)}</td>
						<td>${dto.qna_check}</td>
		
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>


	<input type="button" value="작성" onclick="location.href='./create'">
	<input type="button" value="홈"
		onclick="location.href='${pageContext.request.contextPath}'">

	${paging}
</body>
</html>