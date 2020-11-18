package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinSevlet
 */
@WebServlet("/join")
public class JoinSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinSevlet() {
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
		
		String name = request.getParameter("name").trim();
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		String birth = request.getParameter("birth").trim();
		String gender = request.getParameter("gender").trim();
		String postNum = request.getParameter("postnum").trim();
		String addr1 = request.getParameter("addr1").trim();
		String addr2 = request.getParameter("addr2").trim();
		String phone1 = request.getParameter("phone1").trim();
		String phone2 = request.getParameter("phone2").trim();
		String phone3 = request.getParameter("phone3").trim();
		String email = request.getParameter("email").trim();
		
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table align = 'center' border = '1' cellspacing = '0'>");
		out.println("<tr>");
		out.println("<th>이름 </th>");
		out.println("<td>" + name + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>아이디 </th>");
		out.println("<td>" + id + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>비밀번호 </th>");
		out.println("<td>" + pwd + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>생일 </th>");
		out.println("<td>" + birth + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>성별 </th>");
		out.println("<td>" + gender + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>주소</th>");
		out.println("<td>" + postNum + ") <br>"+ addr1 + "<br>" + addr2 + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>번호</th>");
		out.println("<td>" + phone1 +" - " + phone2 + " - " + phone3 + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>이메일</th>");
		out.println("<td>" + email + "</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}

}
