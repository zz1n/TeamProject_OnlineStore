<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

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

    <form action="inputsave" method="post" enctype="multipart/form-data">

<table align="center">
<tr>
<th>제목</th><th>내용</th>
</tr>


<tr>
<td>상품명</td><td><input type="text" name="pname"></td>

</tr>
<tr>
<td>판매가격</td><td><input type="text" name="price">원</td>

</tr>
<tr>
<td>원가격</td><td><input type="text" name="cost">원</td>

</tr>
<tr>
<!-- 판매수량이 0이되면 오더 막히게 해야됨 -->
<td>판매수량</td><td><input type="text" name="pcount">개</td>

</tr>
<tr>
<td>배송기간</td><td><input type="text" name="pshipday"></td>

</tr>
<tr>
<td>배송비</td><td><input type="text" name="pshipcost"></td>

</tr>

<tr>
<td>반품배송비</td><td><input type="text" name="preshipcost"></td>

</tr>

<tr>
<td>도서산간배송비</td><td><input type="text" name="pspshipcost"></td>

</tr>

<tr>
<td>상품썸네일</td><td><input type="file" name="pthumbnail"></td>
<!-- 이미지 이름만 저장됨 이미지 업로드 폼에서 따로 이미지 넣어야함  -->
</tr>

<tr>
<td>상품설명</td><td><textarea cols="300" row="300" name="pdscrpt"></textarea></td>

</tr>

<tr>
<td>
<select id="productselect" name="pmaincate">
   <option value="0" selected="selected">제품군 선택</option>
   <option value="육류">육류</option>
   <option value="음료">음료</option>
   <option value="채소">채소</option>
</select>


<select id="detailselect" name="psubcate">
   <option value="0">소분류 선택</option>
   <option value="계육" class="육류">계육</option>
   <option value="정육" class="육류">정육</option>
   <option value="탄산음료" class="음료">탄산음료</option>
   <option value="이온음료" class="음료">이온음료</option>
   <option value="토마토" class="채소">토마토</option>
   <option value="상추" class="채소">상추</option>
</select>
</td>
</tr>


<tr>
<td>태그</td><td><input type="text" name="ptag"></td>

</tr>


  <tr><td colspan="2" align="center">
   	<input type="submit" value="상품등록">
   
   </td></tr>

</table>


</form>

</body>
</html>