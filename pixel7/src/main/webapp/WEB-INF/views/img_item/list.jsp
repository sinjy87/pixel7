<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function read(img_num) {
	var url = "read";
	url += "?img_num=" + img_num;
	location.href = url;
}


</script>
<style type="text/css">
 #img{ 
 width: 200px; 
 } 

body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}

</style>
</head>
<body class="w3-light-grey w3-content" style="max-width:1600px">

	<c:forEach items="${list }" var="dto">

	
	 <div class="w3-third w3-container w3-margin-bottom">
	<a href="javascript:read('${dto.img_num}')"><img id="img" alt="loding..." src="../img_item/storage/${dto.img_photo}" style="width:100%" class="w3-hover-opacity">	</a>
	      <div class="w3-container w3-white">
	      </div>
     </div>

	
	</c:forEach>

</body>
</html>