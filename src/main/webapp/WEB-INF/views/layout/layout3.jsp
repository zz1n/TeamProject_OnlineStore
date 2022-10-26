<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@include file="CSS.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
div{
	font-family: 'Noto Sans KR', sans-serif !important;
}
a:hover, a:visited, a:focus {
  text-decoration: none !important;
  
}
html, body{
  width: 100vw !important;
  height: 100vh !important;
}
.container{
  margin: 0 auto !important;
  width: 100vw !important;
  height: 100vh !important;
  display: grid !important;
  grid-template-columns: 1fr 4fr 1fr !important;
  grid-template-rows:200px 100px auto 200px !important;
  grid-template-areas:
                      "lheader header rheader"
                      "topnav topnav topnav"
                      "lside main rside"
                      "footer footer footer" !important;
}
.lheader{
  grid-area: lheader !important;
}
.header{
  grid-area: header !important;
}
.rheader{
  grid-area: rheader !important;
}
.topnav{
  grid-area: topnav !important;
  position:-webkit-sticky !important;
  position:sticky !important; 
  top: -5px !important;
  z-index:100 !important;
}
.lside{
  grid-area: lside !important;
}
.main{
  grid-area: main !important;
}
.rside{
  grid-area: rside !important;
}
.footer {  
  grid-area: footer !important;
  background: #ccc !important;
}
.carousel-inner{
  border-style: solid !important;
  border-width: 1px !important;
}
</style>
<meta charset="UTF-8">
</head>
<body>

<div class="container">   
  <div class="lheader">
  
  </div> 
  
  <div class="header">
    <tiles:insertAttribute name="header"/>
  </div> 
     
  <div class="rheader">
  
  </div>
  
  <div class="topnav">
    <tiles:insertAttribute name="navi"/>
  </div>  

  <div class="lside">
    <tiles:insertAttribute name="sidenavi"/>
  </div> 
  
    
  <div class="main">
    <tiles:insertAttribute name="body"/>
  </div>    
  
  <div class="rside">
  
  </div> 
        
  
  <div class="footer">
    <tiles:insertAttribute name="footer"/>
  </div>
</div>
</body>
</html>
