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
<title>배송 관리</title>
</head>
<!-- 배송준비에서 송장입력,배송중처리 -->
<body>
	<form name="form1" action="sellerorder1" method="get">
		<input type="hidden" name="scode" value="${scode }">
		<table  width="1000">
			<tr>
				<th>검색어&emsp;<select name="serchcolumn" id="serchcolumn">
						<option value="ocode">주문번호</option>
						<option value="uname">회원명</option>
						<option value="umobile">회원연락처</option>
						<option value="oshipcode">송장번호</option>
				</select></th>
				<td><input type="text" name="serchname" id="serchname" style="margin-right: 72px;"></td>
			</tr>
			<tr>
				<th>주문기간</th>
				<td colspan="2"><input type="date" name="orderday1"
					id="orderday1">~<input type="date" name="orderday2"
					id="orderday2"><input type="submit" value="검색"><input type="reset" value="초기화"></td>
			</tr>

		</table>
	</form>
	<form id="oderOut" action="oshipsave" method="get">
		<table  width="1000">
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
				<th>배송상태</th>
				<th>택배사</th>
				<th>송장번호</th>
			</tr>
			<c:forEach var="i" items="${list}" >
				<c:choose>
					<c:when test="${i.ostate ==1}">
						<c:set var="state" value="결제완료" />
					</c:when>
					<c:when test="${i.ostate ==2}">
						<c:set var="state" value="교환신청" />
					</c:when>
					<c:when test="${i.ostate ==3}">
						<c:set var="state" value="반품신청" />
					</c:when>
					<c:when test="${i.ostate ==4}">
						<c:set var="state" value="취소신청" />
					</c:when>
					<c:when test="${i.ostate ==6}">
						<c:set var="state" value="취소완료" />
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
						<c:set var="oship" value="널!!!!!!"/>
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
					<c:out value="${state }" /></td>
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
				</tr>
			</c:forEach>
			<tr align="right">
				<td colspan="2"><input type="submit" value="송장번호 저장">
					<input type="hidden" name="scode" value="${scode }">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>