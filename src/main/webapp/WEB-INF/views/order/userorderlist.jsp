<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
</head>
<body>
<h3 style="text-align: center;">주문 내역</h3>

	<table width="500px" align="center">
		<c:forEach var="li" items="${list }">

			<tr>
				<td rowspan="3">${li.lto.pthumbnail }</td> <td>${li.oto.ocode }</td> <td align="right"><a href="orderdetail?ocode=${li.oto.ocode }">상세 주문 내역</a></td>
			</tr>
			<tr>
				<td>${li.lto.pname }</td> <td>${li.oto.ocount }개</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><fmt:formatNumber value="${li.oto.ocharge }" pattern="#,###,#00원"></fmt:formatNumber></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>