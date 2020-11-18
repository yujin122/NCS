package com.sist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		
		String dbId = "hong";
		String dbPwd = "1234";
		
		if(id.equals(dbId)){
			if(pwd.equals(dbPwd)){
				request.setAttribute("name", "세종대왕");
				request.setAttribute("addr", "서울시 마포구");
				
				RequestDispatcher rd = request.getRequestDispatcher("ex09.jsp");
				rd.forward(request, response);
			}
			else{
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else{
			System.out.println("아이디가 틀렸습니다.");
		}
	}

}
