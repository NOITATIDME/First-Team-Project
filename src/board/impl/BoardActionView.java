package board.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.base.Action;
import board.dao.BoardDao;
import board.dao.CommentDao;
import board.vo.BoardVo;
import board.vo.CommentVo;
import board.vo.PageVo;

public class BoardActionView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		int           idx        =  Integer.parseInt(request.getParameter("idx"));
		String        menu_id    =  request.getParameter("menu_id"); 
		int           nowpage    =  Integer.parseInt(request.getParameter("nowpage"));
		int           pagecount  =  Integer.parseInt(request.getParameter("pagecount"));
		int           comment_nowpage    =  Integer.parseInt(request.getParameter("nowpage"));
		int           comment_pagecount  =  Integer.parseInt(request.getParameter("pagecount"));
		String        comment_cont = request.getParameter("comment_cont");
		String        loginid           = request.getParameter("cid");
		System.out.println(loginid);
				
		System.out.println("idx: " + idx);
		request.setAttribute("menu_id",   menu_id);
		request.setAttribute("nowpage",   nowpage);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("comment_nowpage",   comment_nowpage);
		request.setAttribute("comment_pagecount", comment_pagecount);
		request.setAttribute("comment_cont", comment_cont);
		System.out.println("BoardActionView: " + nowpage + "," + pagecount);
		// 게시물 내용조회
		System.out.println("nowpage: " + nowpage);
		BoardDao  boardDao  = new BoardDao();
		BoardVo   boardVo   = boardDao.getView( idx ); 
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("newLineChar", "\n");
		request.setAttribute("loginid", loginid);
		
		// 게시물 댓글 페이징 조회
		CommentDao commentDao = new CommentDao();
		List<CommentVo> commentList = commentDao.getBoardCommentList(idx, comment_nowpage, comment_pagecount); // 조회된 현재 페이지 의 data 
		int  comment_totalcount = 0;
		request.setAttribute("loginid", loginid);
		if ( commentList != null && commentList.size() != 0 ) {
			comment_totalcount = commentList.get(0).getTotalcount();  // 전체자료수
//		     nowpage    = nowpage - 1;  // 전체자료수 // 페이지 불러올 떄 nowpage가 0으로 되어 페이지가 보이지 않아서 주석 처리함
		     System.out.println("BoardActionView(comment_totalcount):" + comment_totalcount);
		     System.out.println("BoardActionView(comment_nowpage):" + comment_nowpage);
		} else {
			System.out.println("commentList를 찾을 수 없음");
			
			}
			
		System.out.println("BoardActionView(commentList):" + commentList);
		request.setAttribute("commentList", commentList);
		
		// paging 관련변수 처리		
		PageVo  pageVo = new PageVo(comment_nowpage, comment_pagecount, comment_totalcount);
		request.setAttribute("pageVo", pageVo);
		System.out.println("pageVo: " + pageVo);
		
		// 메뉴 아이디 받기
//		request.setAttribute("boardVo", boardVo);
//		boardVo.setMenu_id(menu_id);
	    		
		
		// 페이지 이동
		String  path  = "/view/board/boardview.jsp";
		request.getRequestDispatcher(path).forward(request, response);
//		response.sendRedirect("/view/board/boardview.jsp");
		System.out.println("BoardActionView(BoardVo): " + boardVo);

	}

}
