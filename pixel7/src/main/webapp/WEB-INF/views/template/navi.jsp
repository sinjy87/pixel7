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

<script>
	function startTime() {
		var today = new Date();
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();
		m = checkTime(m);
		s = checkTime(s);
		document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;
		var t = setTimeout(startTime, 500);
	}
	function checkTime(i) {
		if (i < 10) {
			i = "0" + i
		}
		; // add zero in front of numbers < 10
		return i;
	}
</script>
<style>
body.b1 {
	font-family: "Lato", sans-serif;
}

.mySlides {
	display: none
}
</style>
<body onload="startTime()">



	<!-- Navbar -->
	<div class="w3-top">
		<ul class="w3-navbar w3-black w3-card-2 w3-left-align">




			<li><a href="${pageContext.request.contextPath }"
				class="w3-hover-none w3-hover-text-grey w3-padding-large">Home</a></li>



			<li class="w3-hide-small w3-dropdown-hover"><a
				href="javascript:void(0)" class="w3-hover-none w3-padding-large"
				title="member">PhotoGrapher(member) <i class="fa fa-caret-down"></i></a>
				<div class="w3-dropdown-content w3-white w3-card-4">
					<a href="${pageContext.request.contextPath }/admin/list">list</a> <a
						href="${pageContext.request.contextPath }/member/agree">agree</a>
					<c:choose>
						<c:when test="${not empty sessionScope.id  }">
						<a href="${pageContext.request.contextPath }/member/read">Mypage</a>
							<a href="${pageContext.request.contextPath }/member/logout">logout</a>
						</c:when>
						<c:otherwise>
						<a href="${pageContext.request.contextPath }/member/login">login</a>
						</c:otherwise>

					</c:choose>

					


				</div></li>


			<li class="w3-hide-small w3-dropdown-hover"><a
				href="javascript:void(0)" class="w3-hover-none w3-padding-large"
				title="photo">Photo(Image) <i class="fa fa-caret-down"></i></a>

				<div class="w3-dropdown-content w3-white w3-card-4">
					<a href="${pageContext.request.contextPath }/image/list">list</a>
					<a href="${pageContext.request.contextPath }/image/create">create</a>
				</div></li>




			<li class="w3-hide-small w3-dropdown-hover"><a
				href="javascript:void(0)" class="w3-hover-none w3-padding-large"
				title="More">BBS <i class="fa fa-caret-down"></i></a>

				<div class="w3-dropdown-content w3-white w3-card-4">
					<a href="${pageContext.request.contextPath }/bbs/create">create</a>
					<a href="${pageContext.request.contextPath }/bbs/list">list</a>
					<a href="#">^-^</a>
				</div></li>



			<li class="w3-hide-small w3-dropdown-hover"><a
				href="javascript:void(0)" class="w3-hover-none w3-padding-large"
				title="More">memo <i class="fa fa-caret-down"></i></a>

				<div class="w3-dropdown-content w3-white w3-card-4">
					<a href="${pageContext.request.contextPath }/memo/list">list</a>
					<a href="${pageContext.request.contextPath }/memo/create">create</a> <a href="#">~_~</a>
				</div></li>





			<li style="float: right;">
				<div align="right" id="txt" style="color: white; margin: 13px 10px">
				</div>
			</li>
		</ul>
	</div>

	<br>





	<script>
		// Used to toggle the menu on small screens when clicking on the menu button
		function myFunction() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		// When the user clicks anywhere outside of the modal, close it
		var modal = document.getElementById('ticketModal');
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>
