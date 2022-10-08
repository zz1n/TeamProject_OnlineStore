<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체 문의</title>
</head>
<body>
	<form action="usertosellersave" method="post">
		<table style="width: 500px">
			<tr>
				<td>${dto.pthumbnail }</td>
				<td>${dto.pname }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bname"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><div id="summernote" name="bcont"></div></td>
			</tr>
			<input type="hidden" name="pcode" value="${dto.pcode }">
		</table>
		<br>
		<input type="submit" value="상품 문의">
		<input type="reset" value="작성 취소">
	</form>
</body>
</html>