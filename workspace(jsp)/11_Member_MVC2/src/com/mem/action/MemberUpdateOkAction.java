package com.mem.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;
import com.mem.model.MemberDTO;

public class MemberUpdateOkAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int num = Integer.parseInt(request.getParameter("num").trim());
		String id = request.getParameter("memid").trim();
		String name = request.getParameter("memname").trim();
		String pwd = request.getParameter("pwd").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		int mileage = Integer.parseInt(request.getParameter("mileage").trim());
		String job = request.getParameter("job").trim();
		String addr = request.getParameter("addr").trim();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setNum(num);
		dto.setMemid(id);
		dto.setMemname(name);
		dto.setPwd(pwd);
		dto.setAge(age);
		dto.setMileage(mileage);
		dto.setJob(job);
		dto.setAddr(addr);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.updateMember(dto);
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('회원 정보 수정 성공')");
			out.println("location.href='member_info.do?no="+num+"'");
			out.println("</script>");
		}else if(result == -1){
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");		
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 정보 수정 실패')");
			out.println("history.back()");			
			out.println("</script>");
		}
		
		return null;
	}

}
