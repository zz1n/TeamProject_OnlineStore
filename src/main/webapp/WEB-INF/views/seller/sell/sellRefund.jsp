<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cbx_chkAll").click(function() {
			if ($("#cbx_chkAll").is(":checked"))
				$("input[name=chk]").prop("checked", true);
			else
				$("input[name=chk]").prop("checked", false);
		});

		$("input[name=chk]").click(function() {
			var total = $("input[name=chk]").length;
			var checked = $("input[name=chk]:checked").length;

			if (total != checked)
				$("#cbx_chkAll").prop("checked", false);
			else
				$("#cbx_chkAll").prop("checked", true);
		});
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form1" action="sellrefund1" method="get">
		<input type="hidden" name="scode" id="scode" value="${scode }">
		<table>
			<tr>
				<th>검색어</th>
				<td><select name="serchcolumn" id="serchcolumn">
						<option value="ocode">주문번호</option>
						<option value="uname">회원명</option>
						<option value="umobile">회원연락처</option>
						<option value="oshipcode">송장번호</option>
				</select></td>
				<td><input type="text" name="serchname" id="serchname"></td>
				<th>주문상태</th>
				<td><select name="ostate">
						<option value="1">결제완료</option>
						<option value="2">교환신청</option>
						<option value="3">반품신청</option>
						<option value="4">취소신청</option>
						<option value="5">취소완료</option>
				</select>
			</tr>
			<tr>
				<th>주문기간</th>
				<td colspan="2"><input type="date" name="orderday1"
					id="orderday1">~<input type="date" name="orderday2"
					id="orderday2"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="검색">
					<input type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
	<form>
		<h3>검색 결과</h3>
		<table>
			<tr>
				<th><input type="checkbox" id="cbx_chkAll" value="전체 선택"></th>
				<th>상품 주문번호</th>
				<th>회원명</th>
				<th>회원코드</th>
				<th>회원 연락처</th>
				<th>제품명</th>
				<th>수량</th>
				<th>구매금액</th>
				<th>배송지</th>
				<th>구매일</th>
				<th>주문상태</th>
				<th>택배사</th>
				<th>송장번호</th>
				<th>택배비부담</th>
				<th>택배비</th>
			</tr>
		</table>
	</form>
</body>
</html>