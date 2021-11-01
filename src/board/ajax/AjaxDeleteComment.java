package board.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.dao.CommentDao;
import board.vo.BoardVo;
import board.vo.CommentVo;

@WebServlet("/ajaxdeletecomment")
public class AjaxDeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 정보 처리
		response.setCharacterEncoding("utf-8");
		int    comment_idx = Integer.parseInt(request.getParameter("comment_idx"));
		System.out.println("AjaxDeletComment: " + comment_idx);
		
		// 내보내줄 정보처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		
		// 삭제
		CommentDao commentDao = new CommentDao();
		boolean result = commentDao.commentDelete(comment_idx);
		System.out.println("AjaxActionDeleteComment(IDX): " + comment_idx);
		PrintWriter out1 = response.getWriter(); 
		if(result) out1.print("1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
