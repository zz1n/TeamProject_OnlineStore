<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

/*body {margin: 0;}*/
.menu {
float: right;
}

ul.vertical {

list-style-type: none;

margin: 0;

padding: 0;

width: 200px;

background-color: #fff;

/*position: fixed; 고정위치에 있게 합니다. */

/*height: 100%; 전체 높이를 사용하도록 합니다. */

overflow: auto; /* 사이드바 메뉴가 아주 많아져 스크롤이 필요하면 자동으로 생성되도록 합니다. */

}

li.vertical {border-bottom:2px solid #ccc;}

li.vertical:last-child {border-bottom: none;}

li.vertical a.vertical {

display: block;

color: black;

padding:  20px 10px 20px 10px;

text-decoration: none;

}

li.vertical a.active {

background-color: #fff;

color: white;

}

li.vertical a.vertical:hover:not(.active) {

background-color: #ccc;

color: black;

}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="menu">
  <ul class="vertical">

    <li class="vertical"><a class="vertical" href="/shop/user/UserUpdateView">개인 정보 수정</a></li>
    <li class="vertical"><a class="vertical" href="/shop/user/deleteView">회원 탈퇴</a></li>

    <li class="vertical"><a class="vertical" href="/shop/order/orderlist">주문 내역</a></li>

    <li class="vertical"><a class="vertical" href="/shop/check/usercart">장바구니</a></li>
    <li class="vertical"><a class="vertical" href="/shop/check/userlike">찜 목록</a></li>
    <li class="vertical"><a class="vertical" href="/shop/board/reviewlist?btype=2">내가 쓴 리뷰</a></li>
    <li class="vertical"><a class="vertical" href="/shop/board/usertosellerlist?btype=1">상품 문의 내역</a></li>
    <li class="vertical"><a class="vertical" href="/shop/board/usertositelist?btype=3">사이트 문의 내역</a></li>

    <li class="vertical"><a class="vertical" href="/shop/board/usertosite">사이트 문의</a></li>
  </ul>
</div>
</body>
</html>