package member.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.base.Action;

public class MemberActionLOGINOUT implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
	    session.invalidate(); // 모든 session변수 초기화
	    response.sendRedirect("/view/login/login.jsp?menu_id=MENU01&nowpage=1&pagecount=10");

	}

}
