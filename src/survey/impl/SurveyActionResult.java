package survey.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.base.Action;
import survey.dao.SurveyDao;
import survey.vo.SurveyVo;

public class SurveyActionResult implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 넘어오는 정보 : POST
		// face 얼굴형번호
		request.setCharacterEncoding("UTF-8");
		String face = request.getParameter("face");
		System.out.println("face:" + face);
		String cid  = request.getParameter("cid");
		
		// face 얼굴이름 조회
		SurveyDao    surveyDao  =  new SurveyDao();
		List<SurveyVo> hairList =  surveyDao.getHairList( face );
		
		System.out.println("hairList:" + hairList);
		request.setAttribute("hairList", hairList);
		request.setAttribute("cid", cid);
		
		// 선택된 헤어목록조회로 이동
		String path = "/view/survey/result.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		

	}

}
