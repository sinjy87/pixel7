<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css"> 
.rcreate{
  font-size: 20px;
  font-weight:bold;
  text-align: left;
  border-style: solid;   /* 실선 */
  border-width: 1px;     /* 선 두께 */
  border-color: #AAAAAA; /* 선 색깔 */
  color: #000000;        /* 글자 색깔 */
  width: 35%;            /* 화면의 30% */ 
  padding: 10px;         /* 위 오른쪽 아래 왼쪽: 시간 방향 적용 */
  
  /* padding: 50px 10px;  50px: 위 아래, 10px: 좌우 */
  /* padding-top: 30px;  상단만 간격을 30px 지정   */
  
/*   margin: 20px auto; /* 가운데 정렬 기능, 20px: 위 아래, auto: 오른쪽 왼쪽*/ */
}
.rlist{
  line-height:1.2em;
  font-size: 15px;
  font-weight:bold;
  text-align: left;
  border-style: solid;   /* 실선 */
  border-width: 1px;     /* 선 두께 */
  border-color: #AAAAAA; /* 선 색깔 */
  color: #000000;        /* 글자 색깔 */
  width: 35%;            /* 화면의 30% */ 
  padding: 10px;         /* 위 오른쪽 아래 왼쪽: 시간 방향 적용 */
  
  /* padding: 50px 10px;  50px: 위 아래, 10px: 좌우 */
  /* padding-top: 30px;  상단만 간격을 30px 지정   */
  
/*   margin: 20px auto; /* 가운데 정렬 기능, 20px: 위 아래, auto: 오른쪽 왼쪽*/ */
}
hr{
  text-align: center;
  border-style: solid;   /* 실선 */
  border-width: 1px;     /* 선 두께 */
  border-color: #AAAAAA; /* 선 색깔 */
  width: 45%;            /* 화면의 30% */ 
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


	<br><br><hr>
	답변
<!-- 	<table border="1"> -->
<%-- 			<c:forEach var="qrdto" items="${rlist}"> --%>
<!-- 				<tr> -->
<!-- 					<th>작성자</th> -->
<%-- 					<td>${qrdto.id}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<%-- 					<td colspan="2">${qrdto.qna_rcontent}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<%-- 					<td colspan="2">${qrdto.qna_rdate}</td> --%>
<!-- 				</tr> -->

<%-- 				<c:if test="${sessionScope.id== qrdto.id  }"> --%>

<!-- 			   			<span style="float: right;"> -->
<%-- 			   				<a href="javascript:rupdate('${qrdto.qna_rnum}','${qrdto.qna_rcontent }')">수정</a>|<a href="javascript:rdelete('${rqdto.qna_rnum}')">삭제</a> --%>
<!-- 			   			</span> -->

<%-- 	   			</c:if> --%>
<%-- 			</c:forEach> --%>
<!--   	</table>	 -->



<c:forEach var="qrdto" items="${rlist}">
  <div class="rlist">
${qrdto.id}<br/>
<p>${qrdto.qna_rcontent}</p>
${qrdto.qna_rdate}
<c:if test="${sessionScope.id== qrdto.id  }">


			   			<span style="float: right;">
			   				<a href="javascript:rupdate('${qrdto.qna_rnum}','${qrdto.qna_rcontent}')">수정</a>|<a href="javascript:rdelete('${qrdto.qna_rnum}')">삭제</a>
			   			</span>
		   			
	   			</c:if>
	   			</div>
			</c:forEach>







	<c:if test="${sessionScope.grade == 'admin'}">
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
			  <input type="hidden" name="qna_rnum" value="0">
		  
		  </form>
	  </div>
	</c:if>
	${paging}

  <!--  댓글관련 소스 끝 -->


</body>
</html>