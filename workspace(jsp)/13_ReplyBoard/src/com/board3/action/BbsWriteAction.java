package com.board3.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board3.model.BbsDAO;
import com.board3.model.BbsDTO;

public class BbsWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String writer = request.getParameter("name").trim();
		String title = request.getParameter("title").trim();
		String cont = request.getParameter("content").trim();
		String pwd = request.getParameter("pwd").trim();
		
		BbsDTO dto = new BbsDTO();
		
		dto.setBoard_writer(writer);
		dto.setBoard_title(title);
		dto.setBoard_cont(cont);
		dto.setBoard_pwd(pwd);
		
		BbsDAO dao = BbsDAO.getInstance();
		
		int res = dao.writeBbs(dto);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 추가 성공')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_list.do");
		}else {
			out.println("<script>");
			out.println("alert('게시물 추가 실패')");
			out.println("</script>");
			forward.setRedirect(false);
			forward.setPath("views/bbs_write.jsp");
		}
		return forward;
	}

}
