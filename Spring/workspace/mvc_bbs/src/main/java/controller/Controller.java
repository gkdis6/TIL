package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.NullAction;

public class Controller extends HttpServlet {

	private boolean usingTemplate = false;//template 사용여부
	private String templatePage = null;//templatePage경로
	
	private Map map = new HashMap(); //URI명령어 = Action
	
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		
		try {
			fis = new FileInputStream(configFile);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis != null) try {fis.close();} catch(IOException ex) {}
		}
		
		Iterator keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			System.out.println("command : "+command);
			
			String handlerClassName = prop.getProperty(command).trim();
			System.out.println("handlerClassName : "+handlerClassName);
			try {
				Class handlerClass = Class.forName(handlerClassName);
				Object handlerInstance = handlerClass.newInstance();
				
				map.put(command, handlerInstance);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//web.xml에서 templatePage 파라미터값 가져옴
		templatePage = config.getInitParameter("templatePage");
		if(templatePage != null && !templatePage.equals("")) {
			usingTemplate = true;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 분석 = 어떤 명령어가 들어왔는지 확인
		// "/mvc/mvc/list.do"
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(request.getContextPath().length());
		}
		
		Action action = (Action)map.get(command);
		
		if(action==null) {
			action = new NullAction();
		}
		
		String viewPage = null;
		try {
			viewPage = action.execute(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		
		if(usingTemplate) {
			request.setAttribute("CONTENT_PAGE", viewPage);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(usingTemplate ? templatePage : viewPage);
		dispatcher.forward(request, response);
	}

}
