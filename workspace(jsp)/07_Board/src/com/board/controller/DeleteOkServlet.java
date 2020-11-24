package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;

@WebServlet("/deleteOk.do")
public class DeleteOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset = utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pwd = request.getParameter("pwd").trim();
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.deleteBoard(num,pwd);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 삭제 성공')");
			out.println("location.href = 'select.do'");
			out.println("</script>");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}

}
