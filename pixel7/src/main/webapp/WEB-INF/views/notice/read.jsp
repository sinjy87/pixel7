<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 수정 </title>
<script type="text/javascript">
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

function f_list(){  // 목록 
	location.href='./list';
} 
</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<!-- *********************************************** -->
<body style="margin: 0px">
<!-- *********************************************** -->

<div class="title">
  조회 및 수정
</div>
    
  <input type='hidden' name='notice_no' value='${dto.notice_no }'>
  
  <table>
    <tr>
      <th width='20%'>레이블 날짜</th>
      <td width='80%' align='left'>
        ${dto.notice_labeldate }
      </td>
    </tr>   
    <tr>
      <th>레이블</th>
      <td align='left'>
       ${dto.notice_label }
      
        </td>
    </tr>  
    <tr>
      <th>제목</th>
      <td align='left'>
      ${dto.notice_title } 
      </td>
    </tr>
    <tr>
      <th>내용</th>
      <td align='left'>
    ${dto.notice_content}
      </td>
    </tr>      
    <tr>
      <th>조회수</th>
      <td align='left'>
    ${dto.notice_cnt}
      </td>
    </tr>      
     
  </table>
  
  <div class="bottom">
    <input type="button" value="취소(목록)" onclick="f_list()">
   <c:if test="${not empty id && grade=='A' }"> 
  <input type='button' value='수정' onclick="f_update('${dto.notice_no}')" title='수정'>
   <input type='button' value='삭제' onclick="f_delete('${dto.notice_no}')" title='삭제'>
   </c:if>
  </div>
  
  <form name='frm' method="post" >
  <input type='hidden' name='notice_no' value=''>
  </form>
<!-- *********************************************** -->
</body>
</html>
<!-- *********************************************** -->


