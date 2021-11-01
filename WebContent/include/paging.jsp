<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<link rel="stylesheet" href="/../css/bootstrap.css" />
<meta charset="UTF-8">
<c:set  var="startPageNum"       value="${ pageVo.startpagenum }" />
<c:set  var="endPageNum"         value="${ pageVo.endpagenum }" />
<c:set  var="nowpage"            value="${ pageVo.nowpage }" />
<c:set  var="pagecount"          value="${ pageVo.pagecount }" />
<c:set  var="totalpagecount"     value="${ pageVo.totalpagecount }" />

 <div id="paging" style="display: table; margin-left: auto; margin-right: auto;">
  <ul class="pagination">
    <c:if test="${ startPageNum gt 1 }">
    <li class="page-item disabled">
      <a class="page-link" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=1&pagecount=${pagecount}">◀</a>
    </li>
    <li class="page-item disabled">
      <a class="page-link" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=${startPageNum-1}&pagecount=${pagecount}">&laquo;</a>
    </li>
   </c:if> 
   
   <c:forEach var="pagenum"  begin="${startPageNum}" end="${endPageNum}" step="1"  >
    <li class="page-item active">
      <a class="page-link" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=${pagenum}&pagecount=${pagecount}">${ pagenum }</a>
    </li>
    </c:forEach>  
    
    <c:if test="${ endPageNum  lt totalpagecount }">
    <li class="page-item">
      <a class="page-link" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=${endPageNum+1}&pagecount=${pagecount}">&raquo;</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="/board?cmd=LIST&menu_id=${ boardVo.menu_id }&nowpage=${totalpagecount}&pagecount=${pagecount}">▶</a>
    </li>
    </c:if>
  </ul>
</div>

 
 
 
 
 
 