<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<body onload="startTime()">



	<!-- Icon Bar (Sidebar - hidden on small screens) -->
	<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small">
		<!-- Avatar image in top left corner -->
		<img src="/w3images/avatar_smoke.jpg" style="width: 100%"> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-black"
			href="#"> <i class="fa fa-home w3-xxlarge"></i>
			<p>HOME</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/read"> <i
			class="fa fa-user w3-xxlarge"></i>
			<p>read</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/login"> <i
			class="fa fa-user w3-xxlarge"></i>
			<p>login</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/logout"> <i
			class="fa fa-user w3-xxlarge"></i>
			<p>logout</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/agree"> <i
			class="fa fa-envelope w3-xxlarge"></i>
			<p>create</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/update"> <i
			class="fa fa-envelope w3-xxlarge"></i>
			<p>update</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/delete"> <i
			 class="fa fa-envelope w3-xxlarge"></i>
			<p>delete</p>
		</a> <a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/list"> <i class="fa fa-envelope w3-xxlarge"></i>
			<p>list</p>
		</a><a
			class="w3-bar-item w3-button w3-center w3-padding-large w3-hover-black"
			href="${pageContext.request.contextPath }/member/list?col=grade&word=admin"> <i class="fa fa-envelope w3-xxlarge"></i>
			<p>adminlist</p>
		</a>
	</nav>


	<!-- Navbar on small screens (Hidden on medium and large screens) -->
	<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
		<div
			class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
			<a class="w3-bar-item w3-button" style="width: 25% !important"
				href="#">HOME</a> <a class="w3-bar-item w3-button"
				style="width: 25% !important" href="#about">ABOUT</a> <a
				class="w3-bar-item w3-button" style="width: 25% !important"
				href="#photos">PHOTOS</a> <a class="w3-bar-item w3-button"
				style="width: 25% !important" href="#contact">CONTACT</a>
		</div>
	</div>

</body>
</html>
