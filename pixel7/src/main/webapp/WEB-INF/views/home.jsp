<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<title></title>

<script language="javascript">
            // 해당이름의 쿠키를 가져온다.
            function getCookie(cookie_name) {
                var isCookie = false;
                var start, end;
                var i = 0;

                // cookie 문자열 전체를 검색
                while(i <= document.cookie.length) {
                     start = i;
                     end = start + cookie_name.length;
                     // cookie_name과 동일한 문자가 있다면
                     if(document.cookie.substring(start, end) == cookie_name) {
                         isCookie = true;
                         break;
                     }
                     i++;
                }

                // cookie_name 문자열을 cookie에서 찾았다면
                if(isCookie) {
                    start = end + 1;
                    end = document.cookie.indexOf(";", start);
                    // 마지막 부분이라는 것을 의미(마지막에는 ";"가 없다)
                    if(end < start)
                        end = document.cookie.length;
                    // cookie_name에 해당하는 value값을 추출하여 리턴한다.
                    return document.cookie.substring(start, end);
                }
                // 찾지 못했다면
                return "";
            }
function openMsgBox()
{
        var eventCookie=getCookie("event_condo");
        // 쿠키가 없을 경우에만 (다시 보지 않기를 선택하지 않았을 경우.)
        if (eventCookie != "no")
            window.open('pop','_blank','width=500,height=450,top=100,left=500');
}
openMsgBox();   // 팝업창을 띄운다.
</SCRIPT>  

</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"> 

<h1>
	Hello world! Calender <br>
	${id}<br>
	${grade}<br>
	   
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  <a href="./cal/create">일정등록</a> </P>

<hr>
<c:import url="/cal/notice_home"></c:import>

<h1>

	Hello world!  안녕하세요
</h1>
<c:if test="${not empty id}">
<h2>${id }님이 로그인하셨습니다</h2>
</c:if>
<input type="button" value="로그인"
					onclick="location.href = '${pageContext.request.contextPath}/member/agree'">
<P>  The time on the server is ${serverTime}. </P>
  

  
  <!--  -->
  <input type="button" value="질문 게시판" onclick="location.href='./qna/list'"><br>
	<input type="button" value="설문조사" onclick="location.href='./chart/list'"><br>
	<input type="button" value="로그인" onclick="location.href='./login'"><br>
  
</body>
</html>
