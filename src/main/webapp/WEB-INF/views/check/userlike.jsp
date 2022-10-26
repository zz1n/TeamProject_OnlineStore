<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  margin: 0 auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#cbx_chkAll").click(function() {
				if($("#cbx_chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
				else $("input[name=chk]").prop("checked", false);
			});
			
			$("input[name=chk]").click(function() {
				var total = $("input[name=chk]").length;
				var checked = $("input[name=chk]:checked").length;
				
				if(total != checked) $("#cbx_chkAll").prop("checked", false);
				else $("#cbx_chkAll").prop("checked", true); 
			});
		});
	</script>
</head>
<body>
<h3 style="text-align:center;">좋아요</h3>
	<form action="likedel" method="post">
		<table  style="width: 500px" align="center">
			<tr>
				<th style="text-align: center;">전체 선택<input type="checkbox" id="cbx_chkAll" value="전체 선택"></th>
				<th>제품사진</th> <th>제품이름</th> <th>가격</th>
				
			</tr>
		<c:forEach var="li" items="${list }" varStatus="status">
			<tr>
				<td><input type="checkbox" name="chk" value="${list2[status.index].ccode }" ></td>
				<td><img src="${pageContext.request.contextPath }/image/${li.pthumbnail }" width="100" height="100"/></td> <td><a href="detail?pcode=${li.pcode }">${li.pname }</a></td>
				<td><fmt:formatNumber value="${li.price }" pattern="#,###,#00원"></fmt:formatNumber></td>
			</tr>
		</c:forEach>
			<tr>
				<td><input type="submit" value="삭제"> </td>
			</tr>
		</table>
	</form>
</body>
</html>