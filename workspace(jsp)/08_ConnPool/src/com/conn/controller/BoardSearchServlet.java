package com.conn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.model.BoardDAO;
import com.conn.model.BoardDTO;

@WebServlet("/boardSearch")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		String text = request.getParameter("search");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> search = dao.boardSearch(category, text);
		
		request.setAttribute("search", search);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/boardSearch.jsp");
		rd.forward(request, response);
		
	}

}
