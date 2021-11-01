package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.BoardDao;
import board.vo.BoardVo;

public class BoardActionUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		int    idx = Integer.parseInt(request.getParameter("idx"));
		// String menu_id = request.getParameter("menu_id");
		String nowpage     =  request.getParameter("nowpage");
		String pagecount   =  request.getParameter("pagecount");
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 수정할 게시물 정보
		BoardDao     boardDao  =  new BoardDao();
		BoardVo      boardVo   =  boardDao.getView(idx);
		request.setAttribute("boardVo", boardVo);
		
		System.out.println("BoardActionUpdateForm(boardVo): " + boardVo);
		
		// 페이지 이동
		String  path = "/view/board/boardupdate.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
