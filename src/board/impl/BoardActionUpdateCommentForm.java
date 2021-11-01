package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.CommentDao;
import board.vo.CommentVo;

public class BoardActionUpdateCommentForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int   comment_idx       = Integer.parseInt(request.getParameter("comment_idx")); 
		String menu_id = request.getParameter("menu_id");
		int   nowpage      = Integer.parseInt(request.getParameter("nowpage")); 
		int   pagecount    = Integer.parseInt(request.getParameter("pagecount"));
		request.setAttribute("menu_id", menu_id);
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 수정할 게시물 정보
		CommentDao     commentDao  =  new CommentDao();
		CommentVo      commentVo   =  commentDao.getCommentView(comment_idx);
		request.setAttribute("commentVo", commentVo);
		System.out.println("BoardActionUpdateCommentForm(commentVo): " + commentVo);
		
		String path = "/view/board/boardcommentupdate.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
}
