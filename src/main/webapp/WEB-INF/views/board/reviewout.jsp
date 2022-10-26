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
<h3 style="text-align: center;">${lto.pname }에 작성한 후기</h3>
	<form>
		<table style="width: 500px">
			<tr>
				<td>상품</td>
				<td>${lto.pname }</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td>${dto.bdate }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${dto.bname }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${dto.bcont }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="reviewupdateget?bnum=${dto.bnum}">수정</a> &emsp;
				<a href="userreviewdel?bnum=${dto.bnum}" onclick="javascript:alert('정말 삭제하시겠습니까?');">삭제</a></td>
			</tr>
		</table>
	</form>
</body>
</html>