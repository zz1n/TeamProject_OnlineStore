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
	<form action="periodprofitcall" method="get">
		<input type="hidden" name="scode" value="${scode }" readonly>
		<h3>기간 별 매출조회</h3>
		<table>
			<tr>
				<th>조회설정</th>
				<td><select name="serchset">
						<option value="month">월별 매출</option>
						<option value="day">일별 매출</option>
				</select>
			<tr>
				<th>검색기간</th>
				<td colspan="3"><input type="date" name="begindate"
					id="begindate">~ <input type="date" name="enddate"
					id="enddate"> <input type="submit" value="조회"></td>
			</tr>
		</table>
	</form>
	<form action="pnameprofitcall" method="get">
		<input type="hidden" name="scode" value="${scode }" readonly>
		<h3>상품 별 매출조회</h3>
		<table>
			<tr>
				<th>상품코드</th>
				<td><input type="text" name="pcode"></td>
			</tr>
			<tr>
				<th>검색기간</th>
				<td colspan="3"><input type="date" name="begindate"
					id="begindate">~ <input type="date" name="enddate"
					id="enddate"> <input type="submit" value="조회"></td>
			</tr>
		</table>
	</form>
</body>
</html>