package com.board3.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board3.action.Action;
import com.board3.action.ActionForward;

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
		/*
		 * java.util.Properties 클래스
		 * Properties 클래스는 HashTable의 하위 클래스
		 * 보통은 환경 변수 및 속성 값을 Properties 파일에 저장하여
		 * 쉽게 접근할 수 있는 장점이 있음
		 * Properties 파일은 일련의 키(key)-값(value)의 한 쌍으로 이루어짐
		 * 보통은  파일에 저장하여 사용됨. 파일 이름을 *.properties로 끝나게 함
		 * InputStream에 Properties파일을 넣어서 그 스트림으로부터
		 * 파일을 가져올 때 많이 사용함 인자로 들어온 Properties 파일을 읽게 됨.
		 * 읽어들일 때 사용하는 메서드는 load() 메서드를 이용하게 됨
		 */
		
		FileInputStream fis = new FileInputStream("C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(jsp)\\13_ReplyBoard\\src\\com\\board3\\controller\\mapping.properties");
		
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
				action.execute(request, response);
				
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
