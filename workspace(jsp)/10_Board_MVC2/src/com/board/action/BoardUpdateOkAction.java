package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardUpdateOkAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String cont = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		int num = Integer.parseInt(request.getParameter("num"));
		String pwd_ok = request.getParameter("pwd_ok");
		
		PrintWriter out  = response.getWriter();
		
		if(pwd_ok.equals(pwd)) {
			
			BoardDTO dto = new BoardDTO();
			
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setBoard_cont(cont);
			dto.setBoard_pwd(pwd);
			dto.setBoard_no(num);
			
			BoardDAO dao = BoardDAO.getInstance();
			
			int res = dao.updateBoard(dto);
			
			if(res > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 완료')");
				out.println("location.href = 'board_post.do?no="+num+"'");
				out.println("</script>");
			}else if(res == -1){
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
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return null;
	}

}
