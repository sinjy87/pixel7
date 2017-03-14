<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	url += "&img_photo=${dto.img_photo}";
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
		</tr>
		
		<tr>
		<td>
		<input type="button" value="update" onclick="update()"> 
		<td>
		<tr>

	</table>

</body>
</html>