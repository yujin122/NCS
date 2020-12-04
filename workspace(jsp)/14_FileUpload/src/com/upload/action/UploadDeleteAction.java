package com.upload.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd").trim();
		
		
		UploadDAO dao = UploadDAO.getInstance();
		
		UploadDTO dto = dao.getUpload(num);
		
		// upload 폴더에 업로드된 파일까지 삭제
		String up = "C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(jsp)\\14_FileUpload\\WebContent\\upload";
		String fileName = dto.getUpload_file();
		
		int res = dao.deleteUpload(num, pwd);
		
		if(fileName != null) {
			File file = new File(up+fileName);
			file.delete();		// 삭제
		}
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("upload_list.do");
		}else {
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('글삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
