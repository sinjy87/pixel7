<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="전체쪽지"
		onclick="location.href='./list?col=total'">
	<input type="button" value="보낸쪽지"
		onclick="location.href='./list?col=id'">
	<input type="button" value="받은쪽지"
		onclick="location.href='./list?col=message_id'">
	<FORM name='frm' method='POST' action='./list'>
		<select name="col">


			<option value="message_id"
				<c:if test="${col=='message_id' }">selected='selected'</c:if>>받은ID</option>

			<option value="content"
				<c:if test="${col=='content' }">selected='selected'</c:if>>내용</option>

			<option value="id"
				<c:if test="${col=='id' }">selected='selected'</c:if>>보낸ID</option>

			<option value="total">전체출력</option>

		</select> <input type="text" name="word" value='${word }'> <input
			type="submit" value="검색">
	</FORM>

	<c:forEach items="${list }" var="dto">

		<TABLE>
			<TR>
				<td>받은사람</td>
				<td>내용</td>
				<td>보낸사람</td>
			</TR>
			<TR>
				<TH>${dto.message_id }</TH>
				<TD>${dto.message_content }</TD>
				<TD>${dto.id }</TD>
				<td><input type="button" value="전체쪽지"
					onclick="javascript:dele()"></td>
			</TR>
		</TABLE>
		<script type="text/javascript">
			function dele() {
				var result = confirm('쪽지를 삭제 하시겠습니까???');
				if (result) {
					url = "./delete";
					url = url + "?message_num=${dto.message_num}";
					location.href = url;
				}
			}
		</script>
	</c:forEach>


	${paging }


	<input type="button" value="" onclick="">
</body>
</html>