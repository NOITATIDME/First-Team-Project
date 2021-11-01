package member.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.vo.BoardVo;
import member.dao.MemberDao;
import member.vo.MemberVo;

@WebServlet("/ajaxmemberlist")
public class AjaxMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int           nowpage    =  Integer.parseInt(request.getParameter("nowpage"));
		int           pagecount  =  Integer.parseInt(request.getParameter("pagecount"));
		
		
		// MemberList - 게시물 목록
		MemberDao      memberDao  = new MemberDao();
		List<MemberVo> memberList = memberDao.getMemberPagingList(
				nowpage, pagecount ); // 조회된 현재 페이지 의 data 
		int  totalcount = 0;
		if ( memberList != null && memberList.size() != 0 ) {
		     totalcount = memberList.get(0).getTotalcount();  // 전체자료수
		     nowpage    = nowpage - 1;  // 전체자료수
		     System.out.println("AjaxMemberList(totalcount): " + totalcount);
		     System.out.println("AjaxMemberList(nowpage):" + nowpage);
		}
		
		  response.setContentType("application/json;charset=utf-8"); 
		  PrintWriter out = response.getWriter(); 
		  JSONArray mljArr = new JSONArray(); 
		  if(memberList.size() > 0) {
			  for (int i = 0; i <memberList.size(); i++) {
				  MemberVo   vo   = memberList.get(i);
				  JSONObject  mldata = new JSONObject();
				  HashMap<String, Object> mlhashmap = new HashMap<>();
				  
				  mlhashmap.put("rn", vo.getRn());
				  mlhashmap.put("cid", vo.getCid());
				  mlhashmap.put("cpwd", vo.getCpwd());
				  mlhashmap.put("cbirth", vo.getCbirth());
				  mlhashmap.put("cname", vo.getCname());
				  mlhashmap.put("cemail", vo.getCemail());
				  mlhashmap.put("cresult", vo.getCresult());
				  mlhashmap.put("resday", vo.getResday());
				  
				  mldata.put("member", mlhashmap );
				  
				  mljArr.add(i, mldata);
				  
			  }
		  }
		  
//		  HashMap<String, String> hairname = new HashMap<>();
//		  JSONObject  hairdata = new JSONObject();
//		  JSONArray hairjArr = new JSONArray(); 
//		  hairname.put("H1", "Pushed_Back_Long");
//		  hairname.put("H2", "Side_Parted_Short");
//		  hairname.put("H3", "Undercut");
//		  hairname.put("H4", "Fringe_Up");
//		  hairname.put("H5", "Crew_aka_Buzz_Cut");
//		  hairname.put("H6", "Undercut");
//		  hairname.put("H7", "Faux_Hawk");
//		  hairname.put("H8", "Slicked_Back_Side_Part");
//		  hairname.put("H9", "Side_Parted");
//		  hairname.put("H10", "Buzz_Cut");
//		  hairname.put("H11", "Fringe_Up");
//		  hairname.put("H12", "Side_Fringe");
//		  hairname.put("H13", "Fringe_Up");
//		  hairname.put("H14", "Side_Fringe");
//		  hairname.put("H15", "Side_Parted");
//		  hairname.put("H16", "Faux_Hawk_With_Shorter_Sides");
//		  hairname.put("H17", "Side_Fringe");
//		  hairname.put("H18", "Undercut");
//		  hairname.put("H19", "Quiff");
//		  hairname.put("H20", "Quiff");
//		  hairname.put("H21", "Long_Hair_Pushed_Back");
//		  hairname.put("H22", "Faux_Hawk");
//		  hairname.put("H23", "Side_Fringe");
//		  hairname.put("H24", "Long_Fringes");
//		  hairname.put("H25", "Side_Parted_Long");
//		  hairname.put("H26", "Pushed_Back");
//		  hairname.put("H27", "Unercut");
//		  
//		  hairdata.put("hairname", hairname );
//		  
//		  hairjArr.add(hairdata);

		  //System.out.println(hairjArr);
		  System.out.println(mljArr);
		  //out.print(hairjArr);
		  out.print(mljArr);
		  out.flush();
		  out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
