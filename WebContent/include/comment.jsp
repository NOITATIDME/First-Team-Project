<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
$(function() {
	var request = new XMLHttpRequest();
getCommentList();

// 댓글 입력 확인
	$('.boardwriteCmtCmt').on('click', function() {
	var comment_cont = $('#comment_cont').val();
	console.log(comment_cont);
	if(!comment_cont) {
		alert("내용을 입력하세요");
		return false;
	} else {
	$('input[name=comment_cont]').attr('value',comment_cont);
	}
});

	// 댓글 입력 확인
	$('#boardwriteCmt').on('click', function() {
		var comment_cont = $('#comment_cont').val();
		console.log(comment_cont);
		if(!comment_cont) {
			alert("내용을 입력하세요");
			return false;
		} else {
			return location.reload();
		}
		});

	$('#addComment').on('submit', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		/* alert('댓글 추가클릭') */
		$.ajax({
			url  :  '/comment?cmd=ADDCOMMENT&menu_id=${ param.menu_id}&nowpage=${ param.nowpage }&pagecount=${ param.pagecount}',
			data :  $(this).serialize(),
			type : 'POST' ,
			success : function(result) {
				$("#comment_cont").val("");
				getCommentList();
			},
			error : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus);	
			}
				
				
		});
	});
	
   	function deleteComment(){
   		var comment_idx = $(this).attr("data-del");
   		var sendData = {"comment_idx": comment_idx}
  		$.ajax({
			url  :  '/ajaxdeletecomment',
			data :  sendData,
			type : 'POST' ,
			success : function(result) {
				console.log(result);
				document.location.reload();
			},
			error : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus);	
			}    
 		});
 	};  
	
 	function updateComment(){
 		
  		$.ajax({
			url  :  '/ajaxupdatecomment',
			data :  sendData,
			type : 'POST' ,
			success : function(result) {
				console.log(result);
				document.location.reload();
			},
			error : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus);	
			}    
 		});
 	}
	
