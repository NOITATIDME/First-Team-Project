package board.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.base.Action;
import board.dao.BoardDao;
import board.vo.BoardVo;

public class BoardActionWrite implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보들
		request.setCharacterEncoding("utf-8");
		String menu_id = request.getParameter("menu_id");
		String title = request.getParameter("title");
		String cont  = request.getParameter("cont");
		
		int bnum  = Integer.parseInt(request.getParameter("bnum"));
		int lvl  = Integer.parseInt(request.getParameter("lvl"));
		int step  = Integer.parseInt(request.getParameter("step"));
		int nref  = Integer.parseInt(request.getParameter("nref"));
		
		int nowpage  = Integer.parseInt(request.getParameter("nowpage"));
		int pagecount  = Integer.parseInt(request.getParameter("pagecount"));
		
		// nowpage, pagecount 값 설정
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// 세션을 활용하여 아이디를 구함
		HttpSession session = request.getSession();
		String writer = (String) session.getAttribute("loginid");
		System.out.println(writer);
		
		System.out.println("BoardActionWrite(writer): " + writer);

		// 생성자에 정보 저장
		BoardVo boardVo = new BoardVo(0, menu_id, title, cont, writer, "", 0, bnum, lvl, step, nref, 0);
		
		System.out.println("BoardActionWrite(boardVo): " + boardVo);
		
		// 글쓰기 수행
		BoardDao  boardDao = new BoardDao();
		boardDao.boardInsert( boardVo ); 
		
		// 게시판 조회로 이동 (페이지가 보이지 않아서 고정된 값으로 사용)
//		String    path     = "/board?cmd=LIST&menu_id=" + menu_id + "&nowpage=1&pagecount=10";
//		request.getRequestDispatcher(path).forward(request, response);
		Action action = new BoardActionList();
		action.execute(request, response);

	}

}
