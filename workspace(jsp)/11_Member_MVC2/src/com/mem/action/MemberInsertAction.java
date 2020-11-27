package com.mem.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;
import com.mem.model.MemberDTO;

public class MemberInsertAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String member_id = request.getParameter("memid").trim();
		String member_name = request.getParameter("memname").trim();
		String member_pwd = request.getParameter("pwd").trim();
		int member_age = Integer.parseInt(request.getParameter("age").trim());
		int member_mileage = Integer.parseInt(request.getParameter("mileage").trim());
		String member_job = request.getParameter("job").trim();
		String member_addr = request.getParameter("addr").trim();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMemid(member_id);
		dto.setMemname(member_name);
		dto.setPwd(member_pwd);
		dto.setAge(member_age);
		dto.setMileage(member_mileage);
		dto.setJob(member_job);
		dto.setAddr(member_addr);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int res = dao.insertMem(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('회원 등록 완료')");
			out.println("location.href = 'member_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

}
