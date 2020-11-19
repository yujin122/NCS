package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 접속해서 전체 리스트를 가져오는 작업
		EmpDAO dao = new EmpDAO();
		
		List<EmpDTO> empList = dao.selectList();
		
		request.setAttribute("list", empList);
		
		// 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);		// 실제적 페이지 이동
	}

}
