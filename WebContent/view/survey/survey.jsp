<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/survey3.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Yeon+Sung&display=swap');
</style>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
  $(function () {
      
  });
</script>
</head>

<body>
	<form  action="/survey?cmd=RESULT" method="POST">
	<div>
	<h1 align=center>자신의 두상을 선택해주세요</h1>
	<table width="210" height="210" align=center>
	<tr align=center>
      <td><img src="/images/OVAL.jpg" width='200px' height='200px' /></td>
      <td><img src="/images/OBLONG.jpg" width='200px' height='200px' /></td>
      <td><img src="/images/SQUARE.jpg" width='200px' height='200px' /></td>
      <td><img src="/images/TRIANGULAR.jpg" width='200px' height='200px' /></td>
	</tr>
	<tr align=center bgcolor="white" >  
	  <td><input type="radio" name="face" class="shape" value="1" id="oval">
          <label for="oval">계란형얼굴</label>
      </td>
	  <td><input type="radio" name="face" class="shape" value="2" id="square">
          <label for="square">사각형얼굴</label>
      </td>
	  <td><input type="radio" name="face" class="shape" value="3" id="oblong">
          <label for="oblong">직사각형얼굴</label>
      </td>
	  <td><input type="radio" name="face" class="shape" value="4" id="triangular">
          <label for="triangular">삼각형얼굴</label>
      </td>
    </tr>
    <br>
    </table>
    <table width="210" height="210" align=center>
    <tr align=center>
      <td><img src="/images/ROUND.jpg" width='200px' height='200px' /></td>
      <td><img src="/images/DIAMOND.jpg" width='200px' height='200px' /></td>
      <td><img src="/images/HEART.jpg" width='200px' height='200px' /></td>
    </tr>
    <tr align=center bgcolor="white">
	  <td><input type="radio" name="face" class="shape" value="5"id="round">
          <label for="round">둥근얼굴</label>
      </td>
	  <td><input type="radio" name="face" class="shape" value="6" id="diamond">
          <label for="diamond">다이아몬드형얼굴</label>
      </td>    
	  <td><input type="radio" name="face" class="shape" value="7" id="heart">
          <label for="heart">하트형얼굴</label>
      </td>
    </tr>  
    </table>
    <br>
    <table align=center>
    <tr align=center>
    <td><input type="submit" value="두상을 선택했어요" id="subbtn"/></td>
    </tr>
    </table>
    </div>
    <input type="hidden" name="cid" value="${ sessionScope.loginid }" />
	</form>
</body>
</html>