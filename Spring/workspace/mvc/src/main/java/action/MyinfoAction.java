package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class MyinfoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		CommandService service = new CommandService();
		StringBuffer sb = service.getMyinfo();
		
		request.setAttribute("myinfo", sb);
		
		return "/view/myinfo.jsp";
	}

}
