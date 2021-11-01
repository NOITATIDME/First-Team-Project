package board.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.base.Action;
import board.dao.BoardDao;
import board.vo.BoardVo;
import board.vo.PageVo;

public class AjaxBoardList미사용 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// 넘어온 정보
//		String        menu_id    =  request.getParameter("menu_id"); 		
//		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
//		int pagecount = Integer.parseInt(request.getParameter("pagecount"));
////		String        menu_id    =  "MENU01"; 		
////		int nowpage = 1;
////		int pagecount = 10;
//		
//		// BoardlIst - 게시물 목록
//		BoardDao      boardDao  = new BoardDao();
//		List<BoardVo> boardList = boardDao.getBoardPagingList(
//				menu_id, nowpage, pagecount ); // 조회된 현재 페이지 의 data 
//		int  totalcount = 0;
//		if ( boardList != null && boardList.size() != 0 ) {
//		     totalcount = boardList.get(0).getTotalcount();  // 전체자료수
////		     nowpage    = nowpage - 1;  // 전체자료수 // 페이지 불러올 떄 nowpage가 0으로 되어 페이지가 보이지 않아서 주석 처리함
//		     System.out.println("AjaxBoardList(totalcount):" + totalcount);
//		     System.out.println("AjaxBoardList(nowpage):" + nowpage);
//		} else {
//			System.out.println( "boardList가 없음" +  boardList );
//			
//		}
//		   	
//		System.out.println( "AjaxBoardList boardList:" +  boardList );
//		request.setAttribute("boardList", boardList);
//
//		// 페이지 정보 저장
//		request.setAttribute("nowpage", nowpage);
//		request.setAttribute("pagecount", pagecount);
//		
//		// paging 관련변수 처리		
//		PageVo pageVo = new PageVo(nowpage, pagecount, totalcount);
//		request.setAttribute("pageVo", pageVo);
//		
//		System.out.println("AjaxBoardList(pageVo):" + pageVo);
//		
//		// 메뉴 아이디 받기
//		BoardVo boardVo = new BoardVo();
//		request.setAttribute("boardVo", boardVo);
//		boardVo.setMenu_id(menu_id);
//		
//		  response.setContentType("application/json;charset=utf-8"); 
//		  PrintWriter out = response.getWriter(); 
//		  JSONArray bljArr = new JSONArray(); 
//		  if(boardList.size() > 0) {
//			  for (int i = 0; i <boardList.size(); i++) {
//				  BoardVo   vo   = boardList.get(i);
//				  JSONObject  bldata = new JSONObject();
//				  HashMap<String, Object> blhashmap = new HashMap<>();
//				  
//				  blhashmap.put("idx", vo.getIdx());
//				  blhashmap.put("menu_id", vo.getMenu_id());
//				  blhashmap.put("title", vo.getTitle());
//				  blhashmap.put("cont", vo.getCont());
//				  blhashmap.put("writer", vo.getWriter());
//				  blhashmap.put("regdate", vo.getRegdate());
//				  blhashmap.put("cname", vo.getCname());
//				  blhashmap.put("readcount", vo.getReadcount());
//				  blhashmap.put("bnum", vo.getBnum());
//				  blhashmap.put("lvl", vo.getLvl());
//				  blhashmap.put("step", vo.getStep());
//				  blhashmap.put("nref", vo.getNref());
//				  blhashmap.put("delnum", vo.getDelnum());
//				  
//				  bldata.put("board", blhashmap );
//				  
//				  bljArr.add(i, bldata);
//				  
//			  }
//		  }
//		  System.out.println(bljArr);
//		  out.print(bljArr);
//		  out.flush();
//		  out.close();
//		
	}

}
