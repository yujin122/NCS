package com.mem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;
import com.mem.model.MemberDTO;

public class MemberListAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberDTO> list = dao.getMemberList();
		
		request.setAttribute("mem", list);
		
		return "view/member_list.jsp";
	}

}
