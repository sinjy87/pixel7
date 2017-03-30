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

	
<div class="container">


	<div class="container">
	<form method="post" action="./list">
		<div class="col-sm-2">	
			<select class="form-control" id="sel1" name="col">
					<option value="id" 		<c:if test="${col.equals('id')}"> "selected='selected'" </c:if>>아이디</option>
					<option value="qna_title" 	<c:if test="${col.equals('qna_title')}"> "selected='selected'" </c:if>>제목</option>
					<option value="total">전체출력</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input class="form-control w3-hover-blue" type="text" name="word" value="${word}" >
		</div>
			<input type='submit' value="검색" class="btn btn-default">
			<input type='button' value='등록'	onclick="location.href='./create'" class="btn btn-default">
	</form>
	</div>
	 <table class="table">
    	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>작성일</th>
			<th>글 상태</th>
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
                	<tr>
				
						<td class="w3-hover-red">${dto.qna_num}</td>
						<td class="w3-hover-green"><a href="javascript:check(${dto.qna_check},${dto.qna_num},'${dto.id}')">${dto.qna_title}</a></td>
						<td class="w3-hover-red">${dto.id}</td>
						<td class="w3-hover-red">${fn:substring(dto.qna_date,0,10)}</td>
						<td class="w3-hover-red">
							<c:choose>
								<c:when test="${dto.qna_check == 1}">
									비밀글
								</c:when>
								<c:otherwise>
									공개글
								</c:otherwise>
							</c:choose>
						</td>
		
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>

	${paging}
	
</div>
</body>
</html>