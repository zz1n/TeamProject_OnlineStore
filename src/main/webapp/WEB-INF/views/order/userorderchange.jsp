<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h3 style="text-align: center;">주문 정보 수정</h3>

<form action="userorderchangeset" method="post">
	<table>
		<tr>
			<td rowspan="3"><img src="${pageContext.request.contextPath }/image/${lto.pthumbnail }" width="100" height="100"/></td>
			<td>${lto.pname }</td>
			<td>${dto.odate }</td>
		</tr>
		<tr>
			<td>기존 주소 : ${dto.ozipcode } ${dto.oaddress }</td>
		</tr>
		<tr>
			<td>수정할 주소 : <input type="text" name="ozipcode" value="${dto.ozipcode }">
			<input type="text" name="oaddress" value="${dto.oaddress }"></td>
		</tr>
		<tr>
			<td rowspan="2"></td>
			<td>기존 배송메세지 : ${dto.omemo }</td>
		</tr>
		<tr>
			<td>수정할 배송메세지 : <input type="text" name="omemo" value="${dto.omemo }"></td>
		</tr>
		<input type="hidden" name="ocode" value="${dto.ocode }">
		<tr>
			<td colspan="3">
				<input type="submit" value="수정">
			<td>
		</tr>
	</table>
</form>

</body>
</html>