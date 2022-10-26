<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#mar {
  margin: 0 auto;
}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<section id= mar>
<form action="UserUpdate" method="post">

<table>

<label class="control-label" for="userpw">비밀번호</label>
<input  type="password" id="userpw" name="userpw"/> <br>

<label class="control-label" for="uname">닉네임</label>
<input  type="text" id="uname" name="uname"/> <br>

<label class="control-label" for="uzlpcode1">우편번호1</label>
<input  type="text" id="uzlpcode1" name="uzlpcode1"/>

<label class="control-label" for="uaddress1">주소1</label>
<input type="text" id="uaddress1" name="uaddress1"/> <br>


<label class="control-label" for="uzlpcode2">우편번호2</label>
<input type="text" id="uzlpcode2" name="uzlpcode2"/>

<label class="control-label" for="uaddress2">주소2</label>
<input type="text" id="uaddress2" name="uaddress2"/> <br>


<label class="control-label" for="uzlpcode3">우편번호3</label>
<input  type="text" id="uzlpcode3" name="uzlpcode3"/>


<label class="control-label" for="uaddress3">주소3</label>
<input type="text" id="uaddress3" name="uaddress3"/> <br>


<label class="control-label" for="uemail">이메일</label>
<input type="text" name="umail1" id="umail1">@
				<select name="umail2" id="uamil2" title="이메일 주소 선택" onchange="selectEmail(this)">
						<option value="1">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
				</select> <br>


<label class="control-label" for="umobile">전화번호</label>
<input type="text" id="umoblie" name="umobile"/> <br>



<button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
<button class="cencle btn btn-danger" type="button">취소</button>
</table>
</form>

</section>
</body>
</html>