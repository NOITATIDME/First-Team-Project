package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.CommentDao;
import board.vo.BoardVo;

public class BoardActionDeleteComment implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		int    idx = Integer.parseInt(request.getParameter("idx"));
		int    comment_idx = Integer.parseInt(request.getParameter("comment_idx"));
		String menu_id     =  request.getParameter("menu_id");
		String nowpage     =  request.getParameter("nowpage");
		String pagecount   =  request.getParameter("pagecount");
		
		// 속성 값 설정
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 메뉴 아이디 받기
		BoardVo boardVo = new BoardVo();
		request.setAttribute("boardVo", boardVo);
		boardVo.setMenu_id(menu_id);
		boardVo.setIdx(idx);
		
		// 삭제
		CommentDao commentDao = new CommentDao();
		commentDao.commentDelete(comment_idx);
		
		// 목록 이동
		Action   action   = new BoardActionView();
		action.execute(request, response);
		
	}

}
