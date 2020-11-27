package com.mem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.action.Action;
import com.mem.action.MemberAddAction;
import com.mem.action.MemberDeleteAction;
import com.mem.action.MemberDeleteOkAction;
import com.mem.action.MemberInfoAction;
import com.mem.action.MemberInsertAction;
import com.mem.action.MemberListAction;
import com.mem.action.MemberSearchAction;
import com.mem.action.MemberUpdateAction;
import com.mem.action.MemberUpdateOkAction;

public class FrontController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length()+1);
		
		Action action = null;
		
		if(command.equals("member_list.do")) {
			action = new MemberListAction();
		}else if(command.equals("member_add.do")) {
			action = new MemberAddAction();
		}else if(command.equals("member_insert.do")) {
			action = new MemberInsertAction();
		}else if(command.equals("member_info.do")) {
			action = new MemberInfoAction();
		}else if(command.equals("member_update.do")) {
			action = new MemberUpdateAction();
		}else if(command.equals("member_updateOk.do")) {
			action = new MemberUpdateOkAction();
		}else if(command.equals("member_delete.do")) {
			action = new MemberDeleteAction();
		}else if(command.equals("member_removeOk.do")) {
			action = new MemberDeleteOkAction();
		}else if(command.equals("member_search.do")) {
			action = new MemberSearchAction();
		}
		
		
		String path1 = action.excute(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher(path1);
		rd.forward(request, response);
	}
}
