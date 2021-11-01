package survey.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.base.Action;
import survey.dao.SurveyDao;
import survey.vo.SurveyVo;

public class SurveyActionReserveForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  hair_id   = request.getParameter("hair_id");
		String  cid       = request.getParameter("cid");
		System.out.println("hair_id:" + hair_id);
		System.out.println("cid:" + cid);
		
		SurveyDao  surveyDao = new SurveyDao();
		SurveyVo   surveyVo  = surveyDao.getHair(hair_id);
		
		System.out.println("SurveyActionReserveForm surveyVo:" + surveyVo);
		request.setAttribute("surveyVo", surveyVo);
		request.setAttribute("cid", cid);

		String path = "/view/survey/hairreserve.jsp";
		request.getRequestDispatcher(path).forward(request, response);	
		
	}

}
