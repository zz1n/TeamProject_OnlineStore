<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
  margin: 0 auto;
}
</style>
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
						<option value="6">취소완료</option>
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
	<form action="refundsave" method="get">
	<input type="hidden" name="scode" id="scode" value="${scode }">
		<h3>검색 결과</h3>
		<table >
		<tr>
			<th><input type="submit" value="입력">
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
				<th>주문상태 변경</th>
				<th>배송상태 변경</th>
				<th>택배사</th>
				<th>교환 송장번호 입력</th>
				<th>택배비부담</th>
				<th>택배비</th>
			</tr>
			<c:forEach var="i" items="${list}" >
			<c:choose>
				<c:when test="${i.ostate ==1}">
					<c:set var="state" value="결제완료"/>
				</c:when>
				<c:when test="${i.ostate ==2}">
					<c:set var="state" value="교환신청"/>
				</c:when>
				<c:when test="${i.ostate ==3}">
					<c:set var="state" value="반품신청"/>
				</c:when>
				<c:when test="${i.ostate ==4}">
					<c:set var="state" value="취소신청"/>
				</c:when>
				<c:when test="${i.ostate ==6}">
					<c:set var="state" value="취소완료"/>
				</c:when>
			</c:choose>
			<c:choose>
					<c:when test="${i.oshipstate == 1 }">
						<c:set var="oship" value="배송전"/>
					</c:when>
					<c:when test="${i.oshipstate == 2 }">
						<c:set var="oship" value="배송시작"/>
					</c:when>
					<c:when test="${i.oshipstate == 3 }">
						<c:set var="oship" value="배송완료"/>
					</c:when>
					<c:when test="${i.oshipstate eq null}">
						<c:set var="oship" value="오류"/>
					</c:when>
				</c:choose>
				<tr>
					<td><input type="checkbox" name="chk" value="${i}"></td>
					<td><input type="text" name="ocode" value="${i.ocode }"
						readonly></td>
					<td>${i.uname }</td>
					<td>${i.ucode }</td>
					<td>${i.umobile }</td>
					<td>${i.pname }</td>
					<td>${i.ocount }</td>
					<td>${i.ocharge }</td>
					<td>${i.oaddress }</td>
					<td>${i.odate }</td>
					<td>
					<select name="ostate">
					<option value="${i.ostate }"><c:out value="${state }"/></option>
					<option value="1">결제완료</option>
					<option value="2">교환신청</option>
					<option value="3">반품신청</option>
					<option value="4">취소신청</option>
					<option value="5">취소완료</option>
					</select></td>
					<td><select name="oshipstate">
						<option value="${i.oshipstate }"><c:out value="${oship }"/></option>
						<option value="1">배송전</option>
						<option value="2">배송시작</option>
						<option value="3">배송완료</option>
					</select></td>
					<td><input type="text" name="oshipcomp"
						value="${i.oshipcomp }"></td>
					<td><input type="text" name="oshipcode"
						value="${i.oshipcode }"></td>
					<td><select name="pshipcost">
							<option value="ocharge-">판매자부담</option>
							<option value="ocharge+">고객부담</option>
					</select></td>
					<td><input type="text" name="shipprice">
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>