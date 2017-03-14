<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidenav to 120px */
.w3-sidenav {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidenav (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>
</head>
<body>

<!-- Icon Bar (Sidenav - hidden on small screens) -->

<!-- Icon Bar (Sidenav - hidden on small screens) -->
<nav class="w3-sidenav w3-center w3-small w3-hide-small">	
  <!-- Avatar image in top left corner -->
  

<%--   <img id="img" src="${pageContext.request.contextPath }/images/rails.jpg" style="width:100%"> --%>
  
  
  <a class="w3-padding-large w3-black" href="${pageContext.request.contextPath }/main">
    <i class="fa fa-home w3-xxlarge"></i>
    <p>Main</p>
  </a>
  
  <a class="w3-padding-large w3-hover-black" href="${pageContext.request.contextPath }/img_item/create">
    <i class="fa fa-pencil" style="font-size:36px"></i>
    <p>Writing</p>
  </a>
  <a class="w3-padding-large w3-hover-black" href="${pageContext.request.contextPath }/img_item/list">
    <i class="fa fa-pencil" style="font-size:36px"></i>
    <p>	Marketplace</p>
  </a>
  <a class="w3-padding-large w3-hover-black" href="${pageContext.request.contextPath }/img_item/login">
    <i class="fa fa-pencil" style="font-size:36px"></i>
    <p>Login</p>
  </a>
  
<!--   <a class="w3-padding-large w3-hover-black" href="#photos"> -->
<!--     <i class="fa fa-eye w3-xxlarge"></i> -->
<!--     <p>ddd</p> -->
<!--   </a> -->
<!--   <a class="w3-padding-large w3-hover-black" href="#contact"> -->
<!--     <i class="fa fa-envelope w3-xxlarge"></i> -->
<!--     <p>CONTACT</p> -->
<!--   </a> -->
</nav>

<!-- Navbar on small screens (Hidden on medium and large screens) -->
<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
  <div class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#">HOME</a>
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#about">ABOUT</a>
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#photos">PHOTOS</a>
    <a class="w3-bar-item w3-button" style="width:25% !important" href="#contact">CONTACT</a>
  </div>
</div>
</body>
</html>