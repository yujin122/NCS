package com.mem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAddAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		
		return "view/member_add.jsp";
	}

}
