package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;


@WebServlet("/insertOk")
public class InsertOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num").trim());
		String name = request.getParameter("name").trim();
		String job = request.getParameter("job").trim();
		int mgrNo = Integer.parseInt(request.getParameter("mgrNo").trim());
		int sal = Integer.parseInt(request.getParameter("sal").trim());
		int comm = Integer.parseInt(request.getParameter("comm").trim());
		int deptNo = Integer.parseInt(request.getParameter("deptNo").trim());
		
		EmpDTO emp = new EmpDTO();
		
		emp.setEmpno(num);
		emp.setEname(name);
		emp.setJob(job);
		emp.setMgr(mgrNo);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setDeptno(deptNo);
		
		EmpDAO dao = new EmpDAO();
		
		int result = dao.empAdd(emp);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			response.sendRedirect("select");
		}else {
			out.println("<script>");
			out.println("alert('레코드 추가 실패')");
			out.println("history.back()");		// 이전페이지 이동	
			out.println("</script>");
			
		}
	}

}
