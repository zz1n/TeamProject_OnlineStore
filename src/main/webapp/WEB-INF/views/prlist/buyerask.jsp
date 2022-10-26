<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1 style="text-align: center;">상품문의내역</h1>
	<table  width="1000px" align="center">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>상품코드</th>
			<th>등록날짜</th>
			<th>답변</th>
		</tr>
		<c:forEach items="${list}" var="pr">
		<tr>
			<td>${pr.bnum}</td>
			<td>${pr.bname}</td>
			<td>${pr.bcont}</td>
			<td>${pr.pcode}</td>
			<td>${pr.bdate}</td>
			<td><a href="selleranswer?bnum=${pr.bnum}&pcode=${pr.pcode}">답변하기</a>
		</tr>
		<input type="hidden" name="btype" value="${pr.btype}">
		<input type="hidden" name="reproot" value="${pr.reproot}">
		<input type="hidden" name="repstep" value="${pr.repstep}">
		<input type="hidden" name="repindent" value="${pr.repindent}">
		<input type="hidden" name="bcode" value="${pr.bcode}">
		</c:forEach>
	</table>


</body>
</html>