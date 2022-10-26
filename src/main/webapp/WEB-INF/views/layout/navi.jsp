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
		list-style: none;
	}
/* a태그에 텍스트 밑줄을 없애고 색상을 #333 */
	a:hover, a:visited, a:focus {
        text-decoration: none !important;
        
    }
/* 글자크기를 16px 맑은 고딕 굵게하고 width넓이 700, 높이 50만큼 배경색은 #ccc, 글자색은 검정색, 라인높이50px
menu박스 가운데정렬, 글자가운데 정렬 */
	#menu {
		font:bold 16px "malgun gothic";
		height:60px;
		background: #ccc;
		color:black;
		line-height: 39px; 
		text-align: center;		
		position:sticky;
		padding-top: 10px;
		top: -5px;
        z-index:100;
	}
	#menu> ul > li:hover{
	    background: black;
	    color: #fff;
	}
	#menu> ul > li:hover > ul{
	    color: black;
	}
/* menu태그 자식의 ul의 자식 li를 왼쪽정렬과 넓이 140설정 */
	#menu > ul > li {
		float:left;
		width:140px;
		position:sticky;
		
	}
	#ma{
	    margin-left: 700px;
	    
	}
	
	#mma{
	    margin-left: 260px;
	    
	}
	
	#menu > ul > li > ul {
		width:140px;
		display:none;
		position:sticky;
		font-size:13px;
		background: #fff;
		border-style: solid;
        border-width: 1px;
	}
	#menu > ul > li:hover > ul {
		display:block;
	}
	#menu > ul > li > ul > li:hover {
		background: #DCDCDC;
		color: black;
		}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <div id="menu">
    <ul>
    <li id="ma">상품 카테고리
      <ul>
        <li><a href="/shop/list/listcate?listcate=육류">모든 육류</a></li>
        <li><a href="/shop/list/listcate?listcate=계육">닭고기</a></li>
        <li><a href="/shop/list/listcate?listcate=정육">정육</a></li>
        <li><a href="/shop/list/listcate?listcate=drink">드링크</a></li>
        <li><a href="/shop/list/listcate?listcate=rice">도시락, 볶음밥</a></li>
        <li><a href="/shop/list/listcate?listcate=채소">샐러드/야채</a></li>
      </ul>
    </li>
      <li id="mma">브랜드 카테고리
      <ul>
        <li><a href="/shop/list/brandcate?brandcate=S00004">석용정육</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00001">창용식품</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00003">철민라이스</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00002">민섭정육</a></li>
        <li><a href="/shop/list/brandcate?brandcate=S00005">효진샐러드</a></li>
      </ul>
    </li>     
  </div>



</body>
</html>