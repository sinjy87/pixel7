<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ex" uri="/ELFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>

<script type="text/javascript">
function f_cnt(notice_cnt){
    location.href='./upViewcntRant?notice_cnt=' + notice_cnt;

  }

function f_read(notice_no){
    location.href='./read?notice_no=' + notice_no;
/*  var f = document.frmData;
    f.action = './update.do';
    f.notice_no.value = notice_no;
    f.submit(); */
  }

  function f_update(notice_no){
    location.href='./update?notice_no=' + notice_no;
/*  var f = document.frmData;
    f.action = './update.do';
    f.notice_no.value = notice_no;
    f.submit(); */
  }
 
  // 이렇게 쓰면 post방식이 됨.
  // delete POST
   function f_delete(notice_no){
    var sw = confirm('정말로 삭제하시겠습니까?'); // sw=스위치
    if(sw == true){
      var f = document.frm;
      f.action = './delete';
      f.notice_no.value = notice_no;
      f.submit();     
    }

  } 

</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<!-- *********************************************** -->
<body style="margin: 0px">
<!-- *********************************************** -->

<div class="title">공지사항</div>
<FORM name='grm' method='POST' action='./list'>
<select name = "col">
<option value ="notice_title"
<c:if test="${col == notice_title }">selected='selected'</c:if>
 >제목</option>

<option value ="notice_content"
<c:if test="${col == notice_content }">selected='selected'</c:if>
>내용</option>

<option value ="id"
<c:if test="${col == id }">selected='selected'</c:if>
>관리자</option>

<option value ="total">전체출력</option>

</select>
<input type="text" name= "word" value='${word }'>
<input type="submit" value = "검색">
</FORM>
    
 ${grade }
 ${sessionScope.grade }
 
<table>
    <tr bgcolor="#AAAAAA">
        <th>번호</th>
        <th>레이블 날짜</th>
        <th>레이블</th>
        <th>제목</th>
        <th>
             <a href="javascript:f_cnt('${dto.notice_cnt }')">조회</a></th>        
        <th>관리자</th>
        <th>등록일</th>
        <th>기타</th>
    </tr>

<c:forEach var="dto" items="${list}">
  <tr bgcolor="#EEEEEE" 
      onMouseOver="this.style.backgroundColor='#ffffff'" 
      onMouseOut="this.style.backgroundColor='#EEEEEE'"> 
  <td align='center'>${dto.notice_no}</td>
  <td align='center'>${dto.notice_labeldate}</td>
  <td align='left'>
  <a href="javascript:f_read('${dto.notice_no}')">${dto.notice_label}</a></td>
  <td align='left'>
  <a href="javascript:f_read('${dto.notice_no}')">${dto.notice_title}</a>
  <c:if test="${ex:newImg(fn:substring(dto.notice_date,0,10)) }">
  <img src='${pageContext.request.contextPath}/images/new.gif'>
  </c:if>
  </td>
  <td align="center">${dto.notice_cnt}</td>
  <td align="center">${dto.id }</td>
  <td align="center">${fn:substring(dto.notice_date,0,10)}</td>
  <td align='center'>

  <c:if test="${not empty id && grade=='admin' }"> 
  <input type='button' value='U' onclick="f_update('${dto.notice_no}')" title='수정'>
  <input type='button' value='D' onclick="f_delete('${dto.notice_no}')" title='삭제'>
  <input type='button' value='등록' onclick="location.href='./create'">
  </c:if>
  </td>
  </tr>
</c:forEach>
    </table>
    
    <div class="bottom">
      <input type='button' value='달력보기' onclick="location.href='./notice'">
    </div>
    
    <!-- DELETE -->
    <form name='frm' method="post" action='./delete'>
      <input type='hidden' name='notice_no' value=''>
    </form>

    
   <DIV class='bottom'>
	${paging}

   </DIV>
 
    
    
<!-- *********************************************** -->
</body>
</html>
<!-- *********************************************** -->