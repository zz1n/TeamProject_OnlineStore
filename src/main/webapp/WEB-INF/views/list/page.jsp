<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
  color: inherit;
  text-decoration: none;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width = "800">
  <tr>
    <th>제목</th><th>작성일자</th><th>내용</th>
  </tr>
  <c:forEach items = "${view }" var = "dd">
    <tr>
    <c:forEach items = "${list1 }" var = "bb">
      <td>${bb.bname }</td>
      <td>
        <c:forEach begin="1" end="${dd.repindent }">&emsp;</c:forEach>
        ${bb.bdate }
      </td>
      <td>${bb.bcont }</td>
    </c:forEach>
    </tr>
  </c:forEach>
    <tr>
      <td colspan="5">
      <c:if test="${paging.startpage != 1 }">
        <a href="page?nowpage=${paging.startpage - 1 }
        &cntperpage=${paging.cntperpage }">&lt;</a>
      </c:if>
      <c:forEach begin="${paging.startpage }" end="${paging.endpage }" var="p">
        <c:choose>
          <c:when test="${p == paging.nowpage }">
            <b>${p }</b>
          </c:when>
          <c:when test="${p != paging.nowpage }">
            <a href="page?nowpage=${p }
            &cntperpage=${paging.cntperpage }">${p }</a>
          </c:when>
        </c:choose>
      </c:forEach>
      <c:if test="${paging.endpage != paging.lastpage }">
        <a href="page?nowpage=${paging.endpage+1 }
        &cntperpage=${paging.cntperpage }">&gt;</a>
      </c:if>
    </tr>
</table>
</body>
</html>