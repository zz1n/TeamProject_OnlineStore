<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	margin: 0 auto;
}
</style>
<meta charset="EUC-KR">
<meta charset="UTF-8">
<script type="text/javascript">
/*
$(document).ready(function() {
	//이메일 유효성
	$("#umail3").change(function(){
        $("#umail2").val( $("#umail3").val());
    });
	$("#input").on('click',function(){
		inputchk();
	})
});

	function inputchk() {
		var f = document.form;

		//아이디 유효성
		var vid = /^[A-Za-z0-9]{4,12}$/;
		var cid = f.userid.value;
		if (cid == "") {
			alert("아이디는 공백일 수 없습니다.");
			f.userid.select();
			return false;
		}
		if (!vid.test(cid)) {
			alert("아이디는 영문자와 숫자포함 4~12자리로 입력해야합니다.");
			f.userid.select();
			return false;
		}

		//패스워드 유효성
		var vpw = /^[A-Za-z0-9]{6,12}$/;
		var cpw = f.userpw.value;
		if (cpw == "") {
			alert("비밀번호는 공백일 수 없습니다.");
			f.userpw.select();
			return false;
		}
		if (!vpw.test(cpw)) {
			alert("비밀번호는 영문자와 숫자 6~12자리로 입력해야합니다.");
			f.userpw.select();
			return false;
		}

		//비밀번호확인
		var p1 = f.userpw.value;
		var p2 = f.userpw2.value;
		if (p1 != p2) {
			alert("비밀번호가 일치 하지 않습니다");
			return false;
		}
		//전화번호 유효성
		var vmobile = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
		var cmobile = f.umobile.value;
		if (!vmobile.test(cmobile)) {
			alert("전화번호 입력 형식을 맞춰주세요.");
			f.umobile.select();
			return false;
		}
		//아이디 중복체크 유효성
		var cchk = f.chk.value;
		if(cchk != 0){
			alert("아이디 중복 확인 후 가입 가능합니다.");
			f.chk.select();
			return false;
		}
		if(cchk == ""){
			alert("아이디 중복 확인 후 가입 가능합니다.");
			f.chk.select();
			return false;
		}
		//이메일
		
		
		var vemail = /^[A-Za-z0-9]{4,12}$/;
		var cemail = f.umail1.value;
		if (cemail == "") {
			alert("이메일은 공백일 수 없습니다.");
			f.umail1.select();
			return false;
		}
		if (!vemail.test(cemail)) {
			alert("이메일은 영문자와 숫자 4~12자리로 입력해야합니다.");
			f.umail1.select();
			return false;
		}
		var cemail2 = f.umail2.value;
		if (cemail2 == "") {
			alert("메일주소를 선택해주세요.");
			f.umail2.select();
			return false;
		}
		var umail1 = $('#umail1').val();
		var umail2 = $('#umail2').val();
		var umail = umail1 + '@' + umail2;
		$('#umail1').val(umail);		
		
		f.submit();
}
*/	

</script>
<title>회원가입</title>
</head>
<body>

	<form name="form" action="loginnsave" method="post" name = "form">
		<table align="center">
	
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid" id="userid">
					<button type="button" id="idCheck" value="N" onclick="idCheck();">중복체크</button>
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="userpw" id="userpw" style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="password" name="userpw2" id="userpw2" style="margin-right: 59px;"></td>
			</tr>
				<tr>
				<th>닉네임</th>
				<td><input type="text" name="uname" id="uname" style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="umail1" id="umail1">@
				<select name="umail2" id="uamil2" title="이메일 주소 선택" onchange="selectEmail(this)">
						<option value="1">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
				</select> <input type="hidden" name="uemail"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="umobile"
					placeholder="ex) 010-1234-5678" style="margin-right: 59px;"></td>
			</tr>
			<tr>
			<th>우편번호1</th>
			<td><input type="text" name="uzlpcode1" style="margin-right: 59px;"></td>
			</tr>
				<tr>
			<th>주소1</th>
			<td><input type="text" name="uaddress1" style="margin-right: 59px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>
			</tr>
		</table>
	</form>
</body>
</html>