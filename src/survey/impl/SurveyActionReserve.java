package survey.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.base.Action;
import survey.dao.SurveyDao;

public class SurveyActionReserve implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /survey?cmd=RESERVE
		// 		cid = 
		//		hair_name =
		//		resday =
		
		String		  cid = request.getParameter("cid");
		String	hair_name = request.getParameter("hair_name");
		String	  resdate = request.getParameter("reservedate");
		String	  restime = request.getParameter("reservetime");
		String     resday = resdate + " " + restime;
		System.out.println(cid);
		System.out.println(hair_name);
		System.out.println(resdate);
		System.out.println(restime);
		System.out.println(resday);
		SurveyDao 	surveyDao = new SurveyDao();
		surveyDao.reserveHair( cid, hair_name, resday );
		
		System.out.println("surveyDao:" + surveyDao);
		String 	path 	=  "/board?cmd=LIST&menu_id=MENU01&nowpage=1&pagecount=10";
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
