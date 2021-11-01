<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:set var="menu_id"   value = "${ param.menu_id }" />
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<style>
	.thfont { font-size: 10px;}
	.tdfont { font-size: 10px;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function() {
		
		console.log(Object.values);
		
		getboardmemberlist();
		
		/* var sendData = {"nowpage":nowpage, "pagecount":pagecount, "menu_id":menu_id} */
		// 멤버 목록 조회
		function getboardmemberlist(){
			$.ajax({
				url  : '/ajaxmemberlist?&menu_id=${ param.menu_id}&nowpage=${ param.nowpage }&pagecount=${ param.pagecount}',
				type : 'GET',
				cache: false,
				success : function(result) {
					$("#Parse_Area").html(result);
					//alert("통신 데이터 값 : " + result);
						//console.log(result);
			           var tag = "";
			           var cCnt = result.length;			            
			            if(result.length > 0){
			            	$("#empty").empty()
			                $.each(result, function(index,items){
				                var items = [];
								//$(".linkview").attr("href", "/board?cmd=VIEW&idx=" + result[index].board.idx + "&menu_id=${boardVo.menu_id}&nowpage=${nowpage}&pagecount=${pagecount}")
				                //console.log(result[index].board.idx)
				                //items.push("<tr>");
				                
								items.push("<td class='tdfont'>" + result[index].member.rn + "</td>");
	
								items.push("<td class='tdfont'>" + result[index].member.cid + "</td>");
	
								items.push("<td class='tdfont'>" + result[index].member.cpwd + "</td>");
								
								items.push("<td class='tdfont'>" + result[index].member.cbirth + "</td>");
								
								items.push("<td class='tdfont'>" + result[index].member.cname + "</td>");
								
								items.push("<td class='tdfont'>" + result[index].member.cresult + "</td>");
								
								items.push("<td class='tdfont'>" + result[index].member.cemail + "</td>");
								
								items.push("<td class='tdfont'>" + result[index].member.resday + "</td>");
	
								$("<tr>", {
									html : items
								}).appendTo("#membertable");
			                })
			            } else {
			                
			            	tag += "<div>";
			            	tag += "<div><td><h6><strong>등록된 회원이 없습니다.</strong></h6></td>";
			            	tag += "</div>";
			            	$('#membertable').append(tag);
						}
			            
	            },
				error : function(xhr) {
					console.log(xhr);
					$("#Parse_Area").html(xhr);
					alert("통신 데이터 값 : " + xhr);
					alert(xhr.status + ':' + xhr.textStatus);
				}
			});
		};
	});
	
</script>
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
              <a class="nav-link active" href="/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10">게시판</a>
            </li>
            <c:if test="${ loginid == 'Admin' }">
            <li class="nav-item">
              <a class="nav-link" href="/member?cmd=ADMINLIST&menu_id=MENU00&nowpage=1&pagecount=10">회원 관리</a>
            </li>
            </c:if>
            <li class="nav-item">
              <a class="nav-link" href="/view/survey/survey.jsp">헤어 추천</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/view/survey/directhairreserve.jsp">예약하기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="void(0);" onclick="alert('기능 미구현');return false;">나의 기록</a>
            </li>
          </ul>
          <!-- end of Vertical Nav -->
        </div>
        <!-- end of Left Menu -->


        <!-- Right area -->
        <div class="col-sm-9">

          <!-- Contents area -->
          <div class="border border-info p-4 rounded">
            <h5>회원 목록</h5>

            <hr class="featurette-divider">
              
            <!-- 새글쓰기 버튼 -->
            <button type="button" class="btn btn-primary btn-sm float-right my-3" onclick="alert('기능 미구현');return false;">
              <i class="material-icons align-middle">create</i>
              <span class="align-middle">회원 수정</span>
            </button>
              
            <div class="clearfix"></div>

            <!-- 글목록 테이블 -->
            <table  class="table table-hover" id="membertable" style="overflow:auto;">
              <thead>
                <tr>
					<th scope="col" class="thfont" >번호</th>
					<th scope="col" class="thfont">아이디</th>
					<th scope="col" class="thfont">비밀번호</th>
					<th scope="col" class="thfont">생년월일</th>
					<th scope="col" class="thfont">이름</th>
					<th scope="col" class="thfont">머리결과</th>
					<th scope="col" class="thfont">이메일</th>
					<th scope="col" class="thfont">예약일</th>
                </tr>
              </thead>
              <tbody>
 
              </tbody>
            </table>


            <!-- pagination area -->
            <c:set  var="startPageNum"       value="${ memberpageVo.startpagenum }" />
			<c:set  var="endPageNum"         value="${ memberpageVo.endpagenum }" />
			<c:set  var="nowpage"            value="${ memberpageVo.nowpage }" />
			<c:set  var="pagecount"          value="${ memberpageVo.pagecount }" />
			<c:set  var="totalpagecount"     value="${ memberpageVo.totalpagecount }" />
            <nav aria-label="Page navigation example">
              <ul class="pagination justify-content-center my-4">
              <c:if test="${ startPageNum gt 1 }">
                <li class="page-item disabled"><a class="page-link" href="/member?cmd=ADMINLIST&menu_id=MENU00&nowpage=${startPageNum-1}&pagecount=${pagecount}">이전</a></li>
              </c:if> 
              <c:forEach var="pagenum"  begin="${startPageNum}" end="${endPageNum}" step="1"  >
                <li class="page-item active"><a class="page-link" href="/member?cmd=ADMINLIST&menu_id=MENU00&nowpage=${pagenum}&pagecount=${pagecount}">${ pagenum }</a></li>
              </c:forEach>
              <c:if test="${ endPageNum  lt totalpagecount }">
                <li class="page-item"><a class="page-link" href="/member?cmd=ADMINLIST&menu_id=MENU00&nowpage=${endPageNum+1}&pagecount=${pagecount}">다음</a></li>
              </c:if>
              </ul>
            </nav>
            <!-- end of pagination area -->

            <hr class="featurette-divider">

              
            <!-- Search area -->
            <form class="form-inline justify-content-center my-4">
          
              <div class="form-group mx-3">
                <label for="searchType">검색 조건</label>
                <select class="form-control mx-2" id="searchType" name="type">
                  <option value="" disabled selected>--</option>
                  <option value="T">아이디</option>
                  <option value="C">이름</option>
                  <option value="W">이메일</option>
                </select>
              </div>

              <label for="searchKeyword">검색어</label>
              <input type="text" class="form-control mb-2 mr-sm-2 mx-2" id="searchKeyword" placeholder="검색어" name="keyword">

              <button type="submit" class="btn btn-primary mb-2" onclick="alert('기능 미구현');return false;">
                <i class="material-icons align-middle">search</i>
                <span class="align-middle">검색</span>
              </button>
            </form>
            <!-- end of Search area -->
          </div>
          <!-- end of Contents area -->
        </div>
        <!-- end of Right area -->
      </div>
    </div>
    <!-- end of middle container -->

    
    <!-- JavaScript -->
   <jsp:include page="/include/javascripts.jsp" />


</body>
</html>