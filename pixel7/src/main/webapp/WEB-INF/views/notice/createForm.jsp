<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title> 등록 </title>
<script>
function inputCheck(f){
	
	if(f.notice_labeldate.value=="");
	 alert("날짜를 지정해주세요");
	 f.notice_labeldate.focus();
	 return false;
}

if(f.notice_label.value==""){
	alert("레이블을 지정해주세요");
	f.notice_label.focus();
	return false;
}

if(f.notice_title.value==""){
	alert("제목을 등록해주세요");
	f.notice_title.focus();
	return false;
}

if(f.notice_content.value==""){
	alert("내용을 등록해주세요");
	f.notice_content.focus();
	return false;


</script>

<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>

<!-- *********************************************** -->
<body style="margin: 0px;">
<!-- *********************************************** -->

<div class="title">
  등록
</div>
    
<FORM name="frmData" method="POST" action="./create"
      onsubmit="return inputCheck(this)">

  <TABLE>
  
<%--      #{id.SessionScope} --%>

 <tr>
      <th width='20%'>출력 날짜</th>
      <td width='80%'>
        <input type="date" name='notice_labeldate' size='10'>
       </td>
    </tr>  
    <tr>
      <th>출력 레이블</th>
      <td colspan='5' align='left'>
        <input type='text' name='notice_label' value='' size='20'>
        형식: 최대 20자
        </td>
    </tr>  
    <tr>
      <th>제목</th>
      <td>
      <input type='text' name='notice_title' value='' size='40'></td>      
    </tr>
    <tr>
      <th>내용</th>
      <td>
      <TEXTAREA name='notice_content' rows='10' cols='40'></TEXTAREA>
      </td>
    </tr>      
     
  </table>

  <div class="bottom">
    <input type="submit" value="저장">
    <input type="button" value="취소(목록)" onclick="history.back();">
  </div>
  
</FORM>

<!-- *********************************************** -->
</body>
</html>
<!-- *********************************************** -->

