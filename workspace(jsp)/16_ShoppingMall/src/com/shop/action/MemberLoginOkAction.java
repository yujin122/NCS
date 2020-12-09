package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.AdminShopDAO;
import com.shop.model.AdminShopDTO;
import com.shop.model.MemberDAO;
import com.shop.model.MemberDTO;

public class MemberLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMemid(id);
		dto.setPwd(pwd);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int res = dao.memberLogin(dto);
		
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			MemberDTO info = dao.getMemberCont(id);
			
			session.setAttribute("mem_id", id);
			session.setAttribute("mem_name", info.getMemname());
			
			forward.setRedirect(true);
			forward.setPath("member_main.do");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else if(res == -2) {
			out.println("<script>");
			out.println("alert('회원정보가 존재하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원정보가 존재하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
