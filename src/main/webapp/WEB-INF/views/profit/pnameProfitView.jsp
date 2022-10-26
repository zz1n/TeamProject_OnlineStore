<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 별 매출</h3>
<table>
	<tr>
		<th>상품코드</th>
		<th>날짜</th>
		<th>총 판매금액</th>
		<th>총 환불금액</th>
		<th>실 판매금액</th>
	</tr>
		<c:forEach var="li" items="${list }">
		<c:set var="odate" value="${li.odate }"/>
			<tr>
				<td>${li.pcode }</td>
				<td>${fn:substring(odate,0,10)} </td>
				<td><fmt:formatNumber value="${li.totcost}" pattern="#,##0원"/></td>
				<td><fmt:formatNumber value="${li.refundcost}" pattern="#,##0원"/></td>
				<td><fmt:formatNumber value="${li.totcost-li.refundcost}" pattern="#,##0원"/></td>
			</tr>
	</c:forEach>
</table>
</body>
</html>