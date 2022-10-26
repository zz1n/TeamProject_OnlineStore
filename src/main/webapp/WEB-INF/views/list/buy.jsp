<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{
  text-align: center;
}
#rm {
  float: right;
}
#lm {
  float: left;
}
#rm,#lm {
  display: inline-block;
}
#bm {
  padding-top: 300px;
}
a:hover, a:visited, a:focus {
  text-decoration: none !important;
  
}
</style>
<script type="text/javascript">

function radiobuy() {
	var f = document.form;
	var checkradio = document.getElementsByName('omethod');
	var type = null;
	
	for(var i=0;i<checkradio.length;i++)
		{
		  if(checkradio[i].checked == true)
			  {
			    type = checkradio[i].value;
			    
			  }
		}
	if(type == null)
		{
		  alert("결제방법을 선택하여 주세요.");
		  return false;
		}
	
	f.action = "buysave";
    f.method = "get";
    f.submit();

}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form">
<c:forEach items = "${list}" var = "aa">
 <input type="hidden" value="${aa.pcode }" name="pcode">
 <input type="hidden" value="${aa.scode }" name="scode">
 <input type="hidden" value="${aa.pname }" name="pname">
 <input type="hidden" value="${aa.price*bb+aa.pshipcost}" name="totcharge">
 <input type="hidden" value="${bb }" name="bb">
 <div class="buygoods">
 <div id="lm">
  <table  width="600">
   
    <tr>
     <th colspan="4"><h2>주문 상품</h2></th>
    </tr>
    <tr>
     <td rowspan="5"><img src="${pageContext.request.contextPath }/image/${aa.pthumbnail }" width="300" height="150"/></td>
    </tr>
    
    <tr>
     <td>${aa.pname }&nbsp;${bb }개</td>
    </tr>
    
    <tr>
     <td>${aa.price*bb }원</td>
    </tr>
  </table>
 </div>
  <div id="rm">
   <table  width="300" height="400">
     <tr>
      <th colspan="4"><h2>결제 금액</h2></th>
     </tr>
     
     <tr>
      <th>상품금액</th> 
      <td>${aa.price*bb }원</td>
     </tr>
     
     <tr>
      <th>배송비</th> 
      <td>${aa.pshipcost }원</td>
     </tr>
     
     <tr>
      <th>총 결제 금액</th> 
      <td>${aa.price*bb+aa.pshipcost}원</td>
     </tr>
     
     <tr>
      <td colspan="2"><input type="button" value="결제하기" onclick="radiobuy()"></td>
     </tr>
     
   </table>
  </div>
  <div id="bm">
   <table  width="600">
     <tr>
      <th colspan="4"><h2>결제 방법</h2></th>
     </tr>
     
     <tr>
      <td><input type="radio" value="무통장입금" name ="omethod" id ="mu">무통장입금 </td>
      <td><input type="radio" value="실시간계좌이체" name ="omethod" id ="sil">실시간계좌이체 </td>
      <td><input type="radio" value="신용카드" name ="omethod" id ="sin">신용카드 </td>
     </tr>  
   </table>
  </div>
 </div>
</c:forEach>
</form>
</body>
</html>