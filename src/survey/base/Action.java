package survey.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@FunctionalInterface : 한개의 메소드가 가지는 인터페이스
@FunctionalInterface
public interface Action {

	void execute(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException;

}
