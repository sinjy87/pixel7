<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pixel7</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">

<style>
body, h1 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%
}

.bgimg {
	background-image: url('images/back.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}
</style>

</head>

<body>
	<div
		class="bgimg w3-display-container w3-animate-opacity w3-text-white">

		<div class="w3-display-middle">
			<a href="${pageContext.request.contextPath }/main"><h1 class="w3-jumbo w3-animate-top">Pixel7</h1></a>
			<hr class="w3-border-grey" style="margin: auto; width: 40%">
			<p class="w3-large w3-center">16 days left</p>
		</div>
	</div>
</body>
</html>
