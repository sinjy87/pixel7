<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#bgphoto_size{
height: 300px;
width: 300px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form name='frm' method='POST' action='./upadte'
			enctype="multipart/form-data">
			<table>
				<tr>
					<th><img id="bgphoto_size" alt="loding..." src="../member/${dto.bgphoto }">
					</th>

					<td><input type="file" value="파일업" name="photoMF"></td>
				</tr>
				<tr>
					<th><img alt="loding..." src="../member/${dto.photo }"></th>
					<td><input type="file" value="파일업" name="bgphotoMF"></td>
				</tr>
				<tr>
					<th>*아이디</th>
					<td><input type="text" name="id" value="${dto.id }" readonly></td>
					<td><div id="id_aj">비동기</div></td>
				</tr>
				<tr>
					<th>프로필글</th>
					<td><input type="text" name="profile" value="${dto.profile }">
				</tr>
				<tr>
					<th>*비밀번호</th>
					<td><input type="password" name="password"></td>

				</tr>
				
				<tr>
					<th>*E-mail</th>
					<td><input type="text" name="email" value="${dto.email }">
						<div id="email_cer">비동기</div> <br>
						<div id="email_aj">비동기</div></td>
					<td><input type="button" value="인증메일 발송"></td>
				</tr>

				<tr>
					<th>관심항목</th>
					<td><input type="checkbox" name="inter" value="인물"
						<c:if test="${fn:indexOf(dto.interests,'인물')!=-1}">checked</c:if>>인물
						<input type="checkbox" name="inter" value="동물"
						<c:if test="${fn:indexOf(dto.interests,'동물')!=-1}">checked</c:if>>동물 <input
						type="checkbox" name="inter" value="자연"
						<c:if test="${fn:indexOf(dto.interests,'자연')!=-1}">checked</c:if>>자연</td>
			</table>
			<input type="submit" value="수정"> <input type="button"
				value="취소" onclick="history.back()">
		</form>
</body>
</html>