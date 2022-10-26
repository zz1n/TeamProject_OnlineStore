<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
<style type="text/css">
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
th{border-bottom:1px solid black !important;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>