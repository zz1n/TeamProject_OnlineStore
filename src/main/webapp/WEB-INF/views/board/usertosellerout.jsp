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
<h3 style="text-align: center;">문의 상세</h3>
	<form action="#" method="post">
		<table style="width: 500px">
		<c:forEach var="li" items="${list }">
			<tr>
				<td>글번호</td>	<td>${li.bto.bnum }</td>
				<td>상품이름</td>	<td>${li.lto.pname }</td>
			</tr>
			<tr>
				<td>글제목</td>	<td>${li.bto.bname }</td>
				<td>작성날짜</td>	<td>${li.bto.bdate }</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>${li.bto.bcont }</td>
			</tr>
			<tr>
				<td><a href="usertosellerdel?bnum=${li.bto.bnum }" onclick="javascript:alert('정말 삭제하시겠습니까?');">삭제</a></td>
			</tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>