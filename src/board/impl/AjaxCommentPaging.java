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
import board.vo.PageVo;

public class AjaxCommentPaging implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int           comment_nowpage    =  Integer.parseInt(request.getParameter("comment_nowpage"));
		int           comment_pagecount  = Integer.parseInt( request.getParameter("comment_pagecount"));
		int           comment_totalcount  = Integer.parseInt( request.getParameter("totalcount"));
		System.out.println("AjaxCommentPaging: " + comment_totalcount);
		
		  // paging 관련변수 처리		
		  PageVo  pageVo = new PageVo(comment_nowpage, comment_pagecount, comment_totalcount);
		  request.setAttribute("pageVo", pageVo);
		  System.out.println("AjaxCommentPaging: " + pageVo);
		  PrintWriter out = response.getWriter(); 
		  JSONArray jArrpageVo = new JSONArray();
		  JSONObject pagedata = new JSONObject();
		  HashMap<String, Object> pagehashmap = new HashMap<>();
		  pagehashmap.put("pageVo", pageVo);
		  pagedata.put("pageVo", pagehashmap);
		  jArrpageVo.add(pagedata);
		  out.print(jArrpageVo);
		  
		  System.out.println(jArrpageVo);
	}

}
