package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BbsDAO dao = new BbsDAO();
		
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		String passwd = request.getParameter("passwd");
		
		Map map = new HashMap();
		map.put("bbsno", bbsno);
		map.put("passwd", passwd);
		
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		if(pflag) {
			flag = dao.delete(bbsno);
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		return "/view/deleteProc.jsp";
	}

}
