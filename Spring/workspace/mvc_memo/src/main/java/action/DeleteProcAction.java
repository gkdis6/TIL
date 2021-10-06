package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MemoDAO dao = new MemoDAO();
		
		int memono = Integer.parseInt(request.getParameter("memono"));
		String passwd = request.getParameter("passwd");
		
		Map map = new HashMap();
		map.put("memono", memono);
		map.put("passwd", passwd);
		
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		if(pflag) {
			flag = dao.delete(memono);
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		return "/view/deleteProc.jsp";
	}

}
