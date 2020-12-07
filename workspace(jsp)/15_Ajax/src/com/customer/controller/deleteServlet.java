package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.model.CustomerDAO;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/delete.do")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int user_no = Integer.parseInt(request.getParameter("no"));
		
		CustomerDAO dao = CustomerDAO.getInstance();
		
		int res = dao.delete(user_no);
		
		PrintWriter out = response.getWriter();
		
		out.println(res);
	}

}
