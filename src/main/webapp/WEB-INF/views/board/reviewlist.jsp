<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align:center;">후기 목록</h3>
	<form action="#" method="post">
		<table style="width: 500px" align="center">
			<tr>
				<th>상품</th> <th>제목</th> <th>작성일자</th>
			</tr>
		<c:forEach var="li" items="${list }">
			<tr>
				<td>${li.lto.pname }</td>
				<td><a href="reviewout?bnum=${li.bto.bnum}">${li.bto.bname }</a></td>
				<td>${li.bto.bdate }</td>
			</tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>