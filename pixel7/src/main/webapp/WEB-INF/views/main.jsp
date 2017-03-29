<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<body>
<div>Main Page</div>
<h2>Hi ${id } ${grade }</h2>


</body>
</html>