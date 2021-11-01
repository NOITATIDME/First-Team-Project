package board.base;

import board.impl.AjaxActionDeleteComment;
import board.impl.AjaxActionWriteComment미사용;
import board.impl.AjaxBoardList미사용;
import board.impl.AjaxCommentList미사용;
import board.impl.AjaxCommentPaging;
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

public class CommentActionFactory {
	public Action getAction(String command) {
		Action action = null;
		
//		if(command == null) {
//			action = new ActionIndex();
//			break;
//		}
		
		System.out.println("CommentActionFactory: " + command);
		
		switch(command) {
		//----ajax
			
		case "DELETECOMMENT":
			action = new AjaxActionDeleteComment();
			break;
			
		case "COMMENTPAGING":
			action = new AjaxCommentPaging(); // 2
				
			
		}
		
		return action;
	}
}
