<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#center{
margin-left: 150px}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<%-- <link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css"> --%>

</head>
<body>


		<!-- 좌측 메뉴 -->
		<tiles:insertAttribute  name="left" />
		<!-- 좌측 메뉴 끝 -->



		<!-- 내용 시작 -->
		<div id="center">
		<tiles:insertAttribute name="body" />
		</div>
		<!-- 내용 끝 -->


</body>
</html>