package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class HelloAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1. 모델 사용
		CommandService service = new CommandService();
		StringBuffer sb = service.getHello();
		
		//2. 결과 저장
		request.setAttribute("hello", sb);
		System.out.println("HelloAction Loading");
		
		//3. 뷰페이지 리턴
		return "/view/hello.jsp";
	}

}
