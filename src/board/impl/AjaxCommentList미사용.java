package board.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import board.base.Action;
import board.dao.CommentDao;
import board.vo.CommentVo;
import board.vo.PageVo;

public class AjaxCommentList미사용 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		CommentDao commentDao = new CommentDao();
//		
//		int           idx        =  Integer.parseInt(request.getParameter("idx"));
////		String        menu_id    =  request.getParameter("menu_id");
////		int           comment_nowpage    =  1;
////		int           comment_pagecount  = 10;
//		int           comment_nowpage    =  Integer.parseInt(request.getParameter("comment_nowpage"));
//		int           comment_pagecount  = Integer.parseInt( request.getParameter("comment_pagecount"));
//		
//		// 게시물 댓글 페이징 조회
//		List<CommentVo> commentList = commentDao.getBoardCommentList(idx, comment_nowpage, comment_pagecount); // 조회된 현재 페이지 의 data 
//		int  comment_totalcount = 0;
//		
//		if ( commentList != null && commentList.size() != 0 ) {
////		if ( commentVo != null) {
//			comment_totalcount = commentList.get(0).getTotalcount();  // 전체자료수
////		     nowpage    = nowpage - 1;  // 전체자료수 // 페이지 불러올 떄 nowpage가 0으로 되어 페이지가 보이지 않아서 주석 처리함
//			System.out.println("AjaxCommentList(comment_totalcount):" + comment_totalcount);
//			System.out.println("AjaxCommentList(comment_nowpage):" + comment_nowpage);
//		} else {
//			System.out.println("commentList를 찾을 수 없음");
////			CommentVo commentVo = commentDao.getBoardCommentView(idx);
////			request.setAttribute("commentVo", commentVo);
////			System.out.println("commentVo: " + commentVo);
////			if( commentVo != null) {
////				String  path  = "/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10";
////				request.getRequestDispatcher(path).include(request, response);
////				
////			}
//		}
//		
//		System.out.println("AjaxCommentList(commentList):" + commentList);
//		request.setAttribute("commentList", commentList);
//		  
//		  response.setContentType("application/json;charset=utf-8"); 
//		  PrintWriter out = response.getWriter(); 
//		  JSONArray cljArr = new JSONArray(); 
//		  if(commentList.size() > 0) {
//			  for (int i = 0; i <commentList.size(); i++) {
//				  CommentVo   vo   = commentList.get(i);
//				  JSONObject  cldata = new JSONObject();
//				  HashMap<String, Object> clhashmap = new HashMap<>();
//				  
//				  clhashmap.put("comment_rn", vo.getComment_rn());
//				  clhashmap.put("comment_idx", vo.getComment_idx());
//				  clhashmap.put("comment_hboard", vo.getComment_hboard());
//				  clhashmap.put("comment_writer", vo.getComment_writer());
//				  clhashmap.put("comment_regdate", vo.getComment_regdate());
//				  clhashmap.put("comment_cont", vo.getComment_cont());
//				  clhashmap.put("comment_bnum", vo.getComment_bnum());
//				  clhashmap.put("comment_lvl", vo.getComment_lvl());
//				  clhashmap.put("comment_step", vo.getComment_step());
//				  clhashmap.put("comment_nref", vo.getComment_nref());
//				  clhashmap.put("comment_delnum", vo.getComment_delnum());
//				  clhashmap.put("totalcount", vo.getTotalcount());
//				  
//				  cldata.put("comment", clhashmap );
//				  
//				  cljArr.add(i, cldata);
//			  }
//		  }
//		  
//		  System.out.println(cljArr);
//		  out.print(cljArr);
//		  out.flush();
//		  out.close();
		 
		
	}

}
