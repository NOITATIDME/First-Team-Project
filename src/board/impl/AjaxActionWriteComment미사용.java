package board.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.base.Action;
import board.dao.CommentDao;
import board.vo.CommentVo;

public class AjaxActionWriteComment미사용 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		CommentDao  commentDao = new CommentDao();		
//		CommentVo commentVo = new CommentVo();
//		
//		String comment_hboard = request.getParameter("comment_hboard");
//		String comment_writer = request.getParameter("comment_writer");
//        String comment_cont = request.getParameter("comment_cont");
//        
//        String comment_bnum = request.getParameter("comment_bnum");
//        String comment_lvl  = request.getParameter("comment_lvl");
//        String comment_step = request.getParameter("comment_step");
//        String comment_nref = request.getParameter("comment_nref");
//        
////        System.out.println("comment_hboard: " + comment_hboard);
////        System.out.println("comment_bnum: " + comment_bnum);
////        System.out.println("comment_lvl: " + comment_lvl);
////        System.out.println("comment_step: " + comment_step);
////        System.out.println("comment_nref: " + comment_nref);
//        		
//        commentVo.setComment_hboard(Integer.parseInt(comment_hboard));
//        commentVo.setComment_writer(comment_writer);
//        commentVo.setComment_cont(comment_cont);
//        
//        commentVo.setComment_bnum(Integer.parseInt(comment_bnum));
//        commentVo.setComment_lvl(Integer.parseInt(comment_lvl));
//        commentVo.setComment_step(Integer.parseInt(comment_step));
//        commentVo.setComment_nref(Integer.parseInt(comment_nref));
//        
//        System.out.println("AjaxActionWriteComment CommentVo: " + commentVo);
//        
//        // 페이지
////        int nowpage = Integer.parseInt(request.getParameter("nowpage"));
////        int pagecount = Integer.parseInt(request.getParameter("pagecount"));
////        String nowpage = request.getParameter("nowpage");
////        String pagecount = request.getParameter("pagecount");
////        request.setAttribute("nowpage", nowpage);
////        request.setAttribute("pagecount", pagecount);
//        
//		
////        commentVo = new CommentVo(0, comment_hboard, comment_writer,
////    			"", comment_cont, comment_bnum, comment_lvl, comment_step,
////    			comment_nref, 0, 0);
//        commentDao.commentInsert(commentVo);
//        
//		request.setAttribute("commentVo", commentVo);
//		System.out.println("AjaxActionWriteComment CommentVo: " + commentVo);
//		
//		int           idx        =  Integer.parseInt(request.getParameter("idx"));
//		String        menu_id    =  request.getParameter("menu_id"); 
//		request.setAttribute("idx", idx);
//		request.setAttribute("menu_id", menu_id);
		

		
		
//		String path = "/board?cmd=VIEW&idx=" + idx + "&menu_id=" + menu_id;
//		request.getRequestDispatcher(path).forward(request, response);
//		Action action = new BoardActionView();
//		action.execute(request, response);

	}

}
