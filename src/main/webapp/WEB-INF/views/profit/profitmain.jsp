<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns:th=""http://www.thymeleaf.org">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
</head>
<title>매출현황</title>
<body>
	<div style="width: 60%">

		<div>

			<canvas id="canvas" height="450" width="600"></canvas>

		</div>

	</div>
	<form>
		검색기간<br> <input type="date" name="begindate" id="begindate">~<input
			type="date" name="enddate" id="enddate">
		<button type="button" id="dateSerch" onclick="">검색</button>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>

	<script>
		$('#dateSerch').click(
				function() {

					var chartLabels = [];

					var chartData = [];
					var scode = "s00001";
					var begindate = $("#begindate").val();
					var enddate = $("#enddate").val();
					var profitdata = {
						"scode" : scode,
						"begindate" : begindate,
						"enddate" : enddate
					};
					var profitdata = JSON.stringify(profitdata);
					$.ajax({
						type : "get",
						url : "incomeList",
						data : {
							"profitdata" : profitdata
						},
						success : function(txt) {
							alert("자료검색 성공");
						},
						error : function(txt) {
							alert("에러발생");
						}
					});
					$.getJSON("http://localhost:8686/shop/profit/incomeList", //입력받은 데이터를 불러온다
							function(data) {

								$.each(data, function(list, obj) {
									chartLabels.push(obj.odate);  //여기에 출력문 가져오기 (선생님한테 받은거 넣어보자)
									chartData.push(obj.oprofitTot);

								});

								createChart();

								console.log("create Chart")

							});

					var lineChartData = {

						labels : chartLabels,

						datasets : [

						{

							label : "Date Income",

							fillColor : "rbga(151,187,205,0.2)",

							strokeColor : "rbga(151,187,205,1)",

							pointColor : "rbga(151,187,205,1)",

							pointStrokeColor : "#fff",

							pointHighlightFill : "#fff",

							pointHighlightStroke : "rbga(151,187,205,1)",

							data : chartData

						}

						]

					}

					function createChart() {

						var ctx = document.getElementById("canvas").getContext(
								"2d");

						LineChartDemo = Chart.Line(ctx, {

							data : lineChartData,

							options : {
								maintainAspectRatio : false,

								scales : {

									yAxes : [ {

										ticks : {

											beginAtZero : true

										}

									} ]

								}

							}

						})

					}
				});
	</script>
<form action="profitcall" method="get">
<h3>매출조회</h3>
<table>
	<tr>
		<th>기간설정</th>
		<td><input type="date" name="begindate">~<input type="date" name="enddate"></td>
		<td><input type="submit" value="검색"></td>
		</tr>
</table>
</form>
</body>
</html>