package member.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.base.Action;
import member.dao.MemberDao;
import member.vo.MemberVo;

public class MemberActionJoin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String	cid     = request.getParameter("cid");
		String	cpwd    = request.getParameter("cpwd");
		String	cname   = request.getParameter("cname");
		String	cbirth  = request.getParameter("cbirth");
		String	cemail  = request.getParameter("cemail");
		
		MemberVo vo 	= new MemberVo(cid, cpwd, cname, cbirth, cemail);
		System.out.println(vo);
		// 회원가입 수행
		MemberDao memberdao = new MemberDao();
		memberdao.memberInsert(vo);
		
		String  path  = "/view/login/login.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
