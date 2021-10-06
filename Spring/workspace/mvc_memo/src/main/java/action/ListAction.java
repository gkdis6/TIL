package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;
import utility.Utility;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		//검색 관련
		String col = Utility.checkNull(request.getParameter("col")); //wname, title, content, total
		String word = Utility.checkNull(request.getParameter("word")); 
		
		if(col.equals("total")){
	 		word = "";
	 	}
		
		//페이징 관련
		int nowPage = 1;
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 3;
		int sno = ((nowPage-1) * recordPerPage) +1 ; 
		int eno = nowPage * recordPerPage;
		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
		//Model 사용
		MemoDAO dao = new MemoDAO();
		List<MemoDTO> list = dao.list(map);
		
		int total = dao.total(col, word);
		
		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
		
		//request 저장
		
		request.setAttribute("list",list);
		request.setAttribute("paging",paging);
		request.setAttribute("col",col);
		request.setAttribute("word",word);
		request.setAttribute("nowPage",nowPage);
				
				
		//view 리턴
		return "/view/list.jsp";
	}

}
