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

@WebServlet("/updateOk")
public class UpdateOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title").trim();
		String writer = request.getParameter("writer").trim();
		String cont = request.getParameter("cont").trim();
		String pwd = request.getParameter("pwd").trim();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setNum(num);
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setCont(cont);
		dto.setPwd(pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.boardUpdate(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 수정 완료')");
			out.println("location.href = 'boardPost?no="+num+"'");
			out.println("</script>");		
		}else if(res ==-1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
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
