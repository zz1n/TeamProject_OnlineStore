<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 판매자 회원가입 -->
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 가입일 오늘날짜 설정 -->
<script type="text/javascript">
	window.onload = function() {
		today = new Date();
		console.log("today.toISOString() >>>" + today.toISOString());
		today = today.toISOString().slice(0, 10);
		console.log("today >>>> " + today);
		bir = document.getElementById("todayin");
		bir.value = today;
	}
</script>
<!-- 아이디 중복체크 -->
<script type="text/javascript">
	$('idCheck').click(function() {
		var sellerid={"sellerid":sellerid=$('#sellerid').val()};
		var data=JSON.stringify(sellerid);
		var $.ajax({
			url :"idCheck",
			method:"POST",
			data:{data:data},
			dataType: "json"
		});
		request.done(function (data) {
			console.log(data.result)
			if(data.result=="Y"){
			$('#idCheck').attr('idCheck','Y');
			alert('사용 가능한 아이디입니다.');
			} else{
				$('#idCheck').attr('idCheck','N');
				alert('사용할 수 없는 아이디입니다.');
			}
			
		});
		request.fail(function (jqXHR, mtextStatus) {
			alert("request failed:"+textStatus);
		});
	});
</script>
<!-- 유효성검사 -->
<script type="text/javascript">
	$('input').click(function {
		var f = document.form;

		//아이디 유효성
		var vid = /^[A-Za-z0-9]{4,12}$/;
		var cid = f.sellerid.value;
		if (cid == "") {
			alert("아이디는 공백일 수 없습니다.");
			f.sellerid.select();
			return false;
		}
		if (!vid.test(cid)) {
			alert("아이디는 영문자와 숫자포함 4~12자리로 입력해야합니다.");
			f.sellerid.select();
			return false;
		}

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
		
		//이메일 유효성
		$("#email3").change(function(){
            $("#email2").val( $("#email3").val() );
        });
		}
	
		$('form').submit(function() {
			var semail1 = $('input[name=semail1]').val();
			var semail2 = $('input[name=semail2]').val();
			var semail = semail1 + '@' + semail2;
			$('input[name=semail]').val(semail);
			return false;
		});
	});
	f.submit;
</script>
<title>판매자 회원가입</title>
</head>
<body>
	<form name="form" action="sinsave" method="post">
		<table border="1" align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="sellerid" id="sellerid">
					<button type="button" id="idCheck" value="N" onclick="idCheck();">중복체크</button>
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="sellerpw" id="sellerpw"></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" name="sellerpw2" id="sellerpw2"></td>
			</tr>
			<tr>
				<td>상호명</td>
				<td><input type="text" name="scomname"></td>
			</tr>
			<tr>
				<td>대표자</td>
				<td><input type="text" name="sprename"></td>
			</tr>
			<tr>
				<td>사업자번호</td>
				<td><input type="text" name="sbusnum"></td>
			</tr>
			<tr>
				<td>통신판매 신고번호</td>
				<td><input type="text" name="scomsalenum"></td>
			</tr>
			<tr>
				<td>사업장 소재지</td>
				<td><input type="text" name="scomaddress"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="semail1" id="semail1">@
				<input type="text" name="semail2" id="semail2"> 
				<select name="semail3" id="semail3" title="이메일 주소 선택" onchange="selectEmail(this)">
						<option value="1">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
				</select> <input type="hidden" name="semail"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="smobile"
					placeholder="ex) 010-1234-5678"></td>
			</tr>
			<tr>
				<td>회원가입일</td>
				<td><input type="date" name="srgtdate" id="todayin" readonly></td>
			</tr>
			<tr>

				<td colspan="2" align="center"><input type="button"
					value="회원가입" id="input"> &emsp; &emsp; <input type="reset"
					value="가입취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>