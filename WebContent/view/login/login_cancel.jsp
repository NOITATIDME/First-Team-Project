<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/loginmain.css" />
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	alert("아이디나 비밀번호를 확인하세요")
</script>
</head>
<body>
	<div class="logo"></div>
	<div class="login-block">
	    <h1>Login</h1>
	    <form action="/member?cmd=LOGIN" method="POST"> 
	    	<input type="hidden" name="menu_id" value="${ param.menu_id }" />
      		<input type="hidden" name="nowpage" value="${ param.nowpage }" />
      		<input type="hidden" name="pagecount" value="${ param.pagecount }" />
		    <input type="text" value="" name="cid" placeholder="ID" id="username" />
		    <input type="password" value="" name="cpwd" placeholder="Password" id="password" />
		    <input type="submit" value="로그인" id="subbtn"/>
	    </form>

	    <button onclick="location.href='/view/login/login.jsp?menu_id=MENU01&nowpage=1&pagecount=10'">회원가입</button>
	</div>
</body>
</html>