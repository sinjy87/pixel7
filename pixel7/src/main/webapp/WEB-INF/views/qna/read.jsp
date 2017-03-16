<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
function qna_update(){
	var url = "./update?qna_num=${dto.qna_num}";
	url +="&col=${param.col}";
	url +="&word=${param.col}";
	url +="&nowPage=${param.nowPage}";
	url +="&oldfilename=${dto.qna_filename}";
	
	location.href=url;
}


function qna_delete(){
	var url = "./delete?qna_num=${dto.qna_num}";
	url +="&col=${param.col}";
	url +="&word=${param.col}";
	url +="&nowPage=${param.nowPage}";
	url +="&oldfilename=${dto.qna_filename}";
	
	location.href=url;
}

</script>


</head>
<body>


<table border="1">
	<tr>
		<th>번호</th>
		<Td>${dto.qna_num}</Td>
		<th>제목</th>
		<td>${dto.qna_title}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3">${dto.id}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">${dto.qna_content}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="3">${dto.qna_filename}</td>
	</tr>
</table>

<input type="button" value="목록" onclick="location.href='./list'">
<input type="button" value="수정" onclick="qna_update()">
<input type="button" value="삭제" onclick="qna_delete()">



<!-- 댓글 관련 -->

	<c:forEach var="qrdto" items="${rlist}">
	
		<br><br>
		<div class="rlist">
		
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${qrdto.id}</td>
			</tr>
			<tr>
				<td colspan="2">${qrdto.qna_rcontent}</td>
			</tr>
			<tr>
				<td colspan="2">${qrdto.qna_rdate}</td>
			</tr>
			
			<c:if test="${sessionScope.id==qrdto.id }">
			<div style="width: 300px;">
	   			<span style="float: right;">
	   				<a href="javascript:rupdate('${qrdto.qna_rnum}','${qrdto.qna_rcontent }')">수정</a>|<a href="javascript:rdelete('${rqdto.qna_rnum}')">삭제</a>
	   			</span>
	   		</div>
   			</c:if>
   			
   		</table>
		</div>
	
	
	
	</c:forEach>

  <div class="rcreate">
	  <form name="rform" action="./rcreate" method="post" onsubmit="return input(this)">
	  	  <textarea rows="3" cols="28" name="qna_rcontent"></textarea>
	  	  <input type="submit" name="rsubmit" value="등록">
		  <input type="hidden" name="qna_num" value="${dto.qna_num}">
		  <input type="hidden" name="id" value="${sessionScope.id}">
		  <input type="hidden" name="nowPage" value="${param.nowPage}">
		  <input type="hidden" name="nPage" value="${nPage}">
		  <input type="hidden" name="col" value="${param.col}">
		  <input type="hidden" name="word" value="${param.word}">
		  <input type="hidden" name="rnum" value="0">
	  
	  </form>
  </div>

	${paging}

  <!--  댓글관련 소스 끝 -->



</body>
</html>