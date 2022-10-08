<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align: center;">${dto.pcode }에 작성한 후기</h3>
	<form action="#" method="post">
		<table style="width: 500px">
			<tr>
				<td>상품</td>
				<td>${dto.lto.pname }</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td>${dto.bto.bdate }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${dto.bto.bname }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${dto.bto.bcont }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="reviewupdateget?bnum=${dto.bto.bnum}">수정</a> &emsp;
				<a href="userreviewdel?bnum=${dto.bto.bnum}" onclick="javascript:alert('정말 삭제하시겠습니까?');">삭제</a></td>
			</tr>
		</table>
	</form>
</body>
</html>