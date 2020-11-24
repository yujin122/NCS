package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Member10DTO;
import com.sist.model.MemberDAO;

@WebServlet("/content.do")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mem_no = Integer.parseInt(request.getParameter("no"));
		
		MemberDAO dao = MemberDAO.getInstance();
		
		Member10DTO dto = dao.contentMember(mem_no);
		
		request.setAttribute("cont", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/member_cont.jsp");
		rd.forward(request, response);
		
		
	}

}
