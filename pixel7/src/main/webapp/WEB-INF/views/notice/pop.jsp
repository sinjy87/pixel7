<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript">
function setCookie( name, value, expiredays ){
   var todayDate = new Date();
   todayDate.setDate( todayDate.getDate() + expiredays );
   document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";";
}
function closeWin(){
        if ( document.event_Fcondo.event.checked )
                setCookie("event_condo", "no" , 1); // 하루 쿠키 적용 (  마지막 인자값이 날자임 )        
}
</script>
<link href="${pageContext.request.contextPath }/css/style.css"
	rel="stylesheet" type="text/css">
</head>

<BODY BGCOLOR="#FFFFFF" onunload="closeWin()">
	<table border="0" cellpadding="0" cellspacing="0" width="90%"
		height="70%" align='center'
		style="margin-top: 10px; padding-top: 10px; padding-bottom: 10px">
		<tr>
			<td align="center">공지사항</td>
		</tr>
		<tr>
			<td>
				<table class='calendar' cellpadding="0" cellspacing="0" width='100%'
					align='center'>
					<tr>
						<td class='calendar_td' width='14%' align='center'>일</td>
						<td class='calendar_td' width='14%' align='center'>월</td>
						<td class='calendar_td' width='14%' align='center'>화</td>
						<td class='calendar_td' width='14%' align='center'>수</td>
						<td class='calendar_td' width='14%' align='center'>목</td>
						<td class='calendar_td' width='14%' align='center'>금</td>
						<td class='calendar_td' width='16%' align='center'>토</td>
					</tr>
					<!-- ******************** 날짜 출력 시작 ******************** -->
					${calendar}
					<!-- ******************** 날짜 출력 종료 ******************** -->
				</table>
			</td>
		</tr>
	</table>
	<div style="text-align: center">

		<a href="./cal/notice" target="blank">자세히보기</a>
	    
	    
	    <form name="event_Fcondo">
			<input type="checkbox" name="event"><font size=2>오늘하루 이 창을 열지않음</font> 
			<input type=button value="닫기" onclick="self.close()">
		</form>
		
	</div>
</body>
</html>

