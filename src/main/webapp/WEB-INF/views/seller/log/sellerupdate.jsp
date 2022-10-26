<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 유효성검사 -->
<script type="text/javascript">
	$(document).ready(function() {

		$("#input").on('click', function() {
			inputchk();
		})
	});
	function inputchk() {
		var f = document.form;

		//패스워드 유효성
		var vpw = /^[A-Za-z0-9]{6,12}$/;
		var cpw = f.sellerpw.value;
		if (cpw == "") {
			alert("비밀번호는 공백일 수 없습니다.");
			f.sellerpw.select();
			return false;
		}
		if (!vpw.test(cpw)) {
			alert("비밀번호는 영문자와 숫자 6~12자리로 입력해야합니다.");
			f.sellerpw.select();
			return false;
		}

		//비밀번호확인
		var p1 = f.sellerpw.value;
		var p2 = f.sellerpw2.value;
		if (p1 != p2) {
			alert("비밀번호가 일치 하지 않습니다");
			return false;
		}
		//전화번호 유효성
		var vmobile = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
		var cmobile = f.smobile.value;
		if (!vmobile.test(cmobile)) {
			alert("전화번호 입력 형식을 맞춰주세요.");
			f.smobile.select();
			return false;
		}
		//이메일
		var vemail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{3,30}$/;
		var cemail = f.semail.value;
		if (cemail == "") {
			alert("이메일은 공백일 수 없습니다.");
			f.semail.select();
			return false;
		}
		if (!vemail.test(cemail)) {
			alert("이메일은 영문자와 숫자 4~30자리로 입력해야합니다.");
			f.semail.select();
			return false;
		}

		f.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form name="form" action="sellerupsave" method="get">
		<input type="hidden" name="scode" value="${scode }" readonly>
		<table  align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="sellerid" value="${sto.sellerid }"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="sellerpw" id="sellerpw"
					style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" name="sellerpw2" id="sellerpw2"
					style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>상호명</td>
				<td><input type="text" name="scomname" value="${sto.scomname }"
					style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>대표자</td>
				<td><input type="text" name="sprename" value="${sto.sprename }"
					style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>사업자번호</td>
				<td><input type="text" name="sbusnum" value="${sto.sbusnum }"
					style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>통신판매 신고번호</td>
				<td><input type="text" name="scomsalenum"
					value="${sto.scomsalenum }" style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>사업장 소재지</td>
				<td><input type="text" name="scomaddress"
					value="${sto.scomaddress }" style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="semail" id="semail" 
					value="${sto.semail }">
				<td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="smobile" value="${sto.smobile }"
					style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td>회원가입일</td>
				<td><input type="text" name="srgtdate" value="${sto.srgtdate }"
					readonly style="margin-right: 59px;"></td>
			</tr>
			<tr>

				<td colspan="2" align="center"><input type="button"
					value="정보수정" id="input"> &emsp; &emsp; <input type="reset"
					value="입력취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>