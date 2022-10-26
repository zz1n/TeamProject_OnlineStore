<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  margin: 0 auto;
}
</style>
<meta charset="UTF-8">
<title>주문 내역</title>
</head>
<body>
<h3 style="text-align: center;">주문 내역</h3>
<form action="beforeorderlist" method="post">
	<table  width="900px" align="center">
		<c:forEach var="li" items="${list }" varStatus="status">
			<tr>
				<td rowspan="3"><img src="${pageContext.request.contextPath }/image/${list2[status.index].pthumbnail }" width="100" height="100"/></td> <td>${li.ocode}</td> <td align="right" style="width: 200px;"><a href="orderdetail?ocode=${li.ocode}">상세 주문 내역</a></td>
			</tr>
			<tr>
				<td>${list2[status.index].pname }</td> <td align="right">${li.ocount}개</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><fmt:formatNumber value="${li.ocharge}" pattern="#,###,#00원"></fmt:formatNumber></td>
			</tr>
			
		</c:forEach>
		<tr>
			<td>지난 주문 조회(3개월 단위로 가능합니다. 입력한 수~입력한 수+3개월)</td>
			<td><input type="text" name="stnrd">개월 전 &emsp; <input type="submit" value="검색"> </td>
		</tr>
	</table>
</form>
</body>
</html>