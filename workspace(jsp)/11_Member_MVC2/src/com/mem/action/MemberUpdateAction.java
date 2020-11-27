package com.mem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;
import com.mem.model.MemberDTO;


public class MemberUpdateAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no").trim());
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberDTO dto = dao.getMemberInfo(num);
		
		request.setAttribute("edit", dto);
		
		return "view/member_update.jsp";
	}

}
