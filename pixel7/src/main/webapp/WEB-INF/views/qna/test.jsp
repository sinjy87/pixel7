<c:forEach var="qrdto" items="${rlist}">
  <div class="rlist">
${qrdto.id}<br/>
<p>${qrdto.qna_rcontent}</p>
${qrdto.qna_rdate}
<c:if test="${sessionScope.id== qrdto.id  }">


			   			<span style="float: right;">
			   				<a href="javascript:rupdate('${qrdto.qna_rnum}','${qrdto.qna_rcontent }')">수정</a>|<a href="javascript:rdelete('${rqdto.qna_rnum}')">삭제</a>
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
			  <input type="hidden" name="col" value="${param.col}">
			  <input type="hidden" name="word" value="${param.word}">
<!-- 			  <input type="hidden" name="rnum" value="0"> -->
		  
		  </form>
	  </div>
	</c:if>
	${paging}