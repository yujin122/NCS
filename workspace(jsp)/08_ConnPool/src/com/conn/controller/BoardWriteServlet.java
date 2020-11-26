package com.conn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.model.BoardDAO;
import com.conn.model.BoardDTO;

@WebServlet("/boardWrite")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String cont = request.getParameter("cont");
		String pwd = request.getParameter("pwd");
		
		BoardDTO dto = new BoardDTO();
		
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setCont(cont);
		dto.setPwd(pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.boardWrite(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 작성 완료')");
			out.println("location.href = 'boardList'");
			out.println("</script>");		
		}else {
			out.println("<script>");
			out.println("alert('게시물 작성 실패')");
			out.println("history.back()");
			out.println("</script>");	
		}
	}

}
