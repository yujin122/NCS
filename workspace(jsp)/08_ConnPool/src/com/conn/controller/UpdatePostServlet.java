package com.conn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.model.BoardDAO;
import com.conn.model.BoardDTO;

@WebServlet("/updatePost")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.getBoardPost(num);
		
		request.setAttribute("edit", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/boardUpdate.jsp");
		rd.forward(request, response);
		
	}

}
