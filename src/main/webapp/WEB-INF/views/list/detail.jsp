<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{
  margin-left:auto; 
  margin-right:auto;
}
#td{
  text-align: right;
}

#img{
  text-align: left;
}
tr{
  text-align: right;
}
a:hover, a:visited, a:focus {
  text-decoration: none !important;
}
</style>
<script type="text/javascript">

function buy() {
	var f = document.form;
	
	let signIn = "${signIn}";
	if (signIn == "")
		{
		  location.href="${cpata}/shop/user/login";
		  alert("로그인 후 이용 가능합니다.");
		}
	else
		{
		location.href="${cpata}/shop/list/buy";
		f.submit();
		}
	
}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="buy" method="get" name="form">
<c:forEach items="${list }" var="aa">
<input type = "hidden" name = "pcode" value = "${aa.pcode }">
<table width = "800" height = "1000">
 
    <tr>
      <td rowspan="5" width = "500" id="img"><img src="${pageContext.request.contextPath }/image/${aa.pthumbnail }" width="500" height="700"/>
      </td><td><h3>${aa.pname }</h3></td>
    </tr>
    
    <tr>
      <td><h3>${aa.price }원</h3></td>
    </tr>
    
    <tr>
      <td><h3>배송기간 약${aa.pshipday }일</h3></td>
    </tr>
    
    <tr>
      <td><h3>배송비 ${aa.pshipcost }원  도서산간지역 ${aa.pspshipcost }원</h3></td>
    </tr>  
    
    <tr>
      <td>
       <h4>
        <select id="testSelect" name = "bb">
           <option value="10">10팩 ${aa.price*10 }원</option>
           <option value="30">30팩 ${aa.price*30 }원</option>
           <option value="50">50팩 ${aa.price*50 }원</option>
           <option value="100">100팩 ${aa.price*100 }원</option>
        </select>
       </h4>
      </td>
    </tr> 
     
    <tr>
      <td colspan="2" id="td"><a href="gotocart?pcode=${aa.pcode }"><h3>장바구니</h3></a><a href="gotolike?pcode=${aa.pcode }"><h3>찜하기</h3></a><h2><input type="button" value="바로구매" onclick="buy()"></h2></td>
    </tr>    
</table>
</c:forEach> 
<table  width = "400">
<caption><h2>후기글</h4></caption>
 <tr>
  <th>제목</th><th>내용</th><th>작성일자</th>
 </tr>
 
<c:forEach items="${list1 }" var="bb">
 <tr>
  <td>${bb.bname }</td>
  <td>${bb.bcont }</td>
  <td>${bb.bdate }</td>




 </tr>
</c:forEach>

</table>

<table  width = "400">
<caption><h2>문의글</h2></caption>
 <tr>
  <th>제목</th><th>내용</th><th>작성일자</th>
 </tr>
 
<c:forEach items="${list2 }" var="cc">
 <tr>
  <td>${cc.bname }</td>  
  <td>${cc.bcont }</td>
  <td>${cc.bdate }</td>
 </tr>
</c:forEach>

</table>
</form>
</body>
</html>