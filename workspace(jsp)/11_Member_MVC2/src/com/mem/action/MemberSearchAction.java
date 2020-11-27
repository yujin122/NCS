package com.mem.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;
import com.mem.model.MemberDTO;

public class MemberSearchAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String search = request.getParameter("search");
		String text = request.getParameter("text");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberDTO> list = dao.searchMember(search, text);
		
		request.setAttribute("search", list);
		
		return "view/member_search.jsp";
	}

}
