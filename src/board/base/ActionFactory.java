package board.base;

import board.impl.AjaxActionWriteComment미사용;
import board.impl.AjaxBoardList미사용;
import board.impl.AjaxCommentList미사용;
import board.impl.BoardActionDelete;
import board.impl.BoardActionDeleteComment;
import board.impl.BoardActionList;
import board.impl.BoardActionUpdate;
import board.impl.BoardActionUpdateComment;
import board.impl.BoardActionUpdateCommentForm;
import board.impl.BoardActionUpdateForm;
import board.impl.BoardActionView;
import board.impl.BoardActionWrite;
import board.impl.BoardActionWriteForm;

public class ActionFactory {
	public Action getAction(String command) {
		Action action = null;
		
//		if(command == null) {
//			action = new ActionIndex();
//			break;
//		}
		
		System.out.println("ActionFactory: " + command);
		
		switch(command) {
		
		case "LIST":
			action = new BoardActionList();
			break;
			
		case "VIEW":
			action = new BoardActionView();
			break;
			
		case "WRITEFORM":
			action = new BoardActionWriteForm();
			break;
			
		case "WRITE":
			action = new BoardActionWrite();
			break;
			
		case "UPDATE":
			action = new BoardActionUpdate();
			break;
			
		case "UPDATEFORM":
			action = new BoardActionUpdateForm();
			break;
			
		case "DELETE":
			action = new BoardActionDelete();
			break;
		
		case "UPDATECOMMENTFORM":
			action = new BoardActionUpdateCommentForm();
			break;
			
		case "UPDATECOMMENT":
			action = new BoardActionUpdateComment();
			break;
			
		case "DELETECOMMENT":
			action = new BoardActionDeleteComment();
			break;
			
		}
		
		return action;
	}
}
