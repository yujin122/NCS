package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.CartDAO;
import com.shop.model.CartDTO;

public class MemberCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String pspec = request.getParameter("p_spec");
		String pimg = request.getParameter("p_image");
		String pname = request.getParameter("p_name").trim();
		int price = Integer.parseInt(request.getParameter("p_price"));
		int pqty = Integer.parseInt(request.getParameter("p_qty"));
		
		CartDTO dto = new CartDTO();
		
		dto.setCart_pnum(pnum);
		dto.setCart_pspec(pspec);
		dto.setCart_pimage(pimg);
		dto.setCart_pname(pname);
		dto.setCart_price(price);
		dto.setCart_pqty(pqty);
		
		CartDAO dao = CartDAO.getInstance();
		
		int res = dao.insertCart(dto);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("member_cart_list.do");
		}else {
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('장바구니 저장 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
