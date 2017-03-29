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

<form action="./create" method="post" enctype="multipart/form-data">

	<DIV class="container" style="width: 50%">
	
	<h2>질문게시판 글 생성(Q&A)</h2><br><br>
	
	<TABLE class="table table-hover" >
		<tr>
			<th>제목</th>
			<td><input type="text" name="qna_title"> 비밀글<input type="radio" name="qna_check" value="1">전체글<input type="radio" name="qna_check" value="0" checked="checked"></td>
		</tr>
	
		<c:choose>
			<c:when test="${ not empty id}">
			<tr>
				<th>작성자</th>
				<td>${id}</td>
			</tr>
					<input type="hidden" name="id" value="${id}">
			</c:when>
			<c:otherwise>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="id" ></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="text" name="qna_password">
				</tr>
			</c:otherwise>
		</c:choose>
	
		<tr>
			<th>내용</th>
			<td> <textarea rows="10" cols="55%" name="qna_content"></textarea></td>
		
		</tr>
	
	
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="qna_MF"></td>
		</tr>
	
	
	
	
	</table>
		<DIV align="center">
			<input type="submit" class="btn btn-default" value="등록">
			<input type="button" class="btn btn-default" value="목록" onclick="location.href='./list'">
		</DIV>
	</DIV>
	
</form>




</body>
</html>