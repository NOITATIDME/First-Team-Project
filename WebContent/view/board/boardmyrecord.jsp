<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>
<link rel="stylesheet" href="../../css/boardlist.css" />
<style>
	#login             {position: absolute; top: 20px; left: 22.5px; width: 145px; height: 26px; font-size: 12px; text-align: center;}
	#myrecord          {position: absolute; top: 64px; left: 22.5px; width: 60px; height: 26px; font-size: 8px;}
	#logout            {position: absolute; top: 64px; left: 107.5px; width: 60px; height: 26px; font-size: 8px;}
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {

	});
</script>
</head>
<body>
	<div class="boardgroup">
		<div class="adminboard_main_sidebar">
			<input type="text" value="Sea 님 반갑습니다" id="login" readonly>
			<button class="smallbutton" id="myrecord">나의 기록</button>
			<button class="smallbutton" id="logout">로그아웃</button>
			<button class="largebutton" id="reviewboardmenu">후기 게시판</button>
			<button class="largebutton" id="hairrecommandmenu">헤어 추천</button>
			<button class="largebutton" id="myrecordmenu">나의 기록</button>
			<button class="largebutton" id="bookmenu">예약하기</button>
			
		</div>
		<div id="member_service_list">
			후기 게시판
		</div>
		<div class="adminboard">
			<table data-text-content="true" spellcheck="false">
				<tbody>
					<tr>
						<th style="width: 5%;">&nbsp;번호
						</th>
						<th>제목&nbsp;</th>
						<th>작성자&nbsp;</th>
						<th>작성일&nbsp;</th>
						<th>이름&nbsp;</th>
						<th>조회&nbsp;</th>
						</tr>
					</tbody>
				</table>
			</div>
	</div>
</body>
</html>