package com.board2.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board2.model.BoardDAO;
import com.board2.model.BoardDTO;

public class BoardEditOkAtion implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String writer = request.getParameter("writer").trim();
		String con = request.getParameter("cont").trim();
		String title = request.getParameter("title").trim();
		String pwd = request.getParameter("pwd").trim();
		
		int no = Integer.parseInt(request.getParameter("no"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBoard_no(no);
		dto.setWriter(writer);
		dto.setBoard_cont(con);
		dto.setTitle(title);
		dto.setBoard_pwd(pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.updateBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("location.href = 'board_cont.do?no="+no+"&page="+page+"'");
			out.println("</script>");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
