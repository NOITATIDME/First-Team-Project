package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.BoardDao;

public class BoardActionUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		String   menu_id   = request.getParameter("menu_id"); 
		int   idx       = Integer.parseInt(request.getParameter("idx")); 
		String   title     = request.getParameter("title"); 
		String   cont      = request.getParameter("cont");
		
		int   nowpage      = Integer.parseInt(request.getParameter("nowpage")); 
		int   pagecount    = Integer.parseInt(request.getParameter("pagecount"));
		
		// nowpage, pagecount 값 설정
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 수정
		BoardDao   boardDao = new BoardDao();
		boardDao.boardUpdate( idx, title, cont );
		
		// 페이지 이동
		String    path     = "/board?cmd=LIST&menu_id=" + menu_id 
				+ "&nowpage="   + nowpage 
				+ "&pagecount=" + pagecount ;  
	//	System.out.println("update:" + path);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
