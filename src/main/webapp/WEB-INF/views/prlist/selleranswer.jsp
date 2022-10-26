<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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

<title>판매자 답변</title>
</head>
<body>
<h3 style="text-align: center;">판매자 답변</h3>
   <form action="answercomplete" method="post">
      <table style="width: 500px">
         <tr>
          
            <td>상품코드</td>
            <td>${pcode}</td>
         </tr>
         <tr>
            <td>제목</td>
            <td><input type="text" name="bname"></td>
         </tr>
         <tr>
            <td>내용</td>
            <td><textarea id="summernote" name="bcont"></textarea></td>
         </tr>
         <input type="hidden" name="pcode" value="${pcode}">
         <input type="hidden" name="bnum" value="${bnum}">
      </table>
      <br>
      <input type="submit" value="답변 완료">
      <input type="reset" value="작성 취소">
   </form>
</body>
</html>