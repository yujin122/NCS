package com.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.CategoryDAO;
import com.shop.model.CategoryDTO;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class AdminProdEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductDTO dto = dao.getProduct(pnum);
		
		CategoryDAO c_dao = CategoryDAO.getInstance();
		
		List<CategoryDTO> list = c_dao.getCategoryList();
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("list", list);
		request.setAttribute("dto", dto);
		
		forward.setRedirect(false);
		forward.setPath("admin/admin_prod_edit.jsp");
		
		return forward;
	}

}
