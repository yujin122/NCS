package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.CategoryDAO;

public class AdminCatDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		
		CategoryDAO dao = CategoryDAO.getInstance();
		
		int res = dao.deleteCategory(cnum);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_cat_list.do");
		}else {
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('카테고리 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
