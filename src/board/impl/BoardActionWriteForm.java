package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.vo.BoardVo;

public class BoardActionWriteForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		///board?cmd=WRITEFORM&menu_id=${boardVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagecount=${pagecount}
		// 넘어오는 정보
		String menu_id      = request.getParameter("menu_id");
		String  bnum        = request.getParameter("bnum");
		String  lvl         = request.getParameter("lvl");
		String  step        = request.getParameter("step");
		String  nref        = request.getParameter("nref");
		
		// 페이징 처리
		int    nowpage = Integer.parseInt(request.getParameter("nowpage"));
		int    pagecount = Integer.parseInt(request.getParameter("pagecount"));
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 넘어온 menu_id 를 받는다, boardVo : bnum, lvl, step, nref
		BoardVo  boardVo  =  new  BoardVo();
		boardVo.setMenu_id(menu_id);
		boardVo.setBnum( Integer.parseInt( bnum ) );
		boardVo.setLvl( Integer.parseInt( lvl) );
		boardVo.setStep( Integer.parseInt( step) );
		boardVo.setNref( Integer.parseInt(nref)) ;
		request.setAttribute("boardVo", boardVo);
		
		// 페이지 이동
		String path = "/view/board/boardwrite.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println("BoardActionWriteForm: " + boardVo);
	}

}
