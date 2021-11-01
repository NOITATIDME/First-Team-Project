<%@page import="board.vo.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="nowpage"     value = "${ pageVo.nowpage }" /> 
<c:set var="pagecount"   value = "${ pageVo.pagecount }" /> 
<c:set var="menu_id"   value = "${ param.menu_id }" /> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/../css/bootstrap.css" />
<meta charset="UTF-8">
<title>후기 게시판</title>
<style>

 table {
    width:800px; 
    height:300px;
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
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		getboardlist();
		
		/* var sendData = {"nowpage":nowpage, "pagecount":pagecount, "menu_id":menu_id} */
		function getboardlist(){
			$.ajax({
				url  : '/board?cmd=BOARDLIST&menu_id=${ param.menu_id}&nowpage=${ param.nowpage }&pagecount=${ param.pagecount}',
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
				                
								items.push("<td>" + result[index].board.bnum + "</td>");
	
								items.push("<td><a href='/board?cmd=VIEW&idx=" + result[index].board.idx + "&menu_id=${boardVo.menu_id}&nowpage=${param.nowpage}&pagecount=${param.pagecount}'>" + result[index].board.title + "</td>");
	
								items.push("<td>" + result[index].board.writer + "</td>");
								
								items.push("<td>" + result[index].board.regdate + "</td>");
								
								items.push("<td>" + result[index].board.cname + "</td>");
								
								items.push("<td>" + result[index].board.readcount + "</td>");
	
								$("<tr>", {
									html : items
								}).appendTo("#boardtable");
			                })
			            } else {
			                
			            	tag += "<div>";
			            	tag += "<div><td><h6><strong>등록된 게시글이 없습니다.</strong></h6></td>";
			            	tag += "</div>";
			            	$('#boardtable').append(tag);
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
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=${ param.nowpage }&pagecount=${ param.pagecount }">Hair</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse collapse" id="navbarColor01" style="">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="/board?cmd=WRITEFORM&menu_id=${boardVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${param.nowpage}&pagecount=${param.pagecount}">글쓰기
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
    ${ param.nowpage }
    ${ param.pagecount }
  </div>
</nav>

<div class="box">
<h1>후기 게시판</h1>
<table class="table table-hover" id="boardtable">
  <thead class="empty">
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
      <th scope="col">이름</th>
      <th scope="col">조회</th>
    </tr>
  </thead>
  <tbody >

  </tbody>
</table>
<%@include file="/include/paging.jsp"  %> 
</div>
	
</body>
</html>