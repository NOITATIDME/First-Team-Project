<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>
<link rel="stylesheet" href="../../css/boardlist.css" />
<style>
	#login             {position: absolute; top: 20px; left: 22.5px; width: 145px; height: 26px; font-size: 12px; text-align: center;}
	#memberupdate      {position: absolute; top: 64px; left: 22.5px; width: 60px; height: 26px; font-size: 8px;}
	#logout            {position: absolute; top: 64px; left: 107.5px; width: 60px; height: 26px; font-size: 8px;}
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		
		$('#logout').click(function() {
			var loc = '/member';
			var params = '?cmd=LOGOUT';
			location.href = loc + params;
			
		});
		
		$('#reviewboardmenu').click(function() {
			var loc = '/board';
			var params = '?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10';
			location.href = loc + params;
		});
	});
</script>
</head>
<body>
	<div class="boardgroup">
		<div class="board_main_sidebar">
			<input type="text" value="${ loginid } 님 반갑습니다" id="login" readonly>
			<!-- button class="smallbutton" id="myrecord">회원 수정</button> -->
			<button class="smallbutton" id="logout">로그아웃</button>
			<button class="largebutton" id="reviewboardmenu">후기 게시판</button>
			<button class="largebutton" id="hairrecommandmenu">헤어 추천</button>
			<button class="largebutton" id="myrecordmenu">나의 기록</button>
			<button class="largebutton" id="bookmenu">예약하기</button>
			
		</div>
		<div id="member_service_list">
			후기 게시판
		</div>
		<div class="boardview">
			<div style="margin:20px;">
				<div>
					
					<div>제목&emsp;&emsp;${ boardVo.title }&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;조회수&emsp;&emsp;${ boardVo.readcount }</div>
					<p>작성자&emsp;&emsp;${ boardVo.writer }&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;작성일&emsp;&emsp;${ boardVo.regdate }</p>
					<hr>
					<p>내용</p>
					<p>${fn:replace( boardVo.cont, newLineChar, "<br />")}</p>
					<hr>
					<p>댓글</p>
					<form action="/board?cmd=WRITECMTFORM" method="POST">
					<c:if test="${ commentList != null }" >
						<c:forEach var="comment" items="${ commentList }" >
							<tr>
								<!-- 아이디, 작성 날짜  -->
								<td width="150">
									<div>
										 ${comment.comment_id}<br>
										 <font size="2" color= "lightgray">${comment.comment_date }</font>
									</div>
								</td>
								<!-- 본문 내용 -->
								<td width="550">
									<div class="text_wrapper">
										${comment.comment_cont}
									</div>
								</td>
								<!-- 버튼 -->
								<td width="100">
									<div id="btn" style="text-align: center;">
										<a href="#">[답변]</a><br>
										<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->
										<c:if test="${ comment.comment_id == loginid }">
											<a href="#">[수정]</a><br>
											<a href="#">[삭제]</a>
										</c:if>
									</div>
								</td>
						</c:forEach>
					</c:if>
					<!-- 로그인 했을 경우에만 댓글 작성 가능 -->
					<c:if test="${ loginid != null }" >
						<tr bgcolor="#F5F5F5">
						<!-- <form id="writeCommentForm"> -->
							<input type="hidden" name="comment_hboard" value="${board.idx }" />
							<input type="hidden" name="comment_id" value="${ loginid }" />
							<!-- 아이디 -->
							<td width="150">
								<div>
									${ loginid }
								</div>
							</td>
							<!-- 본문작성 -->
							<td width="550">
								<div>
									<textarea name="comment_cont" row="4" cols="70"></textarea>
								</div>
							</td>
							<!-- 댓글 등록 버튼 -->
							<td width="100">
								<div id="btn" style="text-align: center;">
									<p><input type="submit" value="[댓글등록]" /></p>
								</div>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>