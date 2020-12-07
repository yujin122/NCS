package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.model.CustomerDAO;
import com.customer.model.CustomerDTO;

@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id").trim();
		String name = request.getParameter("name").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		String tel = request.getParameter("tel").trim();
		String addr = request.getParameter("addr").trim();
		
		CustomerDTO dto = new CustomerDTO();
		
		dto.setId(id);
		dto.setName(name);
		dto.setAge(age);
		dto.setTel(tel);
		dto.setAddr(addr);
		
		CustomerDAO dao = CustomerDAO.getInstance();
		
		int res = dao.insertCustomer(dto);
		
		PrintWriter out = response.getWriter();
		
		out.println(res);
	}

}
