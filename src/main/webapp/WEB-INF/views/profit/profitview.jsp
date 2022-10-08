<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
</head>
<script>

$(document).ready(function() {

    
    var chartLabels = []; // 받아올 데이터를 저장할 배열 선언
    var chartData = []; 
    var month="";

    var cooContractNo = '<c:out value="${no}"/>';
    
    function createChart() {
        
        var ctx = document.getElementById("canvas").getContext("2d");
        LineChartDemo = Chart.Line(ctx, {
            data : lineChartData,
            options : {
                scales : {
                    yAxes : [ {
                        ticks : {
                            beginAtZero : true
                        }
                    } ]
                }
            }
        });
    }


    
    //selectList로 월을 선택해서 ajax로 받는다.
    $('#selectMonth').change(function() {
        var changeMonth = $('#selectMonth option:selected').val();
        month = changeMonth;
        console.log('month:'+month);
        
        
         
    });
    
    //버튼을 클릭하면 차트가 그려진다. createChart()함수를 안에다 선언해야지 차트값을 받더라...
    $('#btn').click(function(){
        
        chartLabels = [];
        chartData=[];
        
        //getJson으로 데이터 
        $.getJSON("./getDailyVisitor", {
            cooContractNo : cooContractNo,
            month : month
        }, function(data) {
            $.each(data, function(key, value) {
                
                chartLabels.push(value.statsDate);
                chartData.push(value.statsAmount);
            });
            
            lineChartData = {
                    labels : chartLabels,
                    datasets : [ {
                        label : "일별 방문자 수",
                        backgroundColor:"#bfdaf9",
                        borderColor: "#80b6f4",
                        pointBorderColor: "#80b6f4",
                        pointBackgroundColor: "#80b6f4",
                        pointHoverBackgroundColor: "#80b6f4",
                        pointHoverBorderColor: "#80b6f4",
                        fill: false,
                        borderWidth: 4,
                        data : chartData
                    } ]

                }
            createChart();
            
        });
    })

    
})
</script>
<body>

</body>
</html>