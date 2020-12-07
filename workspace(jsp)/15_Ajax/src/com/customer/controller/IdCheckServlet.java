package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.model.CustomerDAO;

@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 public IdCheckServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	 }
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = utf-8");
		
		String userId = request.getParameter("id").trim();
		
		CustomerDAO dao = CustomerDAO.getInstance();
		String res = dao.checkCustomerId(userId);
		
		PrintWriter out = response.getWriter();
		
		out.println(res);	
		
	}

	

}
