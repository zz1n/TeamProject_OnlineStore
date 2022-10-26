<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>주문 상세 내역</title>
</head>
<body>
<h3 style="text-align: center;">주문 상세 내역</h3>

	<table width="500px" align="center">
		<tr>
			<td rowspan="3"><img src="${pageContext.request.contextPath }/image/${lto.pthumbnail }" width="100" height="100"/></td>
			<td>${dto.ocode }</td>
			<td>${dto.odate }</td>
		</tr>
		<tr>
			<td>${lto.pname }</td>
			<td><a href="gotosellerstore?scode=${dto.scode }">판매자 스토어 보러 가기</a></td>
		</tr>
		<tr>
			<td>${dto.ocount } 개</td>
			<td><fmt:formatNumber value="${dto.ocharge }" pattern="#,###,#00원"></fmt:formatNumber></td>
		</tr>
		<tr>
			<td rowspan="5"></td>
			<c:choose>
				<c:when test="${dto.ostate==1 }">
					<td>주문상태 : 결제완료</td>
				</c:when>
				
				<c:when test="${dto.ostate==2 }">
					<td>주문상태 : 교환신청중</td>
				</c:when>
				
				<c:when test="${dto.ostate==3 }">
					<td>주문상태 : 반품신청중</td>
				</c:when>
				
				<c:when test="${dto.ostate==4 }">
					<td>주문상태 : 취소신청중</td>
				</c:when>
				
				<c:when test="${dto.ostate==5 }">
					<td>주문상태 : 구매확정</td>
				</c:when>
				
				<c:when test="${dto.ostate==6 }">
					<td>주문상태 : 취소완료  </td>
				</c:when>
				
				<c:otherwise>
					<td>주문상태 : 결제완료</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>배송주소 : ${dto.oaddress }</td>
		</tr>
		<tr>
			<td>배송메모 : ${dto.omemo }</td>
		</tr>
		<c:choose>
			<c:when test="${dto.oshipstate==1 }">
				<tr>
					<td>배송상태 : 배송 전</td>
				</tr>
				<tr>
					<td><a href="userorderchangeget?ocode=${dto.ocode }">배송정보수정</a></td>
					<td><a href="userordercancel?ocode=${dto.ocode }" onclick="javascript:alert('취소신청 하시겠습니까?');">취소신청</a></td>
					<td><a href="#">교환신청</a></td>
				</tr>
			</c:when>
			
			<c:when test="${dto.oshipstate==2 }">
				<tr>
					<td>배송상태 : 배송 중</td>
					<td>운송장 번호 : ${dto.oshipcode }</td>
				</tr>
				<tr>
					<td><a href="userorderrefund?ocode=${dto.ocode }" onclick="javascript:alert('환불신청 하시겠습니까?');">환불신청</a></td>
					<td><a href="#">교환신청</a></td>
					<td><a href="usertoseller?ocode=${dto.ocode }&btype=1">판매자 문의</a></td>
				</tr>
			</c:when>
			
			<c:when test="${dto.oshipstate==3 }">
				<tr>
					<td>배송상태 : 배송 완료</td>
					<td>운송장 번호 : ${dto.oshipcode }</td>
				</tr>
				<tr>
					<td><a href="userorderrefund?ocode=${dto.ocode }" onclick="javascript:alert('환불신청 하시겠습니까?');">환불신청</a></td>
					<td><a href="#">교환신청</a></td>
					<td><a href="userreviewwrite?ocode=${dto.ocode }">리뷰 작성</a></td>
					<td><a href="usertoseller?ocode=${dto.ocode }">판매자 문의</a></td>
				</tr>
			</c:when>
			
			<c:otherwise>
				<tr>
					<td>!배송 관려 정보가 없습니다. 판매자에게 문의하세요!</td>
				</tr>
				<tr>
					<td><a href="usertoseller?ocode=${dto.ocode }">판매자 문의</a></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>