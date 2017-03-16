<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<div id="chart_div"></div>
	<br />
	<script type="text/javascript">
	
	
		google.charts.load('current', {
			'packages' : [ 'bar' ]
		});
		google.charts.setOnLoadCallback(drawChart);
	
		function drawChart() {
			var data = google.visualization.arrayToDataTable([
				[ 'Year', '가입자수', '탈퇴자수' ],
				[ '2014', 4, 0 ],
				[ '2015', 10, 10 ],
				[ '2016', 10, 10 ],
				[ '2017', 10, 10 ]
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
	
			var btns = document.getElementById('btn-group');
	
			btns.onclick = function(e) {
	
				if (e.target.tagName === 'BUTTON') {
					options.vAxis.format = e.target.id === 'none' ? '' : e.target.id;
					chart.draw(data, google.charts.Bar.convertOptions(options));
				}
			}
		}
	</script>
</body>
</html>