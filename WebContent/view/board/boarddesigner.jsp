<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:set var="menu_id"   value = "${ param.menu_id }" />
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="stylesheet" href="/designcss/bootstrap.min.css">
    <link rel="stylesheet" href="/designcss/templatemo.css">
    <link rel="stylesheet" href="/designcss/custom.css">
    <link rel="stylesheet" href="/designcss/fontawesome.min.css">
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
	
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">DESIGNER INFO</h1>
                <p>
                   GREEN BARBER SHOP 디자이너를 소개합니다.
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 p-5 mt-3">

            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="/view/survey/directhairreserve.jsp"><img src="/designcss/3.png" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">원장(이민홍)</h2>
                <p class="text-center"><a class="btn btn-success" href="/view/survey/directhairreserve.jsp">예약</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">

            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="/view/survey/directhairreserve.jsp"><img src="/designcss/4.png" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">부원장(윤성준)</h2>
                <p class="text-center"><a class="btn btn-success" href="/view/survey/directhairreserve.jsp">예약</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="/view/survey/directhairreserve.jsp"><img src="/designcss/1.png" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">디자이너(조재영)</h2>
                <p class="text-center"><a class="btn btn-success" href="/view/survey/directhairreserve.jsp">예약</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="/view/survey/directhairreserve.jsp"><img src="/designcss/2.png" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">디자이너(이상명)</h2>
                <p class="text-center"><a class="btn btn-success" href="/view/survey/directhairreserve.jsp">예약</a></p>
            </div>
        </div>
    </section>


    
   <jsp:include page="/include/javascripts.jsp" />


</body>
</html>