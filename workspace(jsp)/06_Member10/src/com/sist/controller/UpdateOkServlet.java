package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Member10DTO;
import com.sist.model.MemberDAO;

@WebServlet("/updateOk.do")
public class UpdateOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int mem_num = Integer.parseInt(request.getParameter("num").trim());
		String member_id = request.getParameter("mem_id").trim();
		String member_name = request.getParameter("mem_name").trim();
		String member_pwd = request.getParameter("mem_pwd").trim();
		int member_age = Integer.parseInt(request.getParameter("mem_age").trim());
		int member_mileage = Integer.parseInt(request.getParameter("mem_mileage").trim());
		String member_job = request.getParameter("mem_job").trim();
		String member_addr = request.getParameter("mem_addr").trim();
		
		Member10DTO dto = new Member10DTO();
		
		dto.setNum(mem_num);
		dto.setMemid(member_id);
		dto.setMemname(member_name);
		dto.setPwd(member_pwd);
		dto.setAge(member_age);
		dto.setMileage(member_mileage);
		dto.setJob(member_job);
		dto.setAddr(member_addr);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.updateMember(dto);
		
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('레코드 수정 성공')");
			out.println("location.href='content.do?no="+dto.getNum()+"'");
			out.println("</script>");

		}else {
			out.println("<script>");
			out.println("alert('레코드 수정 실패')");
			out.println("history.back()");		// 이전페이지 이동	
			out.println("</script>");
			
		}
	}

}
