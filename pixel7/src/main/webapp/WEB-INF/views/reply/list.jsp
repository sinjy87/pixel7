<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="util" uri="/ELFunctions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/**
 * 댓글 시작
 */
function check(tarea) {
	if('${sessionScope.id}' == ""){
		if(confirm("로그인후 댓글을 쓰세요")){
			var url = "../reply/login";
			url = url + "?no=${dto.img_num}";
			url = url + "&nowPage=${param.nowPage}";
			url = url + "&col=${param.col}";
			url = url + "&word=${param.word}";
			url = url + "&ino=img_num";
			url = url + "&bflag=../reply/list";
			location.href=url;
		}else{
			tarea.blur();
		}
	}
	
} 

/**
 * 댓글 생성
 */
function inout(f) {
	if('${sessionScope.id}' == ""){
		if(confirm("로그인후 댓글을 쓰세요")){
			var url = "../reply/login";
			url = url + "?no=${dto.img_num}";
			url = url + "&nowPage=${param.nowPage}";
			url = url + "&col=${param.col}";
			url = url + "&word=${param.word}";
			url = url + "&ino=img_num";
			url = url + "&bflag=../reply/list";
			location.href=url;
			return false;
		}else{
			return false;
		}
	}else if(f.content.value == ""){
		alert("댓글 내용을 입력하세요.");
		f.content.focus();
		return false;
	}
}

/**
 * 댓글 수정
 */
function update(reply_num,reply_content) {
	var ff = document.rf;
	ff.reply_num.value = reply_num;
	ff.reply_content.value = reply_content;
	ff.rsubmit.value="수정";
	ff.action="./update"
}

/**
 * 댓글 삭제
 */
function rdelete(reply_num) {
	if(confirm("정말삭제 하겠습니까?")){
		var url = "./delete";
		url = url + "?reply_num="+reply_num;
		url = url + "&nowPage=${nowPage}";
		url = url + "&col=${col}";
		url = url + "&word=${word}";
		location.href = url;
	}
}
/**
 * 댓글 관련 끝
 */

</script>

</head>
<body>
<div class="title">댓글</div>
<h2>${id }</h2> 
	<table>
		<tr>
			<th>댓글 번호</th>
			<th>ID</th>
			<th>글 내용</th>
			<th>등록일</th>
		</tr>
	<c:choose>
		<c:when test="${fn:length(list) == 0 }">
			<tr>
				<td colspan="3">등록된 글이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="dto">
		<tr>
			<td>
				<c:forEach begin="1" end="${dto.reply_indent }">
					<c:out value="$nbsp;$nbsp;" escapeXml="false"/>
				</c:forEach>
					<c:if test="${dto.reply_indent >0 }">
					<img src="${pageContext.request.contextPath }/images/re.jpg"
					width="30%" height="30%">
					</c:if>
					<a href="javascript:read('${dto.reply_num}')"></a>
					
					<c:if test="${util:newImg(fn:substring(dto.reply_date,0,10))}">
						<img src ="${pageContext.request.contextPath }/images/new.gif">
					</c:if>
			</td>
			<td>${dto.reply_num}</td>
			<td>${id}</td>
			<td>${dto.reply_content}</td>
			<td>${dto.reply_date }</td>
	<td>
		
     <div class="list">
     <c:if test="${sessionScope.id == dto.id }">
     <span style="float: right;">
     <a href="javascript:update('${dto.reply_num}','${dto.reply_content}')">
      수정</a>|<a href="javascript:rdelete('${dto.reply_num}')">삭제</a>
  	 		</span>
  		 </c:if>
  	</div>
 </td>
		</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
		
	</table>

<!-- 댓글생성 시작  -->
<hr>
  
  
  <form name="rf" action="./create" method="post" onsubmit="return input(this)">
  <textarea rows="3" cols="28" name="reply_content" onclick="check(this)"></textarea>
  <input type="submit" name="rsubmit" value="등록">
  <input type="hidden" name="img_num" value= "1">
  <input type="hidden" name="reply_num" value= "${dto.reply_num }">
  <input type="hidden" name="nowPage" value="${param.nowPage}">
  <input type="hidden" name="col" value="${param.col}">
  <input type="hidden" name="word" value="${param.word}">
<!-- 댓글 생성 끝 -->  
  
  </form>
 <!--  댓글 페이징 시작 --> 
  <div class="bottom">
  ${paging}
  </div>
  <!-- 댓글 페이징 끝 -->

</body>
</html>