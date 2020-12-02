package com.board3.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board3.model.BbsDAO;

public class BbsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int num = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		
		BbsDAO dao = BbsDAO.getInstance();
		
		int res = dao.deleteBbs(num, pwd);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("bbs_list.do");
		}else {
			forward.setRedirect(true);
			forward.setPath("bbs_delete_form.do?no="+num);
		}
		return forward;
	}

}
