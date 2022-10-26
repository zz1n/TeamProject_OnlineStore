<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
var f = document.form;
var pcount  = document.pcount;
var price = document.price;
var cost = document.cost;
var pshipday = document.pshipday;
var pshipcost = document.pshipcost;
var preshipcost = document.preshipcost;
var pspshipcost = document.pspshipcost;
var number = /^[0-9]*$/;
function checkform() {
	if(price.value == ""){
		alert("가격을 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!number.price.value){
		alert("숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	if(cost.value == ""){
		alert("가격을 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!number.cost.value){
		alert("숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	if(price.value == ""){
		alert("가격을 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!number.price.value){
		alert("숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	if(pcount.value == ""){
		alert("수량을 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!pcount.price.value){
		alert("숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	
	else if(pcount.value == 0){
		alert("수량은 1개이상을 입력하세요!");
		pcount.focus();
		return false;
	}
	
	if(pshipday.value == ""){
		alert("배송기간을 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!pshipday.price.value){
		alert("배송기간에 숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	
	if(pshipcost.value == ""){
		alert("배송비를 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!pshipcost.price.value){
		alert("배송비에 숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	
	if(preshipcost.value == ""){
		alert("반품배송비를 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!preshipcost.price.value){
		alert("반품배송비에 숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	
	if(pspshipcost.value == ""){
		alert("도서산간배송비를 입력해 주세요! ")
		price.focus();
		return false;
	}
	else if(!pspshipcost.price.value){
		alert("도서산간배송비에 숫자를 입력해 주세요!")
		price.focus();
		return false;
	}
	
	
	
	f.submit();
	
	

}





</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>