package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String writer = request.getParameter("writer").trim();
		String title = request.getParameter("title").trim();
		String content = request.getParameter("content").trim();
		String pwd = request.getParameter("pwd").trim();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setBoard_cont(content);
		dto.setBoard_pwd(pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int result = dao.insertPost(dto);
		
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시물 추가 성공')");
			out.println("location.href = 'select.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 추가 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
