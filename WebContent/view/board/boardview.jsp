<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="nowpage"     value = "${ param.nowpage }" /> 
<c:set var="pagecount"   value = "${ param.pagecount }" />
<c:set var="pagecount"   value = "${ param.pagecount }" />
<%-- <c:set var="commentTotalCount"   value =${ commentList.CommentVo.totalcount } /> --%>

<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="/css/boardview.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function() {
		// console.log("${ comment }");
		var commentTotalcount;
		getCommentList();
		//  console.log(commentTotalcount);
		
		$('#focuscomment').click(function() {
			document.getElementById('focuswritecomment').scrollIntoView();
		});
		
		$('#boardupdatebutton').click(function() {
			var loc = '/board';
			var params = '?cmd=UPDATEFORM&idx=${boardVo.idx}&menu_id=${boardVo.menu_id}&nowpage=${nowpage}&pagecount=${pagecount}';
			location.href = loc + params;
		});
		
		$('#boarddeletebutton').click(function() {
			var select;
			select = confirm('삭제하시겠습니까?');
			if(select) {
				var loc = '/board';
				var params = '?cmd=DELETE&idx=${boardVo.idx}&menu_id=${boardVo.menu_id}&nowpage=${nowpage}&pagecount=${pagecount}';
				location.href = loc + params;
			} else {
				
			}
	});
	function getCommentList(){
		$.ajax({
			url  : '/ajaxcommentlist?&idx=${ param.idx}&comment_nowpage=${ param.nowpage }&comment_pagecount=${ param.pagecount}',
			dataType : "json",
			type : 'GET',
			cache: false,
			success : function(clresult) {
				commentTotalcount = clresult[0].comment.totalcount;
				$('#getCommentTotalCount').attr('commentTotalCount', commentTotalcount);
				var cCnt = clresult.length;			
				
	            if(clresult.length > 0){
	            
					console.log(clresult[0].comment.comment_writer);
					$.each(clresult,function(index,items){
						var tag = "<li class='media mb-2'>";
						tag    += "<img src='' width='50' height='50' class='mr-3 rounded-circle'>";
						tag    += "<div class='media-body'><div class='row'><div class='col-md-4'><h6>" + clresult[index].comment.comment_writer + "</h6>";
						tag    += "</div><div class='col-md-8'><div class='text-right text-secondary'><time class='comment-date'>" + clresult[index].comment.comment_regdate + "</time>";
						tag    += "&nbsp;&nbsp;|&nbsp; <input type='button' class='deleteComment' data-del='" + clresult[index].comment.comment_idx + "' id='btnDel' name='btnDel' /></div></div></div><p>" + clresult[index].comment.comment_cont + "</p></div></li>";
						$("#commentview").append(tag);
					});
				
				$("input:button.deleteComment").on('click',deleteComment)
				
				} else {
	            	tag += "<li><div><td><h6><strong>등록된 댓글이 없습니다.</strong></h6></td></li>";
	            	$('#commenttable').append(tag);
				}
			},
			error : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus);
			}
		});
	};
		
		$('#addComment').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			var comment_cont = $('#comment_cont').val();
			var sendData = { comment_hboard: "${boardVo.idx}", comment_cont : comment_cont, menu_id: "${boardVo.menu_id}", comment_writer: "${ loginid }", comment_bnum: "0", comment_lvl : "0", comment_step : "0", comment_nref : "0", comment_nowpage : "${ nowpage }", comment_pagecount : "${ pagecount }" };
			//alert('댓글 추가클릭') 
			$.ajax({
				url  :  '/ajaxwritecomment',
				data :  sendData,
				type : 'POST' ,
				success : function(result) {
					$("#comment_cont").val("");
					return location.reload();
					//getCommentList();
				},
				error : function(xhr) {
					console.log(xhr)
					alert(xhr.status + ':' + xhr.textStatus);	
				}
					
					
			});
		});
		
	   	function deleteComment(){
	   		var comment_idx = $(this).attr("data-del");
	   		var sendData = {"comment_idx": comment_idx}
	  		$.ajax({
				url  :  '/ajaxdeletecomment',
				data :  sendData,
				type : 'POST' ,
				success : function(result) {
					console.log(result);
					document.location.reload();
				},
				error : function(xhr) {
					alert(xhr.status + ':' + xhr.textStatus);	
				}    
	 		});
	 	}; 	
		
});
</script>
   <%--  include head.jsp --%>
   <jsp:include page="/include/head.jsp"></jsp:include>
    
    
    <style>
      time.comment-date {
        font-size: 13px;
      }
    </style>
