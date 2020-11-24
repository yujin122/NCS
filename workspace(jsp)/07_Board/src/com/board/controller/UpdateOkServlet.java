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

@WebServlet("/updateOk.do")
public class UpdateOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String writer = request.getParameter("writer").trim();
		String title = request.getParameter("title").trim();
		String content = request.getParameter("content").trim();
		String pwd = request.getParameter("pwd");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setBoard_cont(content);
		dto.setBoard_pwd(pwd);
		dto.setBoard_no(num);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.updateBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 수정 성공')");
			out.println("location.href = 'boardPost?no="+num+"'");
			out.println("</script>");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}

}
