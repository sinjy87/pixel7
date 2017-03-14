<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form name='frm' method='POST' action='./create'
			enctype="multipart/form-data">
			<table>
				<tr>
					<th>프로필사진</th>
					<td><input type="file" value="파일업" name="photoMF"></td>
				</tr>
				<tr>
					<th>배경사진</th>
					<td><input type="file" value="파일업" name="bgphotoMF"></td>
				</tr>
				<tr>
					<th>프로필글</th>
					<td><input type="text" name="profile">
				</tr>
				<tr>
					<th>*아이디</th>
					<td><input type="text" name="id"></td>
					<td><div id="id_aj">비동기</div></td>
				</tr>
				<tr>
					<th>*비밀번호확인</th>
					<td><input type="password" name="password"></td>

				</tr>
				<tr>
					<th>*비밀번호확인</th>
					<td><input type="password" name="passwd_check"></td>
					<td><div id="passwd_aj">비동기</div></td>
				</tr>
				<tr>
					<th>*E-mail</th>
					<td><input type="text" name="email">
						<div id="email_cer">비동기</div> <br>
						<div id="email_aj">비동기</div></td>
					<td><input type="button" value="인증메일 발송"></td>
				</tr>

				<tr>
					<th>관심항목</th>
					<td><input type="checkbox" name="inter" value="인물">인물
						<input type="checkbox" name="inter" value="동물">동물 <input
						type="checkbox" name="inter" value="자연">자연</td>
			</table>
			<input type="submit" value="가입"> <input type="button"
				value="취소" onclick="history.back()">
		</form>
</body>
</html>