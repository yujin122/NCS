package com.shop.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.action.Action;
import com.shop.action.ActionForward;


public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length()+1);
		
		Action action = null;
		ActionForward forward = null;
		
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(jsp)\\16_ShoppingMall\\src\\com\\shop\\controller\\mapping.properties");
		
		prop.load(fis);
		
		String value = prop.getProperty(command);
		
		System.out.println("value >> " + value);
	
		if(value.substring(0, 7).equals("execute")) {
			
			StringTokenizer st = new StringTokenizer(value, "|");
			String url_1 = st.nextToken(); // "execute"
			String url_2 = st.nextToken(); // "패키지명.클래스명"
		
			try {
				Class url = Class.forName(url_2);
				// action = new BbsListAction()
				action = (Action)url.newInstance();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {	// value 값 중에 "execute" 가 아닌 경우
			// view page로 이동
			forward = new ActionForward();
			forward.setRedirect(false);		// *.jsp 페이지로 이동
			forward.setPath(value);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {	// true - *.do
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}
