<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/directhairreserve.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<style>
@import url('https://fonts.googleapis.com/css2?family=Yeon+Sung&display=swap');
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<script>
	$(function() {
		$.datepicker.setDefaults({
		    dateFormat: 'yy년 mm월 dd일',
		    showMonthAfterYear: true
		});
	});	
	
    $(function() {
		$( "#datepicker" ).datepicker({ minDate: 0});
    	$( "#datepicker" ).datepicker('setDate', new Date);
	});
    
    $(function() {
    	$('#timepicker').timepicker({
    	    timeFormat: 'h:mm p',
    	    interval: 60,
    	    minTime: '10',
    	    maxTime: '7:00pm',
    	    defaultTime: '10',
    	    startTime: '10:00',
    	    dynamic: false,
    	    dropdown: true,
    	    scrollbar: true
    	});
	});
    

</script>
</head>
<body>
   <div id="div1" >
   <form action="/survey?cmd=DIRECTRESERVE" method="POST">
   <table align=center id="table1" >
   	  <caption><h2 align=center>예약하기</h2></caption>
   	    <tr>
   	      <td id="td1">회원아이디</td>
   	      <td colspan="2" align=center id="td2">${ loginid }</td>
   	    </tr>
   	    <tr>
   	      <td id="td1">회원이름</td>
   	      <td colspan="2" align=center id="td2">${ cname }</td>
   	    </tr>
   	    <tr>
   	      <td id="td1">원하는 헤어 스타일</td>
   	      <td colspan="2" align=center id="td2">
   	      <input type="text" name="hair_name" />
   	      </td>
   	    </tr> 
   	    <tr>
   	    </tr>
   	      <td id="td1">예약<br>날짜 및 시간</td>
   	      <td colspan="2" id="td2"><input type="text" name="reservedate" id="datepicker" value="" />
   	   	  <input type="text" name="reservetime" id="timepicker" value="" /></td>
   	    </tr>
   		</table>
   		<br>
   	  <table align=center>
   	    <tr>
      	  <td colspan="3" align=center >
          <input type="submit" value="예약하기" id="subbtn"/></td>
   		  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>
          <td><a href="/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10" id="a1">취소하기
          <input type="hidden" name="loginid" value="${ loginid }"/>
          </a></td>
        </tr>
      </table>
   </form>
   </div>
</body>
</html>