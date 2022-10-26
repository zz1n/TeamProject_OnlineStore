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
	<!--  jQuery, bootstrap -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

	<!-- summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

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

<meta charset="UTF-8">
<title>리뷰 작성</title>
</head>
<body>
	<form action="reviewupdateset" method="post">
		<table style="width: 600px">
			<tr>
				<td>상품</td>
				<td>${lto.pname }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bname" value="${dto.bname }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="summernote" name="bcont">${dto.bcont }</textarea></td>
			</tr>
			<input type="hidden" name="userid" value="user001">	<!-- 세션에서 가져오기 -->
			<input type="hidden" name="bnum" value="${dto.bnum }">
		</table>
		<br>
		<input type="submit" value="후기 등록">
		<input type="reset" value="작성 취소">
	</form>
</body>
</html>