package member.base;

import member.impl.MemberActionJoin;
import member.impl.MemberActionLOGIN;
import member.impl.MemberActionLOGINOUT;
import member.impl.MemberActionList;

public class ActionFactory {
	public Action getAction(String command) {
		Action action = null;
		
		switch(command) {
		
		case "ADMINLIST":
			action = new MemberActionList();
			break;
			
		case "LOGIN":
			action = new MemberActionLOGIN();
			break;
			
		case "LOGOUT":
			action = new MemberActionLOGINOUT();
			break;
			
		case "JOIN":
			action = new MemberActionJoin();
			break;
		}
		
		return action;
		
	}
}
