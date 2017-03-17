<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- Icon Bar (Sidebar - hidden on small screens) -->
	<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small">
		<!-- Avatar image in top left corner -->
		 <a
			href="${pageContext.request.contextPath}/"
			class="w3-bar-item w3-button w3-center w3-padding-large w3-black">
			<i class="fa fa-home w3-xxlarge"></i>
			<p>HOME</p>
		</a> <a href="${pageContext.request.contextPath}/reply/list"
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black">
			<i class="fa fa-user w3-xxlarge"></i>
			<p>list</p>
		</a> <a href="#photos"
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black">
			<i class="fa fa-eye w3-xxlarge"></i>
			<p>PHOTOS</p>
		</a> <a href="#contact"
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black">
			<i class="fa fa-envelope w3-xxlarge"></i>
			<p>CONTACT</p>
		</a>
	</nav>

	<!-- Navbar on small screens (Hidden on medium and large screens) -->
	<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
		<div
			class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
			<a href="#" class="w3-bar-item w3-button"
				style="width: 25% !important">HOME</a> <a href="#about"
				class="w3-bar-item w3-button" style="width: 25% !important">ABOUT</a>
			<a href="#photos" class="w3-bar-item w3-button"
				style="width: 25% !important">PHOTOS</a> <a href="#contact"
				class="w3-bar-item w3-button" style="width: 25% !important">CONTACT</a>
		</div>
	</div>
</body>
</html>