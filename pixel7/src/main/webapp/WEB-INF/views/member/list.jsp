<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<DIV class="title">회원목록</DIV>

	<div class="search">
		<FORM name='frm' method='POST' action='./list'></FORM>
		<select name="col">
		
		
			<option value="mname"
				<c:if test="${col=='mname' }">selected='selected'</c:if>>이름</option>

			<option value="email"
				<c:if test="${col=='email' }">selected='selected'</c:if>>이메일</option>

			<option value="id"
				<c:if test="${col=='id' }">selected='selected'</c:if>>아이디</option>

			<option value="total">전체출력</option>

		</select> <input type="text" name="word" value='${word }'> <input
			type="submit" value="검색"> <input type="button" value="회원가입"
			onclick="location.href='${pageContext.request.contextPath}/member/agree'">
	</div>
	<c:forEach items="${list }" var="dto">
	
	<TABLE>

		<TR>
			<TD rowspan='5' class ="td_size"><img class="img_size" 
				src='${pageContext.request.contextPath}/member/storage/${dto.photo}'></TD>
			<TH width="20%">아이디</TH>
			<TD width="50%"><a href="javascript:read('${dto.id}')">${dto.id}</a></TD>
		</TR>

		<TR>
			<TH>이름</TH>
		</TR>

		<TR>
			<TH>전화번호</TH>
		</TR>

		<TR>
			<TH>이메일</TH>
			<TD>${dto.email }</TD>
		</TR>

		<TR>
			<TH>주소</TH>

			</TD>
		</TR>


	</TABLE>
</c:forEach>
	<DIV class='bottom'>
		${paging }

	</DIV>
</body>
</html>