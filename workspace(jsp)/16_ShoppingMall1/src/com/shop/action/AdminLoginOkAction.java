package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.AdminShopDAO;
import com.shop.model.AdminShopDTO;

public class AdminLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		AdminShopDTO dto = new AdminShopDTO();
		
		dto.setAdmin_id(id);
		dto.setAdmin_pwd(pwd);
		
		AdminShopDAO dao = AdminShopDAO.getInstance();
		
		int res = dao.adminLogin(dto);
		
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			AdminShopDTO info = dao.getAdminCont(id);
			
			session.setAttribute("admin_id", id);
			session.setAttribute("admin_name", info.getAdmin_name());
			
			forward.setRedirect(false);
			forward.setPath("admin/admin_main.jsp");
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
