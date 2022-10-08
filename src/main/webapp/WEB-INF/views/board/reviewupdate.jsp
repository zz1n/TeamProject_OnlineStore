<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
</head>
<body>
	<form action="reviewupdateset" method="post">
		<table style="width: 500px">
			<tr>
				<td>상품</td>
				<td><input type="text" name="pcode" value="${dto.lto.pname }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bname" value="${dto.bto.bname }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcont" rows="10" cols="50">${dto.bto.bcont }</textarea></td>
			</tr>
			<input type="hidden" name="userid" value="user001">	<!-- 세션에서 가져오기 -->
			<input type="hidden" name="bnum" value="${dto.bto.bnum }">
		</table>
		<br>
		<input type="submit" value="후기 등록">
		<input type="reset" value="작성 취소">
	</form>
</body>
</html>