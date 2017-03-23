<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery.js"></script>
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>


	<div id="chart_div"></div>
	<br />
		<button class="button button-blue" onclick="b17_1(17,'frist')">17년 상반기</button>
		<button class="button button-blue" onclick="b17_1(17,'second')">17년 하반기</button>

	<script type="text/javascript">
		function b17_1(year,month) {
			alert("호출");
			$(document).ready(function() {
				$.getJSON(
					"./stat_j?year="+year+"&month="+month,
					response);
	
	
			});
			function response(result, textStatus) {
				google.charts.load('current', {
					'packages' : [ 'bar' ]
				});
				google.charts.setOnLoadCallback(drawChart);
	
				function drawChart() {
					
					var data = google.visualization.arrayToDataTable([
						[ result[0], '가입자수', '탈퇴자수' ]
						
					
							
						, result[1],result[2],result[3],result[4],result[5],result[6]
					]);
	
					var options = {
						chart : {
							title : 'Company Performance',
							subtitle : 'Sales, Expenses, and Profit: 2014-2017',
						},
						bars : 'vertical',
						vAxis : {
							format : 'decimal'
						},
						height : 400,
						colors : [ '#1b9e77', '#d95f02', '#7570b3' ]
					};
	
					var chart = new google.charts.Bar(document.getElementById('chart_div'));
	
					chart.draw(data, google.charts.Bar.convertOptions(options));
	
				}
			}
		}
	</script>


</body>
</html>