<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
</head>
<body>
	<table>
		<tr>
			<th>일자</th>
			<th>판매금액</th>
			<th>환불금액</th>
			<th>실 매출</th>
		</tr>
		<c:forEach var="li" items="${list }">
		<c:set var="odate" value="${li.odate }"/>
			<tr>
				<td>${fn:substring(odate,0,10)} </td>
				<td><fmt:formatNumber value="${li.totcost}" pattern="#,##0원"/></td>
				<td><fmt:formatNumber value="${li.refundcost}" pattern="#,##0원"/></td>
				<td><fmt:formatNumber value="${li.totcost-li.refundcost}" pattern="#,##0원"/></td>
			</tr>
		</c:forEach>
</table>
</body>
</html>