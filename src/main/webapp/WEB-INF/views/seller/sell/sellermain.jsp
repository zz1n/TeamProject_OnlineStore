<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  margin: 0 auto;
  text-align: center;
}
</style>
<script type="text/javascript">
	window.onload = function nowtime() {
		let today = new Date();
		var year = today.getFullYear();
		var month = ("0" + (today.getMonth() + 1)).slice(-2);
		var day = ("0" + today.getDate()).slice(-2);
		var hours = ("0" + today.getHours()).slice(-2);
		var minutes = ("0" + today.getMinutes()).slice(-2);
		var dateString = year + "-" + month + "-" + day + " " + hours + ":"
				+ minutes;
		console.log(dateString);
		document.getElementById('nowtime').value = dateString;
	}
</script>
<script>

</script>
<meta charset="UTF-8">
<title>판매자 주문관리</title>
</head>
<body>


	<!-- 판매자 메인화면(로그인 후) -->
	<form action="sellerorder1" method="get">
		<!-- 컨트롤러에서 입력받은 scode를 hidden으로 가지고있기 -->
		<input type="hidden" name="scode" value="${scode }">
		<c:forEach var="li" items="${list }">
			<table  width="1000" >
				<tr>
					<td colspan="2">
						<!-- 검색조건 --> <select name="serchcolumn" id="serchcolumn">
							<option value="ocode">주문번호</option>
							<option value="uname">회원명</option>
							<option value="umobile">회원연락처</option>
							<option value="oshipcode">송장번호</option>
					</select>&emsp;
					<input type="text" name="serchname" id="serchname"
						placeholder="ex) O0001"><input type="submit" value="검색">
					</td >
					<!-- 검색단어 -->			
				</tr>
				<tr colspan="5">
					<th>주문기간</th>
					<td><input type="date" name="orderday1"
						id="orderday1">~<input type="date" name="orderday2"
						id="orderday2"></td>
				</tr>
				<tr colspan="5">
					<td align="left">실시간 매출현황</td>
					<td align="right">최종 업데이트 일시:<input type="datetime"
						id="nowtime" name="nowtime" readonly style="margin-right: 210px;"></td>
				</tr>
				<tr>
					<th>구분</th>
					<th style="text-align: center;">오늘</th>
					<th>이번 달</th>
					<th>바로가기</th>
				</tr>
				<tr>
					<th>총 주문 금액</th>
					<td><a href="sellerorder?scode=${scode }"><fmt:formatNumber value="${li.daycost}" pattern="#,##0원"/></a></td>
					<td><a href="sellerorder?scode=${scode }"><fmt:formatNumber value="${li.monthcost}" pattern="#,##0원"/></a></td>
					<td><a href="sellerorder?scode=${scode }"><button
								type="button">주문조회</button></a></td>
					<!-- 결제조회,주문조회 같은 JSP페이지 사용 -->
				</tr>
				<tr>
					<th>총 환불 금액</th>
					<td><a href="sellRefund?scode=${scode }"><fmt:formatNumber value="${li.dayrefund}" pattern="#,##0원"/></a></td>
					<td><a href="sellRefund?scode=${scode }"><fmt:formatNumber value="${li.monthrefund}" pattern="#,##0원"/></a></td>
					<td><a href="sellRefund?scode=${scode }"><button
								type="button">환불조회</button></a></td>
					<!-- 환불조회는 별도의 JSP 페이지 사용 -->
				</tr>
				<tr>
					<th>총 실 결제금액</th>
					<td><a href=""><fmt:formatNumber value="${li.daycost-li.dayrefund}" pattern="#,##0원"/></a></td>
					<td><a href=""><fmt:formatNumber value="${li.monthcost-li.monthrefund}" pattern="#,##0원"/></a></td>
					<td><a href=""><button type="button">결제조회</button></a></td>
				</tr>
			</table>
			<h3>주문 상태</h3>
			<table  width = "1000">
				<tr>
					<th>입금전</th>
					<td><a href="">${li.checklist  }건</a></td>
				</tr>
				<tr>
					<th>배송준비중</th>
					<td><a href="sellerorder?scode=${scode }">${li.shipstate1}건</a></td>
				</tr>
				<tr>
					<th>배송중</th>
					<td><a href="sellerorder?scode=${scode }">${li.shipstate2 }건</a></td>
				</tr>
				<tr>
					<th>취소신청</th>
					<td><a href="sellRefund?scode=${scode }">${li.ostate4}건</a></td>
				</tr>
				<tr>
					<th>교환신청</th>
					<td><a href="sellRefund?scode=${scode }">${li.ostate2}건</a></td>
				</tr>
				<tr>
					<th>반품신청</th>
					<td><a href="sellRefund?scode=${scode }">${li.ostate3}건</a></td>
				</tr>

			</table>
		</c:forEach>
	</form>
</body>
</html>