<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="ko">
<head>
   <%--  include head.jsp --%>
   <jsp:include page="/include/head.jsp" />
</head>
<body>
<%--  include topNavbar.jsp --%>
   <jsp:include page="/include/topNavbar.jsp" />

    <!-- middle container -->
    <div class="container mt-4">
      <div class="row">

        <!-- Left Menu -->
        <div class="col-sm-3">

          <!-- Vertical Nav -->
          <ul class="nav flex-column nav-pills">
            <li class="nav-item">
              <a class="nav-link active" href="/board?cmd=LIST&menu_id=${ param.menu_id}&nowpage=${ param.nowpage }&pagecount=${ param.pagecount}">게시판</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/view/survey/survey.jsp">헤어 추천</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/view/survey/directhairreserve.jsp">예약하기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">나의 기록</a>
            </li>
<!--             <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li> -->
          </ul>
          <!-- end of Vertical Nav -->
        </div>
        <!-- end of Left Menu  -->


        <!-- Right area -->
        <div class="col-sm-9">
          
          <!-- Contents area -->
          <div class="border border-info p-4 rounded">
            <h5>게시판 글수정하기</h5>

            <hr class="featurette-divider">

            <form action="/board?cmd=UPDATE" method="POST">
		    <input type="hidden" name="idx" value="${ boardVo.idx }" />
		    <input type="hidden" name="menu_id" value="${ boardVo.menu_id }" />
		    <input type="hidden" name="nowpage" value="${ nowpage }" />
		    <input type="hidden" name="pagecount" value="${ pagecount }" />
              <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" class="form-control" id="id" aria-describedby="idHelp" name="id" value="${ boardVo.writer }" readonly>
              </div>

              <div class="form-group">
                <label for="subject">제목</label>
                <input type="text" class="form-control" id="title" name="title" value="${ boardVo.title }" autofocus>
              </div>

              <div class="form-group">
                <label for="content">내용</label>
                <textarea class="form-control" id="cont" rows="10" name="cont">${fn:replace( boardVo.cont, newLineChar, "<br />")}</textarea>
              </div>

              <div class="form-group">
                <label for="exampleFormControlFile1">첨부 파일 - 기능 미구현</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1">
              </div>

              <div class="my-4 text-center">
                <button type="submit" class="btn btn-primary">
                  <i class="material-icons align-middle">create</i>
                  <span class="align-middle">글 수정</span>
                </button>
                <button type="reset" class="btn btn-primary ml-3">
                  <i class="material-icons align-middle">clear</i>
                  <span class="align-middle">초기화</span>
                </button>
                <button type="button" class="btn btn-primary ml-3" onclick="location.href = '/board?cmd=LIST&menu_id=${ param.menu_id}&nowpage=${ param.nowpage }&pagecount=${ param.pagecount}'">
                  <i class="material-icons align-middle">list</i>
                  <span class="align-middle">글목록</span>
                </button>
              </div>
            </form>

          </div>
          <!-- end of Contents area -->
        </div>
        <!-- end of Right area -->
      </div>
    </div>
    <!-- end of middle container -->

    <!-- FOOTER -->
   <jsp:include page="/include/bottomFooter.jsp" />


    
    <!-- JavaScript -->
   <jsp:include page="/include/javascripts.jsp" />


</body>
</html>