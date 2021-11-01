package board.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.base.Action;
import board.dao.CommentDao;
import board.vo.BoardVo;

public class AjaxActionDeleteComment implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보
		System.out.println("넘어와라");
//		int    idx = Integer.parseInt(request.getParameter("idx"));
		int    comment_idx = Integer.parseInt(request.getParameter("comment_idx"));
//		String menu_id     =  request.getParameter("menu_id");
//		String nowpage     =  request.getParameter("nowpage");
//		String pagecount   =  request.getParameter("pagecount");
		
		// 속성 값 설정
//		request.setAttribute("nowpage",   nowpage);
//		request.setAttribute("pagecount", pagecount);
		
		// 메뉴 아이디 받기
//		BoardVo boardVo = new BoardVo();
//		request.setAttribute("boardVo", boardVo);
//		boardVo.setMenu_id(menu_id);
//		boardVo.setIdx(idx);
		
		// 삭제
		CommentDao commentDao = new CommentDao();
		boolean result = commentDao.commentDelete(comment_idx);
		System.out.println("AjaxActionDeleteComment(IDX): " + comment_idx);
		PrintWriter out = response.getWriter(); 
		if(result) out.print("1");
//		JSONArray jArrremove = new JSONArray();
//		JSONObject removedata = new JSONObject();
//		HashMap<String, Object> removehashmap = new HashMap<>();
//		removehashmap.put("comment_idx", comment_idx);
//		removedata.put("comment_idx", comment_idx);
//		jArrremove.add(removedata);
//		out.print(jArrremove);
	}

}
