package com.board2.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board2.model.MemberDAO;
import com.board2.model.MemberDTO;


public class LoginOkAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int res = dao.userCheck(id, pwd);
		
		PrintWriter out = response.getWriter();
		
		// 세션 객체 생성 방법 (클래스, 서블릿)
		// 형식) request.getSession()
		// 메서드는 session이 미리 생성되어 있는 경우에는 session을 반환,
		// 생성되어 있지 않은 경우에는 새롭게 session을 생성하여 반환
		HttpSession session = request.getSession();
				
		if(res > 0) {
			MemberDTO dto = dao.getMember(id);
			
			// 회원 정보를 세션 객체에 저장
			session.setAttribute("id", dto.getMemid());
			session.setAttribute("name", dto.getMemname());
			
			out.println("<script>");
			out.println("alert('로그인 성공')");
			out.println("location.href = 'views/main.jsp'");
			out.println("</script>");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else if(res == -2) {
			out.println("<script>");
			out.println("alert('회원이 아닙니다.')");
			out.println("location.href = 'join.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
