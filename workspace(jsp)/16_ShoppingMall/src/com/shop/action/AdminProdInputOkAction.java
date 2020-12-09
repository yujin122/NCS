package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class AdminProdInputOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String saveFolder = "C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(jsp)\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\16_ShoppingMall\\upload";
		
		int fileSize = 1024*1024*5;	//5mb
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
		String p_category = multi.getParameter("p_category");
		String p_name = multi.getParameter("p_name");
		String p_company = multi.getParameter("p_company");
		int p_qty = Integer.parseInt(multi.getParameter("p_qty"));
		int p_price = Integer.parseInt(multi.getParameter("p_price"));
		String p_spec = multi.getParameter("p_spec");
		String p_cont = multi.getParameter("p_content");
		int p_point = Integer.parseInt(multi.getParameter("p_point"));
		
		// 서버상에 실제로 업로드될 파일 이름을 스트링 타입으로 반환
		String p_image = multi.getFilesystemName("p_image");
		
		ProductDTO dto = new ProductDTO();
		
		dto.setPcategory(p_category);
		dto.setPname(p_name);
		dto.setPcompany(p_company);
		dto.setPqty(p_qty);
		dto.setPrice(p_price);
		dto.setPspec(p_spec);
		dto.setPcontent(p_cont);
		dto.setPoint(p_point);
		dto.setPimage(p_image);
		
		ProductDAO dao = ProductDAO.getInstance();
		
		int res = dao.insertProduct(dto);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_prod_list.do");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;	
		
	}

}
