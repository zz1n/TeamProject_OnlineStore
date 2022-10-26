<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  margin: 0 auto;
  text
}
</style>
	<!--  jQuery, bootstrap -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

	<!-- summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<meta charset="UTF-8">

<script>
    // 메인화면 페이지 로드 함수
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: '내용을 작성하세요',
            height: 400,
            maxHeight: 400,
            width: 600
        });
    });
</script>

<script type="text/javascript">
function vcheck(){
	var f = document.form;
	var cbname = f.bname.value;
	var cbcont = f.bcont.value;
	
	if(cbname==""){
		alert("제목은 공백일 수 없습니다.")
		f.bname.select();
		return false;
	}
	
	if(cbcont==""){
		alert("내용은 공백일 수 없습니다.")
		f.bcont.select();
		return false;
	}
	
	f.submit();
}
</script>
<meta charset="UTF-8">
<title>사이트 문의</title>
</head>
<body>
<h3 style="text-align: center;">사이트 문의</h3>
	<form action="usertositesave" method="post">
		<table  style="width: 500px">
			<tr>
				<td>제목&emsp;&emsp;<input type="text" name="bname"></td>
			</tr>
			<tr>
				<td><textarea id="summernote" name="bcont"></textarea></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="사이트 문의">
		<input type="reset" value="작성 취소">
	</form>
</body>
</html>