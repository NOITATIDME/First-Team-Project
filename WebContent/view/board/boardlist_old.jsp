<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="nowpage"     value = "${ pageVo.nowpage }" /> 
<c:set var="pagecount"   value = "${ pageVo.pagecount }" /> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/navbar-top-fixed.css" />

<style>
	#login             {position: absolute; top: 20px; left: 22.5px; width: 145px; height: 26px; font-size: 12px; text-align: center;}
	#memberupdate      {position: absolute; top: 64px; left: 22.5px; width: 60px; height: 26px; font-size: 8px;}
	#logout            {position: absolute; top: 64px; left: 107.5px; width: 60px; height: 26px; font-size: 8px;}
	#main              { width: 70%; margin: 0px auto; }
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		$('#logout').click(function() {
			var loc = '/member';
			var params = '?cmd=LOGOUT';
			location.href = loc + params;
			
		});
		
	$(function() {
		$('#reviewboardmenu').click(function() {
			var loc = '/board';
			var params = '?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10';
			location.href = loc + params;
		});
	});
	
	
	});
</script>
</head>
<body>
	<div id="main">
	<div class="boardgroup">
		<div class="board_main_sidebar">
			<input type="text" value="${ sessionScope.loginid } 님 반갑습니다" id="login" readonly>
			<!-- <button class="smallbutton" id="memberupdate">회원 수정</button> -->
			<button class="smallbutton" id="logout">로그아웃</button>
			<button class="largebutton" id="reviewboardmenu">후기 게시판</button>
			<form action="/view/survey/survey.jsp">
			<input type="hidden" name="cid" value="${ sessionScope.loginid }" />
			<input type="submit" value="헤어추천" />
			</form>
			<button class="largebutton" id="myrecordmenu">나의 기록</button>
			<button class="largebutton" id="bookmenu">예약하기</button>
			
		</div>
		<div id="member_service_list">
			후기 게시판
		</div>
		<div class="board">
			<table data-text-content="true" spellcheck="false" class="table table">
				<tbody>
					<tr>
						<th style="width: 10%;">&nbsp;번호
						</th>
						<th scope="col">제목&nbsp;</th>
						<th scope="col">작성자&nbsp;</th>
						<th scope="col">작성일&nbsp;</th>
						<th scope="col">이름&nbsp;</th>
						<th scope="col">조회&nbsp;</th>
					</tr>
						
					<c:forEach var="board" items="${ boardList }"  >
					<tr class="table-active" >
						<td>
					    <c:choose>
					    	<c:when test="${ board.lvl == 0 }">
					        	${ board.bnum }
					    	</c:when>
					    <c:otherwise>            
					    </c:otherwise>
					    </c:choose> 
					</td>
					  
					<td class="left" style="padding-left:${ board.lvl * 30 + 10 }px">
					<c:choose>
					<%-- 새글 부분 --%>
						<c:when test="${ board.lvl eq 0 }">   
							<c:choose>
								<c:when test="${  board.delnum eq 0 }">
								<a href="/board?cmd=VIEW&idx=${board.idx}&menu_id=${board.menu_id}&nowpage=${nowpage}&pagecount=${pagecount}">
									${ board.title }
								</a>
								</c:when>
							<c:otherwise>	         
								<s>삭제된 글입니다</s>
							</c:otherwise>
							</c:choose>
						</c:when>
					    
					    <%-- 답글 부분 --%>
					    <c:otherwise>
					       <c:choose>
					         <c:when test="${ board.delnum eq 0 }">
					      <a href="/board?cmd=VIEW&idx=${board.idx}&menu_id=${board.menu_id}&nowpage=${nowpage}&pagecount=${pagecount}">
					      [Re] ${ board.title }
					      </a>
					      </c:when>
					      <c:otherwise>	          
					         [Re] <s>삭제된 글입니다</s>
							</c:otherwise>
						</c:choose>          
							</c:otherwise>         
						</c:choose>        
					</td>
					   
					<td>${ board.writer }</td>
					<td>${ board.regdate }</td>

					<td>${ board.cname }</td>

					<td>${ board.readcount }</td>       
					</tr> 
					</c:forEach> 

					</tbody>
				</table>
			<%@include file="/include/paging.jsp"  %> 
			</div>
	</div>
	</div>
	
</body>
</html>