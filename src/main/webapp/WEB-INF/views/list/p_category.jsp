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
</style>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<hr>
<table width = "800">
  <c:forEach items = "${list}" var = "aa">
    <tr>
      <td width="400"><a href="detail?pcode=${aa.pcode }">
      <img src="${pageContext.request.contextPath }/image/${aa.pthumbnail }" width="300" height="150"/>
      </a><hr></td>
      <td><a href="detail?pcode=${aa.pcode }">${aa.pname }</a><hr></td>
      <td>${aa.price }<hr></td>
    </tr>  
  </c:forEach>

</table>
</body>
</html>