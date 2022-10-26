<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  margin: 0 auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align: center;">문의 상세</h3>
	<form>
		<table style="width: 500px">
		<c:forEach var="li" items="${list }" varStatus="status">
			<tr>
				<td>글번호</td>	<td>${li.bnum }</td>
				<td>상품이름</td>	<td>${list2[status.index].pname }</td>
			</tr>
			<tr>
				<td>글제목</td>	<td>${li.bname }</td>
				<td>작성날짜</td>	<td>${li.bdate }</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>${li.bcont }</td>
			</tr>
			<tr>
				<td><a href="usertosellerdel?bnum=${li.bnum }" onclick="javascript:alert('정말 삭제하시겠습니까?');">삭제</a></td>
			</tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>