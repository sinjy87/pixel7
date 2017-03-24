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
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
    
    
    <input type="button" value="home" onclick="location.href='../'">

    		<c:forEach items="${list}" var="ridto">
				<input type="hidden" id="research_num" value="${ridto.research_num}">
				<input type="hidden" id="research_title" value="${dto.research_title}">
				<c:if test="${not empty ridto.result1}">
					<input type="hidden" id="researchitem_content1"	value="${ridto.result1}">
					<input type="hidden" id="researchitem_cnt1"	value="${ridto.cnt1}">
				</c:if> 
				<c:if test="${not empty ridto.result3}">
					<input type="hidden" id="researchitem_content3"	value="${ridto.result3}">
					<input type="hidden" id="researchitem_cnt3"	value="${ridto.cnt2}">
				</c:if> 
				<c:if test="${not empty ridto.result5}">
					<input type="hidden" id="researchitem_content5"	value="${ridto.result5}">						
					<input type="hidden" id="researchitem_cnt5"	value="${ridto.cnt3}">							
				</c:if> 
				<c:if test="${not empty ridto.result7}">
					<input type="hidden" id="researchitem_content7"	value="${ridto.result7}">							
					<input type="hidden" id="researchitem_cnt7"	value="${ridto.cnt4}">						
				</c:if>
			</c:forEach>
    
    
    
    
    
    
    
  </body>
</html>