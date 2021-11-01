<%@page import="board.vo.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<% request.setCharacterEncoding("utf-8"); %>

<c:set var="nowpage"     value = "${ param.nowpage }" /> 
<c:set var="pagecount"   value = "${ param.pagecount }" /> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/../css/bootstrap.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>

<meta charset="UTF-8">
<title>후기 게시판</title>
<style>

 .view {
    width:960px; 
    height:500px;
    margin:0 auto;
	}

	.commentview{
	    width:960px; 
    	height:300px;
    	margin:0 auto;
	}

 table {
    width:900px; 
    height:40px;
    margin:0 auto;
    border:1px solid black;
     border-collapse :collapse;
	}
	.box {
		width:1200px; 
		height:700px;
		position:absolute; 
		top:50%; 
		margin-top:-250px; 
		left:50%;
		margin-left:-600px;
	}
 	h1{
 		text-align:center;
 	}
 	
 	.comment {
 		width:960px;
 		height:200px;
 		margin:0 auto;
 	}
	.titlebox { display: inline; width: 500px; }
	.title { display: inline; margin-right: 20px;}
	.titlevalue { display: inline; width:300px;}
	.readcountbox { position: absolute; display: inline; left: 80%; }
	.readcount { display: inline; margin-right: 20px; }
	
	.trinlineblock {display: inline-block; width:60%;}
	.wrinlineblock {display: inline-block; width:66%;}
	
	.writerbox {display: inline; }
	.writer { display: inline; margin-right: 20px;}
	.regdatebox { position: absolute; display: inline; left: 70%; }
	.regdate { display: inline; margin-right: 20px; }
	.left_cont {text-align: left; width: 40%;}
	
	.commentwriter { width: 10%;}
	.commentregdate { width: 15%; font-size: 12px;}
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<script>	
	$(function() {
	
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
		
		/* ---------------------------------------------------- */
	
		
	});
</script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=${ param.nowpage }&pagecount=${ param.pagecount }">Hair</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse collapse" id="navbarColor01" >
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="/board?cmd=WRITEFORM&menu_id=${boardVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagecount=${pagecount}">글쓰기
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member?cmd=LOGOUT">로그아웃</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10">후기게시판</a>
        </li>
        <c:if test="${ loginid == 'Admin' }">
        <li class="nav-item">
          <a class="nav-link" href="/member?cmd=ADMINLIST&menu_id=MENU00&nowpage=1&pagecount=10">관리게시판</a>
        </li>
        </c:if>
        <li class="nav-item">
          <a class="nav-link" href="#">헤어 추천</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">나의 기록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">예약하기</a>
        </li>

      </ul>

    </div>
  </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" >${ loginid } 님 반갑습니다.</a>
  </div>
</nav>

	<div class="box">
		<div class="view">
			<h1>후기 게시판</h1>
			<h2>${ param.nowpage }, ${ param.pagecount }, ${ pageVo.nowpage } </h2>
			<div><div class="titlebox"><div class="title">제목</div><div class="titlevalue">${ boardVo.title }</div></div><div class="readcountbox"><div class="readcount">조회수</div>${ boardVo.readcount }</div></div>
			<div><div class="writerbox"><div class="writer">작성자</div>${ boardVo.writer }</div><div class="regdatebox"><div class="regdate">작성일</div>${ boardVo.regdate }</div></div>
			<hr>
			<p>내용</p>
			<p>${fn:replace( boardVo.cont, newLineChar, "<br />")}</p>
			<c:if test="${loginid eq boardVo.writer }">
			<div>
				<button id="boardupdatebutton">수정하기</button>
				<button id="boarddeletebutton">삭제하기</button>
			</div>
			</c:if>
		</div>
		<div class="commentview">
		<hr>
		<div >댓글</div>
    	<table class="table table-hover" style="width: 100%;" id="commenttable">
		
		</table>
		<div id=""></div>
		<%@include file="/include/commentpaging.jsp"  %>
		<%@include file="/include/comment.jsp" %>

		</div>	
	</div> 
		

</body>
</html>