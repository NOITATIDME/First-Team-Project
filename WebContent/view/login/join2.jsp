<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
  $(function () {
      
  });
</script>
</head>
<body>
	<form action="/member?cmd=JOIN" method="POST">
	<div>
	<input type="text" value="" name="cid" title="아이디" placeholder="3~10자 이내" maxlength="10"/>
	</div>
	<div>
	<input type="text" value="" name="cpwd" title="비밀번호" placeholder="4~10자 이내" maxlength="10"/>
	</div>
	<div>
	<input type="text" value="" name="cname" title="이름" maxlength="10"/>
	</div>
	<div>
	<input type="text" value="" name="cbirth" title="생년월일" maxlength="8"/>
	</div>
	<div>
	<input type="email" value="" name="cemail" title="이메일" maxlength="20"/>
	</div>
	<input type="submit" value="가입하기" />
	</form>
</body>
</html>