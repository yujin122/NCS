package com.board3.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board3.model.BbsDAO;
import com.board3.model.BbsDTO;

public class BbsReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글번호에 해당하는 게시글을 조회하여 상세내역을
		// 답변글 폼 페이지에 넘겨주는 클래스
		
		int num = Integer.parseInt(request.getParameter("no"));
		
		BbsDAO dao = BbsDAO.getInstance();
		BbsDTO dto = dao.getBbsPost(num);
		
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("views/bbs_reply.jsp");
		
		return forward;
	}

}