/*'/comment?cmd=DELETECOMMENT&idx=' + clresult[index].comment.comment_idx  */
/*    	$(document).on('click', '.deleteComment', function(e) {
		e.preventDefault();
		e.stopPropagation(); 
		alert('댓글 삭제클릭');
		var $this = $(this);
  		$.ajax({
			url  :  '/ajaxdeletcomment',
			data :  $('.deleteComment').serialize(),
			type : 'POST' ,
			success : function(result) {
				console.log(result)
				//result = checkFunc();
				//$(#deleteComment1).parents("tr").remove();
				document.location.reload();
			},
			error : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus);	
			}    
 		});
 	});   */
	

	
 	function getCommentList(){
	$.ajax({
		url  : '/ajaxcommentlist?&idx=${ param.idx}&comment_nowpage=${ param.nowpage }&comment_pagecount=${ param.pagecount}',
		dataType : "json",
		type : 'GET',
		cache: false,
		success : function(clresult) {
				console.log(clresult);
	           var tag = "";
	           var cCnt = clresult.length;			            
	            //if(clresult.length > 0){
	                
<%--	                $.each(clresult, function(index,items){
		                var items = [];
		                var comment_writer = [];
		                var disable = '';
		                var loginid = '<%=(String)session.getAttribute("loginid")%>';
		                alert("loginid:" + loginid); --%>
		               // var jsonStr = JSON.stringify(${loginid});
		                //comment_writer = clresult[index].comment.comment_writer;
		                
		                //alert(clresult[index].comment.comment_writer)
		                //items.push("<tr>");
						
						//items.push('<li class="media mb-2"><img src="/resources/images/kirby1.jpg" width="50" height="50" class="mr-3 rounded-circle"><div class="media-body"><div class="row"><div class="col-md-4"><h6>' + clresult[index].comment.comment_writer + '</h6></div><div class="col-md-8"><div class="text-right text-secondary"><time class="comment-date">' + clresult[index].comment.comment_regdate + '</time>| <a href="#!">삭제</a>| <a href="#!">수정</a>| <a href="#!">답글</a></div></div></div><p>'+ clresult[index].comment.comment_cont +'</p></div></li>');
						
						//items.push('<li class="media mb-2"><img src="/resources/images/kirby1.jpg" width="50" height="50" class="mr-3 rounded-circle">');
						//items.push('<div class="media-body"><div class="row"><div class="col-md-4"><h6>' + clresult[index].comment.comment_writer + '</h6>');
						//items.push('</div><div class="col-md-8"><div class="text-right text-secondary"><time class="comment-date">' + clresult[index].comment.comment_regdate + '</time>');
						//items.push('| <a href="#!">삭제</a>| <a href="#!">수정</a>| <a href="#!">답글</a></div></div></div><p>'+ clresult[index].comment.comment_cont +'</p></div></li>');
						
//이벤트 핸들러						
						//items.push("<td>" + clresult[index].comment.comment_cont + "</td>");

						//items.push("<td>" + clresult[index].comment.comment_regdate + "</td>"); 
						
						//items.push("<td><input type='button' class='deleteComment' value='삭제하기' /></td>");
						
 						//if(loginid == comment_writer[index]){
        				//{disable=" disabled"}   
						//} 
        				
						//items.push("<td><form class='updateComment' name='updateComment' method='POST'><input type='hidden' name='comment_idx' value='" + clresult[index].comment.comment_idx + "' /><input type='submit' class='boardcommentupdatebutton' value='수정하기' /></form></td>");
						
/*  						items.push("<td><input type = button class='updateComment' " + disable + " data-idx= '"+clresult[index].comment.comment_idx+"' value= '수정하기'></td>");
						
						items.push("<td><input type = button class='deleteComment' " + disable + " data-del= '"+clresult[index].comment.comment_idx+"' value= '삭제하기'></td>"); 
						
						//items.push("<td><form class='.deleteComment' method='POST'><input type='hidden' name='comment_idx' value='" + clresult[index].comment.comment_idx + "' /><input type='hidden' name='menu_id' value='${boardVo.menu_id}' /><input type='hidden' name='nowpage' value='${param.nowpage}' /><input type='hidden' name='pagecount' value='${param.pagecount}' /><input type='hidden' name='xxxx' id='xxxx' value='xxxx' /><input type='submit' class='deleteComment' id='deleteComment"+ clresult[index].comment.comment_idx +"' value='삭제하기' /></form></td>");
						*/
						/* $("<ul class='list-unstyled mt-4'>" {
							html : items
						}).appendTo("#comment");  */
						
						//alert(comment_writer);
						//console.log(comment_writer);
						//console.log($.inArray(loginid, comment_writer) >= 0);
						//$("input:button.deleteComment").on('click',deleteComment) 
						//$("input:button.updateComment").on('click',updateComment)
						
	                //})
	                
/*    							$.ajax({
						url  : '/comment?cmd=COMMENTPAGING&totalcount=' + clresult[0].comment.totalcount + '&comment_nowpage=${ param.nowpage }&comment_pagecount=${ param.pagecount}',
						type : 'GET',
						success : function(presult) {
							alert("성공");
							console.log(presult);
						},
						error : function(xhr) {
							alert(xhr.status + ':' + xhr.textStatus);
						} 
					}); */   

					
/* 	            } else {
	                
	            	tag += "<div>";
	            	tag += "<div><td><h6><strong>등록된 댓글이 없습니다.</strong></h6></td>";
	            	tag += "</div>";
	            	$('#commenttable').append(tag);
				} */
	            
        },
		error : function(xhr) {
			alert(xhr.status + ':' + xhr.textStatus);
		}
	});
};
   
   function updateComment() {
	   
	   var commentsview = "";
	   
		commentsview += '<div id="uccomment_idx"' + clresult[index].comment.comment_idx + '">';
		commentsview += '<strong>';
		commentsview += '작성자: ' + comment_writer;
		commentsview += '</strong>$nbsp;$nbsp;$nbsp;$nbsp;';
		commentsview += '작성 날짜: ' + comment_regdate;
		commentsview += '<br/><p>';
		commentsview += '댓글 내용: $nbsp;$nbsp;$nbsp;';
		commentsview += '<textarea class="form-control" id="reply_edit_content">';
		commentsview += comment_cont;
		commentsview += '</textarea>';
		commentsview += '</p>';
		commentsview += '<br/>';
		commentsview += '<button type="button" class="btn btn-outline-success"';
		commentsview += 'onclick="updateBtn(' + comment_idx + ',\'' + comment_writer + '\')">댓글작성</button>';
		commentsview += '<button type="button" class="btn btn-outline-success" onclick="getCommentList()">';
		commentsview += '취소';
		commentsview += '</button>';
		commentsview += '</div>';
		commentsview += '<br/>';
		
		$('#comment_idx' + comment_idx).replaceWith(commentsview);
		$('#comment_idx' + comment_idx + '#comment_cont').focus();
	   
   };

});

</script>
</head>
<body>

</body>
</html>