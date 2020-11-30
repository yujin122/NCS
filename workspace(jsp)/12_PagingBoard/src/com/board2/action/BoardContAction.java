package com.board2.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board2.model.BoardDAO;
import com.board2.model.BoardDTO;

public class BoardContAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int board_no = Integer.parseInt(request.getParameter("no"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.boardHit(board_no);
		
		BoardDTO dto = dao.getBoardCont(board_no);
		
		request.setAttribute("dto", dto);
		request.setAttribute("page", page);
	}

}
