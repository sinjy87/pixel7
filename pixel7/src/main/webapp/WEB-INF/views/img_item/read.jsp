<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#Rimg{
width: 500px;
height: 500px;
}

</style>
<script type="text/javascript">
function update() {
	var url = "update"
	url += "?img_num=${dto.img_num}";
	location.href = url;
}


</script>
</head>
<body>

	<table>

		<tr>
			<td rowspan="7"><img id = "Rimg" src="../img_item/storage/${dto.img_photo }"></td>
		</tr>
		<tr>
			<td>Content:${dto.img_content }</td>
		</tr>
		<tr>
			<td>Price:${dto.img_price }$</td>
		</tr>

		<tr>
			<td>Category: ${dto.img_category }	</td>
			<td>id=${dto.id }</td>
			<td>sessionid=${sessionScope.id }</td>
		</tr>
		
		<c:if test = "${ sessionScope.id == dto.id}">
		<tr>
		<td>
		<input type="button" value="update" onclick="update()"> 
		<td>
		</c:if>
		
<%-- 		<c:if test="${not empty sessionScope.id== dto.id }"> --%>
<!-- 		<tr> -->
<!-- 		<td> -->
<!-- 		<input type="button" value="delete">  -->
<!-- 		<td> -->
<!-- 		<tr> -->
<%-- 		</c:if> --%>

	</table>

</body>
</html>