package com.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardSearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String search = request.getParameter("search");
		String text = request.getParameter("text").trim();
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> dto = dao.searchBoard(search, text);
		
		request.setAttribute("list", dto);
		
		return "view/board_search.jsp";
	}

}
