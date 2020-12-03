package com.board3.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board3.model.BbsDAO;
import com.board3.model.BbsDTO;

public class BbsReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		int group = Integer.parseInt(request.getParameter("group"));
		int step = Integer.parseInt(request.getParameter("step"));
		int indent = Integer.parseInt(request.getParameter("indent"));
		
		String writer = request.getParameter("name").trim();
		String title = request.getParameter("title").trim();
		String cont = request.getParameter("content").trim();
		String pwd = request.getParameter("pwd").trim();
		
		BbsDTO dto = new BbsDTO();
		
		dto.setBoard_writer(writer);
		dto.setBoard_title(title);
		dto.setBoard_cont(cont);
		dto.setBoard_pwd(pwd);
		dto.setBoard_no(num);
		dto.setBoard_group(group);
		dto.setBoard_step(step);
		dto.setBoard_indent(indent);
		
		BbsDAO dao = BbsDAO.getInstance();
		
		dao.replyUpdate(group, step);		// 기존의 답변글의 스텝을 증가시킴
		int res = dao.replyeBbs(dto);		// 답변글을 등록하는 메서드 호출
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("bbs_list.do");
		}else {
			PrintWriter out  = response.getWriter();
			
			out.println("<script>");
			out.println("alert('답변 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
			
		return forward;
	}

}