</head>
<body>
   <%-- include topnavbar.jsp --%>
	<jsp:include page="/include/topNavbar.jsp"/>



    <!-- middle container -->
    <div class="container mt-4">
      <div class="row">

        <!-- Left Menu -->
        <div class="col-sm-3">

          <!-- Vertical Nav -->
          <ul class="nav flex-column nav-pills">
            <li class="nav-item">
              <a class="nav-link active" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id}&nowpage=${ param.nowpage }&pagecount=${ param.pagecount}">게시판</a>
            </li> 
            <li class="nav-item">
              <a class="nav-link" href="/view/survey/survey.jsp">헤어 추천</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/view/survey/directhairreserve.jsp">예약하기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="void(0);" onclick="alert('기능 미구현');return false;">나의 기록</a>
            </li>
<!--             <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li> -->
          </ul>
          <!-- end of Vertical Nav -->
        </div>
        <!-- end of Left Menu -->


        <!-- Right area -->
        <div class="col-sm-9">
          
          <!-- Contents area -->
          <div class="border border-info p-4 rounded">
            <h5>게시판 글 상세보기</h5>

            <hr class="featurette-divider">

            <!-- 글 상세보기 영역 -->
            <table class="table table-striped">
              <tr>
                <th scope="row" class="text-center">제목</th>
                <td colspan="5">${ boardVo.title }</td>
              </tr>
              <tr>
                <th scope="row" class="text-center">작성자</th>
                <td>${ boardVo.writer }</td>
                <th scope="row" class="text-center">작성일</th>
                <td>${ boardVo.regdate }</td>
                <th scope="row" class="text-center">조회수</th>
                <td>${ boardVo.readcount }</td>
              </tr>
              <tr>
                <th scope="row" class="text-center">추천</th>
                <td class="text-primary">X</td>
                <th scope="row" class="text-center">비추천</th>
                <td class="text-danger">X</td>
                <th scope="row" class="text-center" id="getCommentTotalCount" commentTotalCount="" >댓글</th>
                <td id="ctc">X</td>
              </tr>
              <tr>
                <th scope="row" class="text-center">내용</th>
                <td colspan="5" height="400px">
                  ${fn:replace( boardVo.cont, newLineChar, "<br />")}
                </td>
              </tr>
              <tr>
                <th scope="row" class="text-center">첨부파일</th>
                <td colspan="5">
                  <ul>
                    <li>미구현</li>
                  </ul>
                </td>
              </tr>
            </table>

            
            <div class="text-right mt-4">
              <c:if test="${loginid eq boardVo.writer }">
              <button type="button" class="btn btn-info btn-sm" id="boardupdatebutton">
                <i class="material-icons align-middle">edit</i>
                <span class="align-middle">글수정</span>
              </button>
              <button type="button" class="btn btn-info btn-sm ml-3" id="boarddeletebutton">
                <i class="material-icons align-middle">delete</i>
                <span class="align-middle">글삭제</span>
              </button>
              </c:if>
              <button type="button" class="btn btn-info btn-sm ml-3" id="focuscomment">
                <i class="material-icons align-middle">reply</i>
                <span class="align-middle">답글쓰기</span>
              </button>
              <button type="button" class="btn btn-info btn-sm ml-3" onclick="location.href = '/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10'">
                <i class="material-icons align-middle">list</i>
                <span class="align-middle">글목록</span>
              </button>
            </div>



            <!-- Comment -->
            <div id="comment" class="border border-secondary mt-5 p-3">
				<i class="material-icons">forum</i> 댓글

				<hr class="featurette-divider">
	
				<ul class="list-unstyled mt-4" id="commentview">
	
				</ul> 
	              
				<hr class="featurette-divider">
				
				<!-- pagination area -->
	            <c:set  var="startPageNum"       value="${ pageVo.startpagenum }" />
				<c:set  var="endPageNum"         value="${ pageVo.endpagenum }" />
				<c:set  var="nowpage"            value="${ pageVo.nowpage }" />
				<c:set  var="pagecount"          value="${ pageVo.pagecount }" />
				<c:set  var="totalpagecount"     value="${ pageVo.totalpagecount }" />
	            <nav aria-label="Page navigation example">
	              <ul class="pagination justify-content-center my-4">
	              <c:if test="${ startPageNum gt 1 }">
	                <li class="page-item disabled"><a class="page-link" href="/board?cmd=VIEW&idx=${boardVo.idx}&nowpage=${startPageNum-1}&pagecount=${pagecount}">">이전</a></li>
	              </c:if> 
	              <c:forEach var="pagenum"  begin="${startPageNum}" end="${endPageNum}" step="1"  >
	                <li class="page-item active"><a class="page-link" href="/board?cmd=VIEW&idx=${boardVo.idx}&nowpage=${pagenum}&pagecount=${pagecount}">${ pagenum }</a></li>
	              </c:forEach>
	              <c:if test="${ endPageNum  lt totalpagecount }">
	                <li class="page-item"><a class="page-link" href="/board?cmd=VIEW&idx=${boardVo.idx}&nowpage=${endPageNum+1}&pagecount=${pagecount}">다음</a></li>
	              </c:if>
	              </ul>
	            </nav>
	            <!-- end of pagination area -->
	
				<!-- write new comment -->
				<c:if test="${ loginid != null }">
				<form action="" method="post">
					<div class="row my-4">
						<div class="col-10">
	                   		<div class="form-group" id="focuswritecomment">
	                      	<label for="exampleFormControlTextarea1">새댓글 작성</label>
	                      	<textarea class="form-control" id="comment_cont" rows="3"></textarea>
	                    	</div>
						</div>
						<div class="col-2 align-self-center">
							<button type="submit" class="btn btn-info btn-sm" id="addComment">작성</button>
						</div>
	                </div>
				</form>
				</c:if>
              <!-- end of write new comment -->
			</div>
            <!-- end of Comment -->


          </div>
          <!-- end of Contents area -->
        </div>
        <!-- end of Right area -->
      </div>
    </div>
    <!-- end of middle container -->



    <!-- FOOTER -->
    <footer class="mt-5 py-5 bg-warning">
      <div class="container">
        <div class="row">
           <div class="col-12 col-md">
            <i class="material-icons">android</i>
            <small class="d-block mb-3 text-muted">&copy; 2017-2021</small>
          </div> 
          <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Cool stuff</a></li>
              <li><a class="text-muted" href="#">Random feature</a></li>
              <li><a class="text-muted" href="#">Team feature</a></li>
              <li><a class="text-muted" href="#">Stuff for developers</a></li>
              <li><a class="text-muted" href="#">Another one</a></li>
              <li><a class="text-muted" href="#">Last time</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Resource</a></li>
              <li><a class="text-muted" href="#">Resource name</a></li>
              <li><a class="text-muted" href="#">Another resource</a></li>
              <li><a class="text-muted" href="#">Final resource</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Team</a></li>
              <li><a class="text-muted" href="#">Locations</a></li>
              <li><a class="text-muted" href="#">Privacy</a></li>
              <li><a class="text-muted" href="#">Terms</a></li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
    <!-- end of FOOTER -->



    <!-- JavaScript -->
    <!-- <script src="/resources/js/jquery-3.6.0.js"></script>
    <script src="/resources/js/bootstrap.js"></script> -->

</body>
</html>