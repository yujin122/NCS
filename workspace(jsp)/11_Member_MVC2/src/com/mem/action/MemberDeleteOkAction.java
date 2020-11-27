package com.mem.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;

public class MemberDeleteOkAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int no = Integer.parseInt(request.getParameter("num"));
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();

		int result = dao.updateMember(no,pwd);
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('회원 삭제 성공')");
			out.println("location.href='member_list.do'");
			out.println("</script>");
		}else if(result == -1){
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");		
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('멤버 삭제 실패')");
			out.println("history.back()");			
			out.println("</script>");
			
		}
		
		return null;
	}

}
