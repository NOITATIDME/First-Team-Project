package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.CommentDao;

public class BoardActionUpdateComment implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		String   menu_id        = request.getParameter("menu_id"); 
		int   comment_idx       = Integer.parseInt(request.getParameter("comment_idx")); 
		int   comment_hboard    = Integer.parseInt(request.getParameter("comment_hboard")); 
		String   comment_cont   = request.getParameter("comment_cont");
		
		int   nowpage      = Integer.parseInt(request.getParameter("nowpage")); 
		int   pagecount    = Integer.parseInt(request.getParameter("pagecount"));
		
		// nowpage, pagecount 값 설정
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("comment_hboard", comment_hboard);
		
		// 수정
		CommentDao   commentDao = new CommentDao();
		commentDao.commentUpdate( comment_idx, comment_hboard, comment_cont );
		
		// 페이지 이동
		String    path     = "/board?cmd=VIEW&idx=" + comment_hboard + "&menu_id=" + menu_id 
				+ "&nowpage="   + nowpage 
				+ "&pagecount=" + pagecount ;  
	//	System.out.println("update:" + path);
		request.getRequestDispatcher(path).forward(request, response);

	}

}
