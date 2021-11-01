<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:set var="menu_id"   value = "${ param.menu_id }" />
    
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="/css/green.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Azeret+Mono:wght@900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Azeret+Mono:wght@900&family=East+Sea+Dokdo&display=swap');

	#in {
		font-family: 'Azeret Mono', monospace;
		font-size: 60px;
		margin-right:250px; 
	}

	#in2 {
		font-family: 'Azeret Mono', monospace;
		font-family: 'East Sea Dokdo', cursive;
		font-size: 30px;
		margin-right:250px; 
		
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	
</script>
   <%--  include head.jsp --%>
   <jsp:include page="/include/head.jsp" />
</head>
<body>
<%--  include topNavbar.jsp --%>
   <jsp:include page="/include/topNavbar.jsp" />

    <div class="container mt-4">
     
    </div>
	<a id="in">
	FOR MAN
	</a>
	<a id="in2">
	고민하지말고 헤어 추천 받고 원하는 스타일로 바꿔드립니다.
	</a>
	
	<div class="grin">
	
    		<input type="hidden" name="menu_id" value="MENU01" />
    		<input type="hidden" name="nowpage" value="1" />
    		<input type="hidden" name="pagecount" value="10" />
	</div>

    
   <jsp:include page="/include/javascripts.jsp" />


</body>
</html>