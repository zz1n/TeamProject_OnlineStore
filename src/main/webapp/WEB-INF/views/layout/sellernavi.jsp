<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/* 전체영역에서 여백을 없애줌 */
	* {
		margin: 0;
		padding: 0;
	}
/* ul li태그에 리스트 스타일을 없앰 */
	ul li{
		list-style: none !important;
	}
/* a태그에 텍스트 밑줄을 없애고 색상을 #333 */
	a:hover, a:visited, a:focus {
        text-decoration: none !important;
        
    }
/* 글자크기를 16px 맑은 고딕 굵게하고 width넓이 700, 높이 50만큼 배경색은 #ccc, 글자색은 검정색, 라인높이50px
menu박스 가운데정렬, 글자가운데 정렬 */
	#menu {
		font:bold 16px "malgun gothic" !important;
		height:60px !important;
		background: #ccc !important;
		color:black !important;
		line-height: 39px !important; 
		text-align: center !important;		
		position:sticky !important;
		padding-top: 10px !important;
		top: -5px !important;
        z-index:100 !important;
	}
	#menu> ul > li:hover{
	    background: black !important;
	    color: #fff !important;
	}
	#menu> ul > li:hover > ul{
	    color: black !important;
	}
/* menu태그 자식의 ul의 자식 li를 왼쪽정렬과 넓이 140설정 */
	#menu > ul > li {
		float:left !important;
		width:140px !important;
		position:sticky !important;
		
	}
	#ma{
	    margin-left: 200px;
	}
	#menu > ul > li > ul {
		width:140px !important;
		display:none !important;
		position:sticky !important;
		font-size:13px !important;
		background: #fff !important;
		border-style: solid !important;
        border-width: 1px !important;
	}
	#menu > ul > li:hover > ul {
		display:block !important;
	}
	#menu > ul > li > ul > li:hover {
		background: #DCDCDC !important;
		color: black !important;
		}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <div id="menu">
    <ul id="ma">
      <li><a href="/shop/sellerOrder/sellerorder?scode=${scode }">주문 관리</a></li>
      <li><a href="/shop/sellerOrder/sellRefund?scode=${scode }">환불/교환 조회</a></li>
      <li><a href="/shop/profit/profitmain?scode=${scode }">매출 조회</a></li>
      <li><a href="/shop/prlist/main">상품 등록</a></li>
      <li><a href="/shop/prlist/simplegoodslist">등록상품 확인</a></li>
      <li><a href="/shop/upload/form">이미지 저장소</a></li>
      <li><a href="/shop/prlist/preply">문의 답변</a></li>
      
    </ul>
  </div>


</body>
</html>