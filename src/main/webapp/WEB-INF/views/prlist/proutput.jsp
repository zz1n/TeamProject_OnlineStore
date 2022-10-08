<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align: center;">간단 상품 목록</h2>
<table border="1" width="600px" align="center">
<tr> <th>상품번호</th><th>상품명</th><th>상품가격</th><th>등록일</th><th>수정 / 삭제</th>
</tr>
<c:forEach items="${list}" var="s">
<tr>
<td>${s.pcode}</td>
<td>
<a href="detail?pcode=${s.pcode}">
${s.pname}
</a>
</td>
<td>${s.price}</td>
<td>${s.prgtdate}</td>
<td>
<a href="update?pcode=${s.pcode}">수정 </a>
<a href="delete?pcode=${s.pcode}">삭제 </a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>