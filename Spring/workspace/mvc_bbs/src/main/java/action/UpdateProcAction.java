package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import model.BbsDAO;
import model.BbsDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BbsDAO dao = new BbsDAO();
		BbsDTO dto = new BbsDTO();
		request.setCharacterEncoding("utf-8");
		dto.setBbsno(Integer.parseInt(request.getParameter("bbsno")));
		dto.setWname((request.getParameter("wname")));
		dto.setTitle((request.getParameter("title")));
		dto.setContent((request.getParameter("content")));
		dto.setPasswd((request.getParameter("passwd")));
		
		Map map = new HashMap();
		map.put("bbsno", dto.getBbsno());
		map.put("passwd", dto.getPasswd());
		
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		if(pflag) {
			flag = dao.update(dto);
		}
		request.setAttribute("flag", flag);
		request.setAttribute("pflag", pflag);
		return "/view/updateProc.jsp";
	}

}
