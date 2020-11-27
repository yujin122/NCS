package com.mem.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemberDAO;


public class MemberDeleteAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		request.setAttribute("num", no);
		
		return "view/member_delete.jsp";
	}

}
