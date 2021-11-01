package board.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.BoardDao;
import board.vo.BoardVo;
import board.vo.PageVo;

public class BoardActionList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
		// 넘어온 정보
		String        menu_id    =  request.getParameter("menu_id"); 		
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		int pagecount = Integer.parseInt(request.getParameter("pagecount"));
		String loginid  = request.getParameter("loginid");
		request.setAttribute("loginid", loginid);
		System.out.println(loginid);
		// BoardlIst - 게시물 목록
		BoardDao      boardDao  = new BoardDao();
		List<BoardVo> boardList = boardDao.getBoardPagingList(
				menu_id, nowpage, pagecount ); // 조회된 현재 페이지 의 data 
		int  totalcount = 0;
		if ( boardList != null && boardList.size() != 0 ) {
		     totalcount = boardList.get(0).getTotalcount();  // 전체자료수
		     //nowpage    = nowpage - 1;  // 전체자료수
		     System.out.println("totalcount:" + totalcount);
		     System.out.println("nowpage:" + nowpage);
		} else {
			System.out.println( "boardList가 없음" +  boardList );
			
		}
		   	
		System.out.println( "BoardActionList boardList:" +  boardList );
		request.setAttribute("boardList", boardList);

		// 페이지 정보 저장
//		System.out.println("BoardActionList(nowpage): " + nowpage);
//		PageVo pageVo = new PageVo(nowpage, pagecount, 0);
//		request.setAttribute("pageVo", pageVo);
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("pagecount", pagecount);
		
		// paging 관련변수 처리		
		PageVo  pageVo = new PageVo(nowpage, pagecount, totalcount);
		request.setAttribute("pageVo", pageVo);
		
//		System.out.println("BoardActionList:" + pageVo);
		
		// 메뉴 아이디 받기
		BoardVo boardVo = new BoardVo();
		request.setAttribute("boardVo", boardVo);
		boardVo.setMenu_id(menu_id);
	    		
		
		// 페이지 이동
		String  path  = "/view/board/boardlist.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println("BoardActionList: " + boardVo);
	}

}
