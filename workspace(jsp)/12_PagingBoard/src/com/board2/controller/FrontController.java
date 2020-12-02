package com.board2.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board2.action.Action;
import com.board2.action.BoardContAction;
import com.board2.action.BoardDeleteAction;
import com.board2.action.BoardDeleteOkAction;
import com.board2.action.BoardEditAction;
import com.board2.action.BoardEditOkAtion;
import com.board2.action.BoardListAction;
import com.board2.action.BoardSearchContAction;
import com.board2.action.BoardWrite;
import com.board2.action.LoginOkAction;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length()+1);
		
		Action action = null;
		String viewPage = null;
		
		if(command.equals("join.do")) {
			
		}else if(command.equals("login.do")) {
			viewPage = "views/login.jsp";
		}else if(command.equals("login_ok.do")) {
			action = new LoginOkAction();
			action.excute(request, response);
		}else if(command.equals("board_list.do")) {
			action = new BoardListAction();
			action.excute(request, response);
			viewPage = "views/board_list.jsp";
		}else if(command.equals("board_write.do")) {
			viewPage = "views/board_write.jsp";
		}else if(command.equals("board_write_ok.do")) {
			action = new BoardWrite();
			action.excute(request, response);
		}else if(command.equals("board_cont.do")) {
			action = new BoardContAction();
			action.excute(request, response);
			viewPage = "views/board_cont.jsp";
		}else if(command.equals("board_edit.do")) {
			action = new BoardEditAction();
			action.excute(request, response);
			viewPage = "views/board_edit.jsp";
		}else if(command.equals("board_edit_ok.do")) {
			action = new BoardEditOkAtion();
			action.excute(request, response);
		}else if(command.equals("board_delete.do")) {
			action = new BoardDeleteAction();
			action.excute(request, response);
			viewPage = "views/board_delete.jsp";
		}else if(command.equals("board_delete_ok.do")) {
			action = new BoardDeleteOkAction();
			action.excute(request, response);
		}else if(command.equals("board_search.do")) {
			action = new BoardSearchAction();
			action.excute(request, response);
			viewPage = "views/board_search.jsp";
		}else if(command.equals("board_searchCont.do")) {
			action = new BoardSearchContAction();
			action.excute(request, response);
			viewPage = "views/board_search_cont.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
	
}
