<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/joinmain.css" />
<link rel="stylesheet" href="/css/bootstrap.css">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>



</style>
<script>
  $(function () {
      
  });
</script>
</head>
<body>
	<div class="join-block">
	<h1>Join</h1>
		<form action="/member?cmd=JOIN" method="POST" >
			 <!-- Right area -->
        <div class="col-sm-9">
          
          <!-- Contents area -->
          <div class="border border-info p-4 rounded" >

            <hr class="featurette-divider">

              <div class="form-group">
                <label for="id">
                  <i class="material-icons align-middle">ID</i>
                  <span class="align-middle">아이디</span>
                </label>
                <input type="text" class="form-control" id="id" aria-describedby="idHelp" name="cid" value="${MemberVo.cid}"  required autofocus>
                <small id="idHelp" class="form-text text-muted">아이디는 필수 입력 요소입니다.</small>
              </div>

              <div class="form-group">
                <label for="password">
                  <i class="material-icons align-middle">PASSWORD</i>
                  <span class="align-middle">비밀번호</span>
                </label>
                <input type="password" class="form-control" id="password" aria-describedby="pwdHelp" name="cpwd" value="${MemberVo.cpwd}"required>
                <small id="pwdHelp" class="form-text text-muted">비밀번호는 필수 입력 요소입니다.</small>
              </div>


              <div class="form-group">
                <label for="name">
                  <i class="material-icons align-middle">NAME</i>
                  <span class="align-middle">이름</span>
                </label>
                <input type="text" class="form-control" id="name" name="cname" value="${MemberVo.cname}">
              </div>

              <div class="form-group">
                <label for="birthday">
                  <i class="material-icons align-middle">BIRTHDAY</i>
                  <span class="align-middle">생년월일</span>
                </label>
                <input type="date" class="form-control" id="birthday" name="cbirth" value="${MemberVo.cbirth}">
              </div>



              <div class="form-group">
                <label for="email">
                  <i class="material-icons align-middle">E-MAIL</i>
                  <span class="align-middle">이메일</span>
                </label>
                <input type="email" class="form-control" id="email" name="cemail" value="${MemberVo.cemail}">
              </div>

              <div class="my-3 text-center">
                <button type="submit" class="btn btn-primary">회원가입</button>
              </div>

          </div>
          <!-- end of Contents area -->
        </div>
			
		</form>
		</div>
</body>
</html>