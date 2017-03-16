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
     // delete GET
/*   function f_delete(notice_no){
    location.href='./delete.do?notice_no=' + notice_no;
    }  */ 
  


</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<!-- *********************************************** -->
<body style="margin: 0px">
<!-- *********************************************** -->

<div class="title">
  목록
</div>

<table>
    <tr bgcolor="#AAAAAA">
        <th>번호</th>
        <th>레이블 날짜</th>
        <th>레이블</th>
        <th>제목</th>
        <th>조회</th>        
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
  <td align="center">${fn:substring(dto.notice_date,0,10)}</td>
  <td align='center'>
  <input type='button' value='U' onclick="f_update('${dto.notice_no}')" title='수정'>
  <input type='button' value='D' onclick="f_delete('${dto.notice_no}')" title='삭제'>
  </td>
  </tr>
</c:forEach>
    </table>
    
    <div class="bottom">
      <input type='button' value='등록' onclick="location.href='./create'">
      <input type='button' value='달력보기' onclick="location.href='./notice'">
    </div>
    
    <!-- DELETE -->
    <form name='frm' method="post" action='./delete'>
      <input type='hidden' name='notice_no' value=''>
    </form>
<!-- *********************************************** -->
</body>
</html>
<!-- *********************************************** -->


