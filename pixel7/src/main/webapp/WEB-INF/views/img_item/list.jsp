
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE >
<!--[if IE 6]>
<style type="text/css" media="screen">
ul.thumb li img.hover {
	margin-top:15px;
	background:url(/data/201101/IJ12943621730563/thumb_bg.gif) no-repeat center center;
	border: none;
}
ul.thumb li .title{color:#fff;width:185px;height:50px;margin:0;font-weight:900;background:url(/data/201101/IJ12943621730563/title.gif) no-repeat center center;padding:17px 0 0 0;text-align:center;}
</style>
<![endif]-->
<html lang="en">
<head>
<meta name="viewport" content="width:device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css"
	href="/data/201101/IJ12943621730563/zoomer.css" media="screen" />

<script type="text/javascript">
	function read(img_num) {
		var url = "read";
		url += "?img_num=" + img_num;
		location.href = url;
	}
</script>

<style>
body {
	margin: 0;
}

.flexbin {
	display: flex;
	overflow: hidden;
	flex-wrap: wrap;
	margin: -2.5px;
}

.flexbin:after {
	content: '';
	flex-grow: 999999999;
	min-width: 300px;
	height: 0;
}

.flexbin>* {
	position: relative;
	display: block;
	height: 300px;
	margin: 5px;
	flex-grow: 1;
}

.flexbin>*>img {
	height: 300px;
	object-fit: cover;
	max-width: 100%;
	min-width: 100%;
	vertical-align: bottom;
}

.flexbin.flexbin-margin {
	margin: 2.5px;
}

@media ( max-width : 768px) {
	.flexbin {
		display: flex;
		overflow: hidden;
		flex-wrap: wrap;
		margin: -2.5px;
	}
	.flexbin:after {
		content: '';
		flex-grow: 999999999;
		min-width: 150px;
		height: 0;
	}
	.flexbin>* {
		position: relative;
		display: block;
		height: 150px;
		margin: 2.5px;
		flex-grow: 1;
	}
	.flexbin>*>img {
		height: 150px;
		object-fit: cover;
		max-width: 100%;
		min-width: 100%;
		vertical-align: bottom;
	}
	.flexbin.flexbin-margin {
		margin: 2.5px;
	}
}

@media ( max-width : 400px) {
	.flexbin {
		display: flex;
		overflow: hidden;
		flex-wrap: wrap;
		margin: -2.5px;
	}
	.flexbin:after {
		content: '';
		flex-grow: 999999999;
		min-width: 100px;
		height: 0;
	}
	.flexbin>* {
		position: relative;
		display: block;
		height: 100px;
		margin: 2.5px;
		flex-grow: 1;
	}
	.flexbin>*>img {
		height: 100px;
		object-fit: cover;
		max-width: 100%;
		min-width: 100%;
		vertical-align: bottom;
	}
	.flexbin.flexbin-margin {
		margin: 2.5px;
	}
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
        <script type="text/javascript">
           
            $(document).ready(function() {
                var xOffset = 10;
                var yOffset = 30;
 				
                $(document).on("mouseover",".thumbnail",function(e){ //마우스 오버시
//                 	alert(' $(this).attr("src")');
//                 	alert(' $(this).attr("id")');
                	$("body").append("<table id='preview'><tr><td><img src='"+ $(this).attr("src") +"' width='400px' /></td></tr> <tr><td>"+$(this).attr("id")+"</td></tr></table>"); //보여줄 이미지를 선언                      
                    $("#preview")
                        .css("top",(e.pageY - xOffset) + "px")
                        .css("left",(e.pageX + yOffset) + "px")
                        .fadeIn("fast"); //미리보기 화면 설정 셋팅
                });
                 
                $(document).on("mousemove",".thumbnail",function(e){ //마우스 이동시
                    $("#preview")
                        .css("top",(e.pageY - xOffset) + "px")
                        .css("left",(e.pageX + yOffset) + "px");
                });
                 
                $(document).on("mouseout",".thumbnail",function(){ //마우스 아웃시
                    $("#preview").remove();
                });
                  
            });
        </script>
        <style>
            /* 미리보기 스타일 셋팅 */
            #preview{
                z-index: 9999;
                position:absolute;
                border:0px solid #ccc;
                background:#333;
                padding:1px;
                display:none;
                color:#fff;
            }
        </style>
</head>
<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false">


	<div class="flexbin flexbin-margin">
		<c:forEach items="${list }" var="dto">

			<a title="Lake and a mountain" href="javascript:read('${dto.img_num}')"> 
			<img class="thumbnail" 	src="../img_item/storage/${dto.img_photo}"  id="${dto.id }"></a>

		</c:forEach>
	</div>


</body>
</html>


