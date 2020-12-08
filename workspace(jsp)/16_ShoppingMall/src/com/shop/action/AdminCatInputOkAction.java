package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.CategoryDAO;

public class AdminCatInputOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String cat_code = request.getParameter("cat_code").trim();
		String cat_name = request.getParameter("cat_name");
		
		CategoryDAO dao = CategoryDAO.getInstance();
		
		int res = dao.insertCategory(cat_code, cat_name);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_cat_list.do");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('카테고리 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
