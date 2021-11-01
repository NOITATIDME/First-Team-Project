<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%-- include head.jsp--%>
<jsp:include page= "/include/head.jsp"/>

</head>
<body>
 <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">

        <a class="navbar-brand" href="/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10">
          <i class="material-icons">content_cut</i>
          HAIR
        </a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <c:if test="${ loginid == null }">
            <li class="nav-item">
              <a class="nav-link" href="/member/join.jsp">회원가입</a>
            </li>
            </c:if>
            <c:if test="${ loginid == null }">
            <li class="nav-item">
              <a class="nav-link" href="/member/login.jsp">로그인</a>
            </li>
            </c:if>
            <li class="nav-item">
              <a class="nav-link active" onclick="alert('기능 미구현');return false;">내 정보</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="/view/board/boardlistgreen.jsp">그린 바버샵</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="/view/board/boarddesigner.jsp">디자이너 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/member?cmd=LOGOUT">로그아웃</a>
            </li>


          </ul>
        </div>
      </div>
    </nav>
    <!-- end of Navbar -->
</body>
</html>