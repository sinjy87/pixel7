<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var timer = ${second};
        var hours,minutes,seconds;
		var hours = timer / 3600;
		var minutes = timer / 60 % 60;
		var seconds = timer % 60;
		var time;
		$("#time").html('마감시간:'+'0'+hours+'시'+'0'+minutes+'분'+'0'+seconds+'초');
		var interval = setInterval(function() {
			hours = parseInt(timer / 3600, 10);
			minutes = parseInt(timer / 60 % 60, 10);
			seconds = parseInt(timer % 60, 10);
			hours = hours < 10 ? "0" + hours : hours;
			minutes = minutes < 10 ? "0" + minutes : minutes;
			seconds = seconds < 10 ? "0" + seconds : seconds;
			time=hours+minutes+seconds;
			$("#time").html("남은시간:"+hours+"시"+minutes+"분"+seconds+"초");
			  if (--timer < 0) {
		            timer = 0;
		            clearInterval(interval);
		        }
		}, 1000); 
	});
// $(document).ready(function(){
// 	var timer=${second};
// 	var auction_num=${auction_num};
// 	console.log(timer);
// 	console.log(auction_num);
// 	var datas;
// 	var interval=setInterval(function(){
// 		if(timer>0){
// 			timer=timer-1;
// 		}
// 	datas={"auction_time":timer,"auction_num":auction_num};
// 		$.ajax({
// 			url:"./closeTimeSum",
// 			data:datas,
// 			success:function(data){
// 				$("#time").html(data);
// 			}
// 		})
// 	},1000);	
// });
</script>
<div id="time">${second }</div>
