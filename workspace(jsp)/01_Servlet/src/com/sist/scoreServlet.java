package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class scoreServlet
 */
@WebServlet("/score")
public class scoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("name");
		int kor = (Integer.parseInt(request.getParameter("kor")));
		int eng = (Integer.parseInt(request.getParameter("eng")));
		int math = (Integer.parseInt(request.getParameter("mat")));
		
		double avg = (kor+eng+math)/3.0f;
		
		String grade;
		
		if(avg>=90) {
			grade = "A학점";
		}else if(avg >=80) {
			grade = "B학점";
		}else if(avg >=70) {
			grade = "C학점";
		}else if(avg >=60) {
			grade = "D학점";
		}else{
			grade = "F학점";
		}
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>");
		out.println("이름 : " + userName + "<br>");
		out.println("국어 : " + kor + "점<br>");
		out.println("영어 : " + eng + "점<br>");
		out.println("수학 : " + math + "점<br>");
		out.println("평균 : " + String.format("%.2f", avg) + "점<br>");
		out.println("학점 : " + grade + "<br>");
		out.println("<h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
