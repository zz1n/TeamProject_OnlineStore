<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- 판매자 로그인 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>판매자 로그인</title>
</head>
<body>
	<form name="fm" action="loginCheck" method="post">
	<input type="datetime" name="nowtime" id="nowtime" readonly>
		<table align="center">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="sellerid" id="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="sellerpw" id="pw"></td>
			</tr>
			<tr>
				<td></td>
				<td align="center" colspan="2"><input type="submit" value="로그인">
					&emsp; <input type="reset" value="취소"></td>
			</tr>
			<tr>
				<td colspan="3"><a href="sellerinput">회원가입</a>&emsp;<a
					href="selleridserch.jsp">아이디 찾기</a>&emsp;<a
					href="sellerpwserch.jsp">비밀번호 찾기</a></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	window.onload = function nowtime() {
		let today = new Date();
		var year = today.getFullYear();
		var month = ("0" + (today.getMonth() + 1)).slice(-2);
		var day = ("0" + today.getDate()).slice(-2);
		var hours = ("0" + today.getHours()).slice(-2);
		var minutes = ("0" + today.getMinutes()).slice(-2);
		var dateString = year + "-" + month + "-" + day + " " + hours + ":"
				+ minutes;
		console.log(dateString);
		document.getElementById('nowtime').value=dateString;
	}
</script>
</html>