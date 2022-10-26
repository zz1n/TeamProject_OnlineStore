<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
    
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/layout/CSS.jsp" %>
</head>
<body>

<div class="header">
	<tiles:insertAttribute name="header"/>
</div>

<div class="topnav">
	<tiles:insertAttribute name="navi"/>
</div>

<div class="row">
    <div class="card">
		<tiles:insertAttribute name="body"/>
    </div>
</div>

<div class="footer">
	<tiles:insertAttribute name="footer"/>
</div>

</body>
</html>
