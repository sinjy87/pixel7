<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css"> 


.rcreate{
	margin-top: 50px;
}

hr{
/*   text-align: center; */
  border-style: solid;   /* 실선 */
  border-width: 1px;     /* 선 두께 */
  border-color: #AAAAAA; /* 선 색깔 */
 
}
 
 
</style>  

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
 function filedown(qna_filename){
	 
	 var url = "${pageContext.request.contextPath}/download";
	 url += "?dir=/qna/storage";
	 url += "&filename="+qna_filename;
	
	 location.href=url;
 }
</script>


<script type="text/javascript">

	function input(f){
		if(f.content.value==""){
			alert("댓글 내용을 입력하세요.");
			f.content.focus();
			return false;
		}
	}
	
	function rupdate(qna_rnum, qna_rcontent){
		var f = document.rform;
		f.qna_rcontent.value = qna_rcontent;
		f.qna_rnum.value = qna_rnum;
		f.rsubmit.value="수정";
		f.action="./rupdate"
	}
	function rdelete(qna_rnum){
		if(confirm("정말삭제 하겠습니까?")){ 
			var url = "./rdelete";
			url = url + "?qna_rnum="+qna_rnum;
			url = url + "&qna_num=${dto.qna_num}";
			url = url + "&nowPage=${param.nowPage}";
			url = url + "&col=${param.col}";
			url = url + "&word=${param.word}";
			location.href=url; 
		}
	}

</script>




</head>
<body>


<DIV class="container" style="width: 50%">

			<h2>질문게시판(Q&A)</h2><br><br>

		<TABLE class="table table-hover">
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
				<td colspan="3"><a href="javascript:filedown('${dto.qna_filename}')">${dto.qna_filename}</a></td>
			</tr>
		</TABLE>

		

		<DIV align="center">
				<input type="button" value="목록" onclick="location.href='./list'" class="btn btn-default">
			<c:if test="${sessionScope.id == dto.id}">
				<input type="button" value="수정" onclick="qna_update()" class="btn btn-default">
				<input type="button" value="삭제" onclick="qna_delete()" class="btn btn-default">
			</c:if>
		</DIV>


<!-- 댓글 관련 -->


	<br><br><hr>
	답변

	<c:forEach var="qrdto" items="${rlist}">
<!--   		<div class="rlist"> -->
			${qrdto.id}<br/>
			<p>${qrdto.qna_rcontent}</p>
			${qrdto.qna_rdate}
			
			<c:if test="${sessionScope.id== qrdto.id  }">
	   			<span style="float: right;">
	   				<a href="javascript:rupdate('${qrdto.qna_rnum}','${qrdto.qna_rcontent}')">수정</a>|<a href="javascript:rdelete('${qrdto.qna_rnum}')">삭제</a>
	   			</span>
   			</c:if>
<!-- 		</div> -->
	</c:forEach>

	<c:if test="${sessionScope.grade == 'admin'}">
  		<div class="rcreate">
		  <form name="rform" action="./rcreate" method="post" onsubmit="return input(this)">
		  	  <textarea rows="10%" cols="65%" name="qna_rcontent"></textarea>
		  	  <input type="submit" name="rsubmit" value="등록">
			  <input type="hidden" name="qna_num" value="${dto.qna_num}">
			  <input type="hidden" name="id" value="${sessionScope.id}">
			  <input type="hidden" name="nowPage" value="${param.nowPage}">
			  <input type="hidden" name="nPage" value="${nPage}">
			  <input type="hidden" name="col" value="${param.col}">
			  <input type="hidden" name="word" value="${param.word}">
			  <input type="hidden" name="qna_rnum" value="0">
		  
		  </form>
	  	</div>
	</c:if>
	${paging}

  <!--  댓글관련 소스 끝 -->
  
</DIV>



</body>
</html>