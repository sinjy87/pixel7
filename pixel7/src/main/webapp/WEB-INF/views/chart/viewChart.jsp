<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
 <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {
    	  
    	  var content1 = $('#researchitem_content1').val();
    	  
    	  var content1_cnt = parseInt($("#researchitem_cnt1").val());
    	  
        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
       	  [ content1, content1_cnt],
          [$('#researchitem_content3').val(), parseInt($("#researchitem_cnt3").val())],
          [$('#researchitem_content5').val(), parseInt($("#researchitem_cnt5").val())],
          [$('#researchitem_content7').val(), parseInt($("#researchitem_cnt7").val())]
          
        ]);

        // Set chart options
        var options = {'title':'${dto.research_title}',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    
    
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
    
    
    
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
    
    
    <input type="button" value="home" onclick="location.href='../'">
	<input type="button" value="다음" onclick="javascript:nextView(${ridto.research_num+1})">
    

    
    
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