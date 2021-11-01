package survey.base;

import survey.base.Action;
import survey.impl.SurveyActionDirectReserve;
import survey.impl.SurveyActionReserve;
import survey.impl.SurveyActionReserveForm;
import survey.impl.SurveyActionResult;

public class ActionFactory {
	
	// Action : 인터페이스 - 리턴타입
	public Action getAction(String command) {
		
		Action action = null;
		
		//?cmd=SURVEY
		switch(command) {
		case "RESULT" : 
			action = new SurveyActionResult();
		break;
		
		case "RESERVEFORM":
			action = new SurveyActionReserveForm();
		break;
		
		case "RESERVE" :
			action = new SurveyActionReserve();
		break;
		
		case "DIRECTRESERVE" :
			action = new SurveyActionDirectReserve();
			break;
		}
		
		return action;
	}
	
}
