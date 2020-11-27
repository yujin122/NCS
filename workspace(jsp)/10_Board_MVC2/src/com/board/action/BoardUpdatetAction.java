package com.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardUpdatetAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.getBoardPost(num);
		
		request.setAttribute("post", dto);
		
		return "view/board_update.jsp";
	}

}
