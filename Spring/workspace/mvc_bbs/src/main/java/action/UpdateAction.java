package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BbsDAO dao = new BbsDAO();
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		BbsDTO dto = dao.read(bbsno);
		
		request.setAttribute("dto", dto);
		
		return "/view/updateForm.jsp";
	}

}
