<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function add(){
	
	var url = "./create"
	
}


</script>

</head>
<body>

<form action="./create" method="POST">

	<table>
		<tr>
			<th>설문 제목</th>
			<td><input type="text" name="researchitem_title"></td>
			<td><input type="button" class="btn btn-default" value="추가" onclick="add()"></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>보기 </th> -->
<!-- 			<td><input type="text" name="researchitem_content"></td> -->
<!-- 			<td><input type="button" class="btn btn-default" value="추가" onclick="add()"></td> -->
<!-- 		</tr> -->
		
	</table>
	

</form>


</body>
</html>