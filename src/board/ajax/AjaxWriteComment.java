package board.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.CommentDao;
import board.vo.CommentVo;

@WebServlet("/ajaxwritecomment")
public class AjaxWriteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보 처리
		CommentDao  commentDao = new CommentDao();		
		CommentVo commentVo = new CommentVo();
		
		String comment_hboard = request.getParameter("comment_hboard");
		String comment_writer = request.getParameter("comment_writer");
        String comment_cont = request.getParameter("comment_cont");
        
        String comment_bnum = request.getParameter("comment_bnum");
        String comment_lvl  = request.getParameter("comment_lvl");
        String comment_step = request.getParameter("comment_step");
        String comment_nref = request.getParameter("comment_nref");
        		
        commentVo.setComment_hboard(Integer.parseInt(comment_hboard));
        commentVo.setComment_writer(comment_writer);
        commentVo.setComment_cont(comment_cont);
        
        commentVo.setComment_bnum(Integer.parseInt(comment_bnum));
        commentVo.setComment_lvl(Integer.parseInt(comment_lvl));
        commentVo.setComment_step(Integer.parseInt(comment_step));
        commentVo.setComment_nref(Integer.parseInt(comment_nref));
        
        System.out.println("AjaxActionWriteComment CommentVo: " + commentVo);
        
        commentDao.commentInsert(commentVo);
        
		request.setAttribute("commentVo", commentVo);
		System.out.println("AjaxActionWriteComment CommentVo: " + commentVo);
		
		// 내보내줄 정보처리
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
