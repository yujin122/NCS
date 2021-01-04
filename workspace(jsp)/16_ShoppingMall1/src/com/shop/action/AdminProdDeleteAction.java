package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.ProductDAO;

public class AdminProdDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		ProductDAO dao = ProductDAO.getInstance();
		
		int res = dao.deleteProduct(pnum);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_prod_list.do");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
