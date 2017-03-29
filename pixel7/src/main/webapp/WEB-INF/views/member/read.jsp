<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

#bgphoto{
width:1000px;
height:500px;
background-image: url("http://localhost:8000/pixel7/member/${dto.bgphoto}");
background-size: 100% 100%;
}
#photo{
margin-left: 450px;
margin-top:450px;
width: 100px;
height: 100px;

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<div id="bgphoto"><img id="photo" alt="loding..." src="../member/${dto.photo }" ></div></th>
				
		
			<table>
				
					<th>*아이디</th>
					<td>${dto.id }</td>
				</tr>
				<tr>
					<th>프로필글</th>
					<td>${dto.profile }</td>
				</tr>
				
				
				<tr>
					<th>*E-mail</th>
					<td>${dto.email }</td>
				</tr>

				<tr>
					<th>관심항목</th>
					<td>${dto.interests}</td>
			</table>
			<input type="submit" value="수정"> <input type="button"
				value="취소" onclick="history.back()">
</body>
</html>