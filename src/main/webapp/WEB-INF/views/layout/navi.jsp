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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">홈</a>
    </div>
    <ul class="nav navbar-nav">
    <li id="ma"><a href="#">상품 카테고리</a>
      <ul>
        <li><a href="/shop/list/listcate?listcate=chicken">닭고기</a></li>
        <li><a href="/shop/list/listcate?listcate=pork">돼지고기</a></li>
        <li><a href="/shop/list/listcate?listcate=beef">소고기</a></li>
        <li><a href="/shop/list/listcate?listcate=drink">드링크</a></li>
        <li><a href="/shop/list/listcate?listcate=rice">도시락, 볶음밥</a></li>
        <li><a href="/shop/list/listcate?listcate=salad">샐러드</a></li>
      </ul>
    </li>
      <li id="ma"><a href="#">브랜드 카테고리</a>
      <ul>
        <li><a href="/shop/list/brandcate?brandcate=S00004">석용정육</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00001">창용식품</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00003">효진샐러드</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00002">민서븜료</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00005">철민라이스</a></li>
      </ul>
    </li>
      <li id="ma"><a href="shop/list/ranking">랭킹</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">list <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/shop/prlist/main">상품등록</a></li>
          <li><a href="/shop/prlist/simplegoodslist">등록된 상품 확인</a></li>
          <li><a href="/shop/upload/form">이미지 저장소</a></li>
          <li><a href="/shop/prlist/reply">문의답변</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">seller <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">#</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">user <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/shop/user/main">main</a></li>
          <li><a href="/shop/order/orderlist?stnrd=0">orderlist</a></li>
          <li><a href="/shop/order/orderlist?stnrd=3">bfrorderlist</a></li>
          <li><hr></li>
          <li><a href="/shop/board/reviewlist?btype=2">review</a></li>
          <li><a href="/shop/check/usercheckcart">cart</a></li>
          <li><a href="/shop/check/userchecklike">like</a></li>
          <li><hr></li>
          <li><a href="/shop/board/usertosellerlist?btype=1">ask to seller list</a></li>
          <li><a href="/shop/board/usertosite">ask to site</a></li>
          <li><a href="/shop/board/usertositelist?btype=3">ask to site list</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>


</body>
</html>