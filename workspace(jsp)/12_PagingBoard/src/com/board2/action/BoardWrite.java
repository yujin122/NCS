package com.board2.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board2.model.BoardDAO;
import com.board2.model.BoardDTO;

public class BoardWrite implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String writer = request.getParameter("name");
		String title = request.getParameter("title");
		String cont = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setBoard_cont(cont);
		dto.setBoard_pwd(pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.addBoardPost(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('글작성 완료')");
			out.println("location.href = 'board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('글작성 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
