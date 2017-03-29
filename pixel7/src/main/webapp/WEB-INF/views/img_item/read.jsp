<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<style type="text/css">
.filebox input { /* 파일 필드 숨기기 */
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
}
</style>
<style type="text/css">
#Rimg {
	width: AUTO;
	height: 500px;
	max-width: 900px;
}

#move {
	color: red;
	float: right;
	border: solid 1px black;
}
</style>
<script type="text/javascript">
	// function update() {
	// 	var url = "update"
	// 	url += "?img_num=${dto.img_num}";
	// 	location.href = url;
	// }

	function buy() {
		if ('${sessionScope.id}' == "") {
			alert("로그인을 하셔야 구입하실수 있습니다.");
			var url = "./login";
			location.href = url;
		} else if ('${grade}' == "seceder") {
			alert("구입할수 없는 상품입니다");
		} else {
			var url = "update"
			url += "?img_num=${dto.img_num}";
			location.href = url;
		}
	}
</script>
</head>
<body oncontextmenu="return false" onselectstart="return false"
	ondragstart="return false">

	<table>



		<div class="w3-container w3-card-2 w3-white w3-margin-bottom">
			<h2 class="w3-text-grey w3-padding-16">
				<i
					class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Product
			</h2>
			<tr>
				<td rowspan="7">
					<div class="w3-row-padding">
						<div class="w3-third w3-container w3-margin-bottom">
							<img id="Rimg" src="../img_item/storage/${dto.img_photo }"
								class="w3-hover-opacity" onclick="onClick(this)">
							<div class="w3-container w3-white"></div>
						</div>
					</div>
				</td>
			</tr>

		</div>





		<div class="w3-third"
			style="float: right; margin-top: 20px; margin-right: 20px;">
			<div class="w3-white w3-text-grey w3-card-4">
				<div class="w3-display-container">
					<img src="${photo }" style="width: 100%" alt="Avatar">
					<div class="w3-display-bottomleft w3-container w3-text-black">
						<h2>${dto.id }</h2>
					</div>
				</div>
				<div class="w3-container">
					<p>
						<i
							class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i>${dto.id }</p>
					<p>
						<i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i>${profile }
					</p>
					<p>
						<i
							class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>${email }</p>
					<hr>

					<div class="filebox">
						<b><p>Comment</p></b>
						<p>${dto.img_content }</p>
						<hr>
						<p>Price:${dto.img_price } 원</p>

						<p>Category: ${dto.img_category }</p>
						<p>
							<label for="buy">Buy</label> <input type="button" onclick="buy()"
								id="buy">
						</p>
						<hr>
						<!-- 						<p> 댓글</p> -->
					</div>
				</div>
			</div>
	</table>

	<div id="modal01" class="w3-modal w3-black" style="padding-top: 0"
		onclick="this.style.display='none'">
		<span class="w3-button w3-black w3-xlarge w3-display-topright">X</span>
		<div
			class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
			<img id="img01" class="w3-image">
			<p id="caption"></p>
		</div>
	</div>

	<script type="text/javascript">
		// Script to open and close sidebar
		function onClick(element) {
			document.getElementById("img01").src = element.src;
			document.getElementById("modal01").style.display = "block";
			var captionText = document.getElementById("caption");
			captionText.innerHTML = element.alt;
		}
	</script>


</body>
</html>