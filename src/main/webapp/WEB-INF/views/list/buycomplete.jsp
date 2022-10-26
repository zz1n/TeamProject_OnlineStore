<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a:hover, a:visited, a:focus {
  text-decoration: none !important;
  
}

h1 {
  text-align: center;
}
table {
  margin: 0 auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주문 성공 !!</h1>
<c:forEach items = "${list}" var = "aa">
<table>
  <tr>
    <th>주문 상품</th>
    <td>${aa.pname }</td>
  </tr>
    
  <tr>
    <td><img src="${pageContext.request.contextPath }/image/${aa.pthumbnail }" width="300" height="150"/></td>
  </tr>
   
  <tr>
    <th>결제 방법</th>
    <td>${aa.omethod }</td>
  </tr>
   
  <tr>
    <th>배송지</th>
    <td>${aa.oaddress }</td>
  </tr>
  
  <tr>
    <th>배송 메모</th>
    <td>${aa.omemo }</td>
  </tr>
  
  <tr>
    <th>결제 금액</th>
    <td>${aa.price*bb+aa.pshipcost }원</td>
  </tr>
  
</table>
</c:forEach>
</body>
</html>