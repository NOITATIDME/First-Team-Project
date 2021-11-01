package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.base.Action;
import member.base.ActionFactory;

@WebServlet("/member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestFunc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestFunc(request, response);
	}

	private void requestFunc(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// /member?cmd=LIST&menu_id=MENU01
		request.setCharacterEncoding("UTF-8"); // 한글처리
		String    command =  request.getParameter("cmd");
		System.out.println(command);
		ActionFactory   fac     =  new ActionFactory();
		Action          action  =  fac.getAction( command );
		System.out.println(action);
		action.execute(request, response);
		}
	
}
