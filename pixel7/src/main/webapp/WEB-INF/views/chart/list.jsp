<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/httpRequest.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

function research_read(research_num, research_title){
	
	
	
	
	

	if(${not empty sessionScope.id}){

		var url = "./read?research_num="+research_num;
		url += "&research_title="+research_title;
		url += "";
		
		location.href= url;	
		
	}

	else if(${empty sessionScope.id}){
		alert("회원만 이용할 수 있습니다");
		return false;
	}

	else if(${cnt>0}){
		alert(flag);
		alert("이미 사용 하셨습니다.");
		return false;
	}
	
	
}

function research_update(research_num){
	var url = "./update?research_num="+research_num;
	url += "";
	
	location.href= url;
}

function research_delete(research_num){
	
	alert("진짜 삭제하시겠습니까??");
	
	var url = "./delete?research_num="+research_num;
	url += "";
	
	location.href= url;
}
</script>
</head>
<body>


<form action="./create" method="POST">
	<table border="1">
	
			<tr>
				<th>번호</th>
				<td>설문내용</td>
				<td>조회수</td>
				<td>결과</td>
				<c:if test="${not empty sessionScope.id && sessionScope.grade == 'admin'}">
					<td>관리</td>	
				</c:if>
			</tr>
		<c:choose>
			<c:when test="${empty fn:length(list)}">
				<tr>
					<td colspan="3">어무것도 없습니다.</td>
				<tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.research_num}</td>
						<td><a href="javascript:research_read(${dto.research_num},'${dto.research_title}')">${dto.research_title}</a></td>
						<td></td>
						<td><input type="button" value="설문조사 결과" onclick="chartview(${dto.research_num})"></td>
						<c:if test="${not empty sessionScope.id && sessionScope.grade == 'admin'}">
							<td><a href="javascript:research_update(${dto.research_num})">수정</a>/<a href="javascript:research_delete(${dto.research_num})">삭제</a></td>	
						</c:if>
					</tr>
				</c:forEach>
				
			</c:otherwise>
		</c:choose>
	</table>
	
	
	<input type="hidden" name=research_content value="${research_content}">
	
	
	<input type="button" value="홈" onclick="location.href='${pageContext.request.contextPath}'">
	<c:if test="${not empty sessionScope.id && sessionScope.grade == 'admin'}">
		<input type="button" value="설문추가" onclick="location.href='./create'">		
	</c:if>
	
	
	
</form>







		<div id="chartview"></div>
		
		
			<script type="text/javascript">
		function chartview(research_num) {
			if(${not empty sessionScope.id}){
				$(document).ready(function() {
					$.getJSON(
						"./view?research_num="+research_num,
						response);
		
		
				});
				function response(result, textStatus) {

				      // Load the Visualization API and the corechart package.
				      google.charts.load('current', {'packages':['corechart']});
	
				      // Set a callback to run when the Google Visualization API is loaded.
				      google.charts.setOnLoadCallback(drawChart);
	
				      // Callback that creates and populates a data table,
				      // instantiates the pie chart, passes in the data and
				      // draws it.
				      function drawChart() {
				    	  
				        // Create the data table.
				        var data = new google.visualization.DataTable();
				        data.addColumn('string', 'Topping');
				        data.addColumn('number', 'Slices');
				        data.addRows([
	
				       	  [ result[1], result[2]],
				       	  [ result[3], result[4]],
				       	  [ result[5], result[6]],
				       	  [ result[7], result[8]]
				          
				        ]);
	
				        // Set chart options
				        var options = {'title':'${dto.research_title}',
				                       'width':400,
				                       'height':300};
	
				        // Instantiate and draw our chart, passing in some options.
				        var chart = new google.visualization.PieChart(document.getElementById('chartview'));
				        chart.draw(data, options);
				      }
				}
			}
			else{
				alert("회원만 이용할 수 있습니다.");
				return false;
			}
		}
	</script>
		
		
		
		
		












</body>
</html>