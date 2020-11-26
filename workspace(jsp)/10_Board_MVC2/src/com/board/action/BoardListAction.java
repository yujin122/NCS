package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스 로직을 수행하는 클래스
		// DB에서 게시글 전체 리스트를 조회하는 컨트롤러(클래스)
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> list = dao.getBoardList();
		
		request.setAttribute("list", list);

		return "view/board_list.jsp";
	}

}
