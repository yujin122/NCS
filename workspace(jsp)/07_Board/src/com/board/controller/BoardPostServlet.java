package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

@WebServlet("/boardPost")
public class BoardPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 조회수를 증가시키는 메서드 호출
		dao.boardHit(no);
		
		BoardDTO dto = dao.getBoardPost(no);
		
		request.setAttribute("post", dto);
		RequestDispatcher rd = request.getRequestDispatcher("view/boardPost.jsp");
		
		rd.forward(request, response);
		
	}

}
