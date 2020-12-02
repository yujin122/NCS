package com.board3.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board3.model.BbsDAO;
import com.board3.model.BbsDTO;

public class BbsUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String cont = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String writer = request.getParameter("writer");
		
		BbsDTO dto = new BbsDTO();
		
		dto.setBoard_no(num);
		dto.setBoard_title(title);
		dto.setBoard_cont(cont);
		dto.setBoard_pwd(pwd);
		dto.setBoard_writer(writer);
		
		BbsDAO dao = BbsDAO.getInstance();
		
		int res = dao.updateBbs(dto);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 수정 완료')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_cont.do?no="+num);
			
		}else if(res == -1){
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_update_form.do?no="+num);
		}else {
			out.println("<script>");
			out.println("alert('게시물 수정 실패')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_update_form.do?no="+num);
		}
		
		return forward;
	}

}
