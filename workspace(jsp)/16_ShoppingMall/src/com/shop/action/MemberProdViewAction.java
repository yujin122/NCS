package com.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class MemberProdViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductDTO dto = dao.getProduct(pnum);
		
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("member/member_prod_view.jsp");
		return forward;
	}

}
