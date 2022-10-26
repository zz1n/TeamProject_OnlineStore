<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript">
/*
function order() {
	var f = document.form;
	
	let signIn = "${signIn}";
	if (signIn == "")
		{
		  location.href="${cpata}/shop/user/login";
		  alert("로그인 후 이용 가능합니다.");
		}
	else
		{
		location.href="${cpata}/shop/order/orderlist";
		
		}
	
}
*/
</script>
<style type="text/css">
a:hover, a:visited, a:focus {
text-decoration: none !important;
}
html, body{
width: 100%;
height: 100%;
margin: 0;
padding: 0;
}
header {
display: inline-block;
}

.container {
width: 100%;
height: 100%;
/* header에 주지말고 그 안의 요소에 padding을 준다. */
padding: 20px 0;
}
.logo {
float: left;
margin-right: 10px;
margin-top: 10px;
}
.login{
float: right;
margin-left: 10px;
}

.header-search{
height: 50px;
width: 400px;
border: 1px solid #000000;
background: #ffffff;
margin: 0 auto;
}

#rankKeyword{
font-size: 16px;
width: 325px;
padding: 10px;
border: 0px;
outline: none;
float: left;
}
.btn btn-default{
width: 50px;
height: 100%;
border: none;
background: #ffffff;
outline: none;
float: right;
color: #000000;
margin: 0 auto;
}
</style>
</head>
<body>
<form action="search" method="get"> 
  <div class="header">
    <div id="container">
      <div class="container-left clearfix">
        <div class="logo">
         <a href="/shop/sellerOrder/sellermain?scode=${scode }"><h1>DieTy</h1>판매자용</a>
        </div>
          <div class="login">
            <c:choose>
              <c:when test="${loginstate==true }">
                <a href=""> ${member }</a>&nbsp;|
                <a href="/shop/seller/sellerup?scode=${scode }">회원정보수정</a>&nbsp;|
                <a href="/shop/list/logout"> 로그아웃</a>&nbsp;               
              </c:when>
            </c:choose>
            
          </div>
	    <!--<div class="header-search" id="search">	  
	          <input type="text" id="rankKeyword"
	        placeholder="검색어를 입력해주세요" name="svalue">
		  <button type="submit" class="btn btn-default">
            <span class="glyphicon glyphicon-search"></span>
          </button>
		</div>-->
	  </div>	  
    </div>
  </div>
</form>
</body>
</html>