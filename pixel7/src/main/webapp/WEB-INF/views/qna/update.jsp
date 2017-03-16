<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="./update" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="qna_title"> 비밀글<input type="checkbox" name="qna_check" value="1">전체글<input type="checkbox" name="qna_check" value="0" checked="checked"></td>
			
		</tr>
		<tr>
			<th>작성자</th>
			<td>${id}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td> <textarea rows="10" cols="30" name="qna_content">${dto.qna_content}</textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="qna_MF">${dto.qna_filename}</td>
		</tr>
	
		
		
	
	
	</table>
	<input type="hidden" name="qna_num" value="${dto.qna_num}">
	<input type="hidden" name="oldfilename" value="${dto.qna_filename}">
	<input type="submit" value="등록">
	<input type="button" value="목록" onclick="location.href='./list'">
	
</form>

</body>
</html>