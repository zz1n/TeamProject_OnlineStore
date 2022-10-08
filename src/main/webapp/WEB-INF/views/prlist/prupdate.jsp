<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="update2" method="post" enctype="multipart/form-data">

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

<c:forEach items="${update}" var="up">

<input type="hidden" name="pcode" value="${up.pcode}"  ><br><!-- 상품코드 숨김 -->
상품명 : <input type="text" name="pname" value="${up.pname}"  ><br>
가격 : <input type="text" name="price" value="${up.price}"  ><br>
등록가격 : <input type="text" name="cost" value="${up.cost}"  ><br>
판매가능수량 : <input type="text" name="pcount" value="${up.pcount}"  ><br>
배송기간 : <input type="text" name="pshipday" value="${up.pshipday}"  ><br>
배송비 : <input type="text" name="pshipcost" value="${up.pshipcost}"  ><br>
반품배송비 : <input type="text" name="preshipcost" value="${up.preshipcost}"  ><br>
도서산간배송비 : <input type="text" name="pspshipcost" value="${up.pspshipcost}"  ><br>
상품썸네일 : <input type="file" name="pthumbnail" value="${up.pthumbnail}"  ><br>
상품설명 : <input type="text" name="pdscrpt" value="${up.pdscrpt}"  ><br>
태그 : <input type="text" name="ptag" value="${up.ptag}"  ><br>
상품등록일 : <input type="text" name="prgtdate" value="${up.prgtdate}" readonly >자동으로 수정일이 기입됩니다.<br>
 <input type="submit" value="전송"><br>
</c:forEach>

</form>

</body>
</html>