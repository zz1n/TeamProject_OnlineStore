<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>출력확인</td><td>출력확인</td><td>출력확인</td><td>출력확인</td><td>출력확인</td><td>출력확인</td><td>출력확인</td><td>출력확인</td>
</tr>
<c:forEach var="i" begin="1" end="${fn:length(list)}" step="1">
<tr>
<td>${list[i].ocode }</td>
<td>${list[i].scode }</td>
<td>${list[i].pcode }</td>
<td>${list[i].pname }</td>
<td>${list[i].oprofit }</td>
<td>${list[i].ocount }</td>
<td>${list[i].odate }</td>
<td>${list[i].oprofitTot }</td>
</tr>
</c:forEach>
</table>
</body>
</html>