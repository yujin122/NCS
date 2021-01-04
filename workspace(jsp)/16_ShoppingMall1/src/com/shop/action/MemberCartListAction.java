package com.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.CartDAO;
import com.shop.model.CartDTO;

public class MemberCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CartDAO dao = CartDAO.getInstance();
		
		List<CartDTO> list = dao.getCartList();
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("member/member_cart_list.jsp");
		
		return forward;
	}

}
