package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.board.action.Action;
import com.board.action.BoardInsertAction;
import com.board.action.BoardListAction;
import com.board.action.BoardPostAction;
import com.board.action.BoardWriteAction;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		//getRequestURI() : "/프로젝트명/파일명(*.do)" 라는 문자열을 반환
		String uri = request.getRequestURI();
		//System.out.println(uri);
		
		//getContextPath() : 현재 프로젝트 명을 문자열로 반환
		String path = request.getContextPath();
		System.out.println(path);
		
		String command = uri.substring(path.length()+1);
		System.out.println(command);
		
		Action action = null;
		
		if(command.equals("board_list.do")) {
			action = new BoardListAction();
		}else if(command.equals("board_post.do")) {
			action = new BoardPostAction();
		}else if(command.equals("board_write.do")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_insert.do")) {
			action = new BoardInsertAction();
		}
		
		String path1 = action.execute(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher(path1);
		rd.forward(request, response);
				
	}
}
