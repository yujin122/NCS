package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDAO dao = MemberDAO.getInstance();
		
		
		
		int result = dao.deleteMem(no);
		
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('레코드 삭제 성공')");
			out.println("location.href='select'");
			out.println("</script>");

		}else {
			out.println("<script>");
			out.println("alert('레코드 삭제 실패')");
			out.println("history.back()");		// 이전페이지 이동	
			out.println("</script>");
			
		}
	}

}
