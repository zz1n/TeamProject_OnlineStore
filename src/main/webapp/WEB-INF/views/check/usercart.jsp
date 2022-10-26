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
		
		function del(){
			var f = document.form;
			alert("삭제?")
			f.action = "cartdel";
			f.method = "get";
			f.submit();
		}
		
		function buy(){
			var f = document.form;
			
			f.action = "buy";
			f.method = "get";
			f.submit();
		}
	</script>
</head>
<body>
<br> <br> <br>
<h3 style="text-align:center;">카트 </h3>
	<form name="form">
		<table  style="width: 800px" align="center">
			<tr>
				<th style="text-align: center;">전체 선택<input type="checkbox" id="cbx_chkAll" value="전체 선택"></th>
				<th>제품사진</th> <th>제품이름</th> <th>가격</th>
				<th>수량</th> <th>총합</th>
				
			</tr>
		<c:forEach var="li" items="${list }" varStatus="status">
			<tr>
				<td><input type="checkbox" name="chk" value="${list2[status.index].ccode }" ></td>
				<td><img src="${pageContext.request.contextPath }/image/${li.pthumbnail }" width="100" height="100"/></td> <td><a href="detail?pcode=${li.pcode }">${li.pname }</a></td>
				<td><fmt:formatNumber value="${li.price }" pattern="#,###,#00원"></fmt:formatNumber></td>
				<td>${list2[status.index].bcount }
				<input type="hidden" name="pcode" value="${li.pcode }">
				<input type="hidden" name="bb" value="${list2[status.index].bcount }"></td>
				<td><fmt:formatNumber value="${li.price*list2[status.index].bcount }" pattern="#,###,#00원"></fmt:formatNumber></td>
			</tr>
		</c:forEach>
			<tr>
				<td><input type="button" value="삭제" onclick="del()"> &emsp;
				<input type="button" value="구매" onclick="buy()"> </td>
			</tr>
		</table>
	</form>
	
</body>
</html>