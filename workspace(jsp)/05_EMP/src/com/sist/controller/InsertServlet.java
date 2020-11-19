package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.DeptDTO;
import com.sist.model.EmpDAO;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
		List<DeptDTO> deptList = dao.deptList();
		
		request.setAttribute("dept", deptList);
		
		RequestDispatcher rd = request.getRequestDispatcher("insertForm.jsp");
		rd.forward(request, response);
		
	}

}
