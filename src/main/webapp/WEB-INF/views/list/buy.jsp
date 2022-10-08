<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#rm {
float: right;
}
#bm {
float: left;
margin-bottom: 100px;
}
a {
  color: inherit;
  text-decoration: none;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="buysave" method="get">
<c:forEach items = "${list}" var = "aa">
 <div class="buygoods">
 <div class="col-md-4">
 <input type="hidden" value="${aa.pcode }" name="pcode">
 <input type="hidden" value="${aa.scode }" name="scode">
 <input type="hidden" value="${aa.pname }" name="pname">
 <input type="hidden" value="${bb }" name="bb">
  <table border="1" width="600" id="lm">
   
    <tr>
     <th colspan="4"><h2>주문 상품</h2></th>
    </tr>
    
    <tr>
     <td rowspan="5"><img src="${pageContext.request.contextPath }/image/${aa.pthumbnail }" width="300" height="150"/></td>
    </tr>
    
    <tr>
     <td>${aa.pname }</td>
    </tr>
    
    <tr>
     <td>${aa.price*bb }원</td>
    </tr>

  </table>
 </div>
  <div class="col-md-4" id="rm">
   <table border="1" width="300" height="400">
     <tr>
      <th colspan="4"><h2>결제 금액</h2></th>
     </tr>
     
     <tr>
      <th>상품금액</th> 
      <td>${aa.price*bb }원</td>
     </tr>
     
     <tr>
      <th>배송비</th> 
      <td>${aa.pshipcost }원</td>
     </tr>
     
     <tr>
      <th>총 결제 금액</th> 
      <td>${aa.price*bb+aa.pshipcost}원</td>
     </tr>
     
     <tr>
      <td colspan="2"><input type="submit" value="결제하기"></td>
     </tr>
     
   </table>
  </div>
  <div class="col-md-4" id="bm">
   <table border="1" width="600">
     <tr>
      <th colspan="4"><h2>결제 방법</h2></th>
     </tr>
     
     <tr>
      <td><input type="checkbox" value="무통장입금" name ="omethod">무통장입금 </td>
      <td><input type="checkbox" value="실시간계좌이체" name ="omethod">실시간계좌이체 </td>
      <td><input type="checkbox" value="신용카드" name ="omethod">신용카드 </td>
     </tr>   
   </table>
  </div>
 </div>
</c:forEach>
</form>
</body>
</html>