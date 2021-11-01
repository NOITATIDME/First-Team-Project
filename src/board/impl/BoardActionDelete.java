package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.BoardDao;

public class BoardActionDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		int    idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage     =  request.getParameter("nowpage");
		String pagecount   =  request.getParameter("pagecount");
		
		// 속성 값 설정
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 삭제
		BoardDao boardDao = new BoardDao();
		boardDao.boardDelete(idx);
		
		// 목록 이동
		Action   action   = new BoardActionList();
		action.execute(request, response);
		
	}

}
