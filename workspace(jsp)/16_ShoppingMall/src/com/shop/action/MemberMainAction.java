package com.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class MemberMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ProductDAO dao = ProductDAO.getInstance();
		
		List<ProductDTO> list = dao.getProductList();
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("member/member_main.jsp");
		
		return forward;
	}

}
