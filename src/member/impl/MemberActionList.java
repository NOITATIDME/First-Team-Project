package member.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.base.Action;
import member.dao.MemberDao;
import member.vo.MemberPageVo;
import member.vo.MemberVo;

public class MemberActionList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		     System.out.println("totalcount:" + totalcount);
		     System.out.println("nowpage:" + nowpage);
		}
		
		//System.out.println( "BoardActionList boardList:" +  boardList );
		request.setAttribute("memberList", memberList);
		
		// paging 관련변수 처리		
	    
		MemberPageVo  memberpageVo = new MemberPageVo(nowpage, pagecount, totalcount);
		
		request.setAttribute("memberpageVo", memberpageVo);
		System.out.println("memberpageVo:" + memberpageVo);
		
		String  path  = "/view/board/boardmemberlist.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println("memberList: " + memberList);
	}

}
