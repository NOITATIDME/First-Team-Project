<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/result.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Gloria+Hallelujah&family=Yeon+Sung&display=swap');
</style>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
  $(function () {
      
  });
</script>
</head>
<body>
   <th><h1 align=right>Our shop Suggest these Hairstyles for YOU&nbsp;&nbsp;&nbsp;&nbsp;</h1></th>
   <div>
   <h3 align=center>마음에 드는 헤어를 골라보세요</h3>
   <form action="/survey?cmd=RESERVEFORM" method="POST" >
   <table width="210" height="210" align=center>
   <tr align=center >
   <c:forEach var="hair" items="${ hairList }">
       <td><img src="/images/${hair.hair_name}.jpg" width='200px' height='200px'/></td>
   </c:forEach>
   </tr>
   <tr align=center >
   <c:forEach var="hair" items="${ hairList }">
       <td><input type="radio" name="hair_id" value="${ hair.hair_id }" id="${ hair.hair_id }" >
	   <label for = "${ hair.hair_id }">${ hair.hair_name }</label>
       </td>
   </c:forEach>
   <table width="210" height="210" align=center>
   <tr align=center>
     <input type="hidden" name="cid" value="${ cid }" />
     <td><input type="submit" value="선택한 헤어로 할래요" id="subbtn" /></td>
     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
     <td><a href="/view/survey/survey.jsp">두상이 제가 생각한 것과는 다른 것 같아요</a></td>
   </tr>
   </form>
   
   </div>
</body>
</html>