<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
placeholder {
  text-align: right;
}
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

<script type="text/javascript">
	function checkform() {

		var f = document.form;
		var number = /^[0-9]*$/;

		var cname = f.pname.value;
		if (cname == "") {
			alert("상품이름을 입력해주세요")
			f.pname.select();
			return false;
		}

		var crice = f.price.value;
		if (crice == "") {
			alert("상품가격을 입력해주세요")
			f.price.select();
			return false;
		}
		if (!number.test(crice)) {
			alert("숫자를 입력해 주세요!");
			f.price.select();
			return false;
		}

		var ccost = f.cost.value;
		if (ccost == "") {
			alert("상품원가를 입력해주세요")
			f.cost.select();
			return false;
		}
		if (!number.test(ccost)) {
			alert("숫자를 입력해 주세요!");
			f.cost.select();
			return false;
		}

		var ccount = f.pcount.value;
		if (ccount == "") {
			alert("상품수량을 입력해주세요")
			f.pcount.select();
			return false;
		}
		if (!number.test(ccount)) {
			alert("숫자를 입력해 주세요!");
			f.pcount.select();
			return false;
		}

		var cshipday = f.pshipday.value;
		if (cshipday == "") {
			alert("배송기간을 입력해주세요")
			f.pshipday.select();
			return false;
		}
		if (!number.test(cshipday)) {
			alert("숫자를 입력해 주세요!");
			f.pshipday.select();
			return false;
		}

		var cshipcost = f.pshipcost.value;
		if (cshipcost == "") {
			alert("배송비를 입력해주세요")
			f.pshipcost.select();
			return false;
		}
		if (!number.test(cshipcost)) {
			alert("숫자를 입력해 주세요!");
			f.pshipcost.select();
			return false;
		}

		var creshipcost = f.preshipcost.value;
		if (creshipcost == "") {
			alert("반품배송비를 입력해주세요")
			f.preshipcost.select();
			return false;
		}
		if (!number.test(creshipcost)) {
			alert("숫자를 입력해 주세요!");
			f.preshipcost.select();
			return false;
		}

		var cspshipcost = f.pspshipcost.value;
		if (cspshipcost == "") {
			alert("도서산간지역 배송비를 입력해주세요")
			f.pspshipcost.select();
			return false;
		}
		if (!number.test(cspshipcost)) {
			alert("숫자를 입력해 주세요!");
			f.pspshipcost.select();
			return false;
		}

		var cmaincate = f.pmaincate.value;
		if (cmaincate == 0) {
			alert("제품군을 선택해주세요")
			f.pmaincate.select();
			return false;
		}

		var csubcate = f.psubcate.value;
		if (csubcate == 0) {
			alert("소분류를 선택해주세요")
			f.psubcate.select();
			return false;
		}

		f.submit();
	}
	         
</script>

<script type="text/javascript">
	var detail = false;

	function update_selected() {
		$("#detailselect").val(0);
		$("#detailselect").find("option[value!=0]").detach();

		$("#detailselect").append(detail.filter("." + $(this).val()));
	}

	$(function() {
		detail = $("#detailselect").find("option[value!=0]");
		detail.detach();

		$("#productselect").change(update_selected);
		$("#productselect").trigger("change");
	});
</script>
<meta charset="UTF-8">
<title>판매자 상품등록 폼</title>
</head>


<body>

	<form action="inputsave" method="post" enctype="multipart/form-data"
		name="form">

		<table  width="1000">
			<tr>
				<th>제목</th>
				<th>내용</th>
			</tr>


			<tr>
				<td>상품명</td>
				<td><input type="text" name="pname" style="text-align: right;"></td>

			</tr>
			<tr>
				<td>판매가격</td>
				<td><input type="text" name="price" style="text-align: right;"></td>

			</tr>
			<tr>
				<td>원가격</td>
				<td><input type="text" name="cost" placeholder="원" style="text-align: right;"></td>

			</tr>
			<tr>
				<!-- 판매수량이 0이되면 오더 막히게 해야됨 -->
				<td>판매수량</td>
				<td><input type="text" name="pcount" placeholder="원" style="text-align: right;"></td>

			</tr>
			<tr>
				<td>배송기간</td>
				<td><input type="text" name="pshipday" style="text-align: right;"></td>

			</tr>
			<tr>
				<td>배송비</td>
				<td><input type="text" name="pshipcost" style="text-align: right;"></td>

			</tr>

			<tr>
				<td>반품배송비</td>
				<td><input type="text" name="preshipcost" style="text-align: right;"></td>

			</tr>

			<tr>
				<td>도서산간배송비</td>
				<td><input type="text" name="pspshipcost" style="text-align: right;"></td>

			</tr>

			<tr>
				<td>상품썸네일</td>
				<td><input type="file" name="pthumbnail" style="margin: 0 auto;"></td>
				<!-- 이미지 이름만 저장됨 이미지 업로드 폼에서 따로 이미지 넣어야함  -->
			</tr>

			<tr>
				<td>상품설명</td>
			<td><textarea id="summernote" name="pdscrpt" style="margin: 0 auto;"></textarea></td>

			</tr>

			<tr>
				<td><select id="productselect" name="pmaincate">
						<option value="0" selected="selected">제품군 선택</option>
						<option value="육류">육류</option>
						<option value="음료">음료</option>
						<option value="채소">채소</option>
						<option value="생선">생선</option>
				</select> <select id="detailselect" name="psubcate">
						<option value="0">소분류 선택</option>
						<option value="계육" class="육류">계육</option>
						<option value="정육" class="육류">정육</option>
						<option value="탄산음료" class="음료">탄산음료</option>
						<option value="이온음료" class="음료">이온음료</option>
						<option value="샐러드" class="채소">샐러드</option>
						<option value="생채소" class="채소">생채소</option>
						<option value="흰살생선" class="생선">흰살생선</option>
						<option value="붉은살생선" class="생선">붉은살생선</option>
				</select></td>
			</tr>


			<tr>
				<td>태그</td>
				<td><input type="text" name="ptag" style="margin-right:  59px;"></td>

			</tr>


			<tr>
				<td colspan="2"><input type="button" value="상품등록"
					onclick="checkform()"></td>
			</tr>

		</table>


	</form>

</body>
</html>