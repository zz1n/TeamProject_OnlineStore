<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a:hover, a:visited, a:focus {
text-decoration: none !important;

}
.col-md-4 {
  padding-top: 100px;
}
</style>
<meta charset="utf-8">

<title>Insert title here</title>
</head>
<body>
  <hr>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${pageContext.request.contextPath }/image/banner.PNG" alt="1" style="width:100%; height:400px;">
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath }/image/banner.PNG" alt="2" style="width:100%; height:400px;">
      </div>
    
      <div class="item">
        <img src="${pageContext.request.contextPath }/image/banner.PNG" alt="3" style="width:100%; height:400px;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" class="text-decoration-none" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
 
 <c:forEach items="${list }" var="aa">
 <div class="game-container">
  <div class="grid-container">
   <div class="col-md-4">
    <span>
     <a class="text-decoration-none" href="detail?pcode=${aa.pcode }">
      <p>
       <img src="${pageContext.request.contextPath }/image/${aa.pthumbnail }" width="250" height="250"/>
      </p>
     <div class="caption">
      <p><h3>${aa.pname }</h3></p>
      <p><h3>${aa.price }</h3></p>
     </div>
     </a>
    </span>
   </div>
  </div>
 </div>
</c:forEach>
</body>
</html>
