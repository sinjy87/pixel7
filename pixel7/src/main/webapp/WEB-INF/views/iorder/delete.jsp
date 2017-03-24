<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ut" uri="/ELFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta content="charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<FORM name='frm' method='POST' action='./delete'>
<input type="hidden" name="i_order_num" value="${i_order_num}">
<div class="content">
${i_order_num}

삭제하시겠습니까?




</div>
  
  <DIV class='bottom'>
    <input type='submit' value='삭제'>
  </DIV>
</FORM>

</body> 
</html>