package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Member10DAO;
import com.sist.model.Member10DTO;
import com.sist.model.MemberDAO;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO dao = MemberDAO.getInstance();
		
		//Member10DAO dao = new Member10DAO();
		
		List<Member10DTO> dto = dao.memSelect();
		
		request.setAttribute("list", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/select.jsp");
		rd.forward(request, response);
		
	}

}
