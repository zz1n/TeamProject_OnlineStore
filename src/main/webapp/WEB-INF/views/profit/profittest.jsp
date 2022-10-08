<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<style type="text/css">
.hidden_data {
  display: none;
}
.chart-container { 
  width: 400px;
  height: 400px;
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 4px;
}
</style>
<script type="text/javascript">
var dataLabel = $('.data_label').text();
var mydata = []; //빈 배열을 생성
var mydataList = $('.data li');
var ctx = $("#line-chart");

mydataList.each(function(){
  mydata.push($(this).text());//리스트마다의 값을 mydata에 저장
});


var data2020 = {
  label: dataLabel,
  data: mydata,
  backgroundColor: "rgba(39,79,76,.5)",
  borderColor: "rgb(39,79,76)",
  borderWidth: 1
};


var lineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
    datasets: [data2020]
  },
  options: {
    maintainAspectRatio: false,
    scales: {
      xAxes: [{ stacked: true }],
      yAxes: [{ stacked: true }]
    }
  }
});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>chart</h2>
<div class="hidden_data">
  <h4 class="data_label">2020</h4>
  <ul class="data">
    <li>10</li>
    <li>8</li>
    <li>6</li>
    <li>5</li>
    <li>12</li>
    <li>16</li>
    <li>17</li>
    <li>6</li>
    <li>7</li>
    <li>6</li>
    <li>11</li>
    <li>12</li>
  </ul>
</div>
<div class="chart-container">
  <canvas id="line-chart"></canvas>
</div>
</body>
</html>