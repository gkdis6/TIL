package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class DateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		CommandService service = new CommandService();
		String str = service.getDate();
		
		request.setAttribute("date", str);
		
		return "view/date.jsp";
	}

}
