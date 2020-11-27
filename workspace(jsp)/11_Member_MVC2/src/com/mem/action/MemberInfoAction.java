package com.mem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;
import com.mem.model.MemberDTO;

public class MemberInfoAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberDTO dto = dao.getMemberInfo(num);
		
		request.setAttribute("info", dto);
		
		return "view/member_info.jsp";
	}

}
