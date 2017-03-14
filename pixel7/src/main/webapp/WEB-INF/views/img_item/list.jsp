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
width: 50%;
height: 50%;
}

</style>
</head>
<body>

	<c:forEach items="${list }" var="dto">

	<a href="javascript:read('${dto.img_num}')"><img id="img" alt="loding..." src="../img_item/storage/${dto.img_photo}">	
			</a>
	</c:forEach>

</body>
</html>