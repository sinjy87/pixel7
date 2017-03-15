<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
function qna_update(){
	var url = "./update?qna_num=${dto.qna_num}";
	url +="&col=${param.col}";
	url +="&word=${param.col}";
	url +="&nowPage=${param.nowPage}";
	url +="&oldfilename=${dto.qna_filename}";
	
	location.href=url;
}

</script>


</head>
<body>


<table border="1">
	<tr>
		<th>번호</th>
		<Td>${dto.qna_num}</Td>
		<th>제목</th>
		<td>${dto.qna_title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">${dto.qna_content}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="3">${dto.qna_filename}</td>
	</tr>
</table>

<input type="button" value="목록" onclick="location.href='./list'">
<input type="button" value="수정" onclick="qna_update()">
<input type="button" value="삭제" onclick="location.href='./delete'">




</body>
</html>