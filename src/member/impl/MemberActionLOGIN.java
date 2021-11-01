package member.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.base.Action;
import member.dao.MemberDao;
import member.vo.MemberVo;

public class MemberActionLOGIN implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid  = request.getParameter("cid");
		String cpwd = request.getParameter("cpwd");

		String menu_id = request.getParameter("menu_id");
		String nowpage = request.getParameter("nowpage");
		String pagecount = request.getParameter("pagecount");

		HttpSession session = request.getSession(); 
		
		if( cid != null && !cid.equals("") ) {
			MemberDao memberDao = new MemberDao();
			String    passwd    = memberDao.getPwd(cid);
			String     cname    = memberDao.getName(cid);
			
			if( cpwd.equals(passwd) ) {
				MemberVo memberVo   = memberDao.getLogin(cid, cpwd);
				String loginid = memberVo.getCid();
				request.setAttribute("logind", loginid);
				session.setAttribute("loginid", loginid);
				session.setAttribute("cname", cname);

				String    path     = "/board?cmd=LIST&menu_id=" + menu_id 
						+ "&nowpage="   + nowpage 
						+ "&pagecount=" + pagecount 
						+ "&loginid=" + loginid;
				request.getRequestDispatcher(path).forward(request, response);
			} else {
				session.invalidate();
				
				String    path     = "/view/login/login_cancel.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				}
		} else {
			session.invalidate();
			
			String    path     = "/view/login/login_cancel.jsp";
			request.getRequestDispatcher(path).forward(request, response);
	}
		
//		System.out.println("loginid= " + loginid);
//		if( loginid != null && !loginid.equals("") ) {
//			
//			if( loginid.equals("Administer")) {
//				menu_id = "MENU01";
//				System.out.println("관리자 통과");
//				session.setAttribute("loginid", loginid);
//				
//				String    path     = "/member?cmd=ADMINLIST&menu_id=" + menu_id 
//						+ "&nowpage="   + nowpage 
//						+ "&pagecount=" + pagecount ;  
//				System.out.println("loginid= " + loginid);
//				request.getRequestDispatcher(path).forward(request, response);
//			} else {
//				session.setAttribute("loginid", loginid);
//
//				String    path     = "/board?cmd=LIST&menu_id=" + menu_id 
//						+ "&nowpage="   + nowpage 
//						+ "&pagecount=" + pagecount ;  
//				request.getRequestDispatcher(path).forward(request, response);
//			}
//		} else {
//				session.invalidate();
//				
//				String    path     = "index.jsp";
//				request.getRequestDispatcher(path).forward(request, response);
//		}
		
	}
}
