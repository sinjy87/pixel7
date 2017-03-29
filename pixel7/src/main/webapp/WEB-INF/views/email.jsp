<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>메일 인증</title>
</head>
<body>
<div class="container">
  <h4>인증</h4>
  <form action="./mail" method="post">
   <input type="text" name="incode" >
   <input type="submit" value="인증">
  </form>
</div>
</body>
</html> 