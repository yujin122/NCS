package com.upload.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadUpdateOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UploadDTO dto = new UploadDTO();
		
		String saveFolder = "C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(jsp)\\14_FileUpload\\WebContent\\upload";
		
		int fileSize = 10 * 1024 * 1024; // 10MB
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int num = Integer.parseInt(multi.getParameter("no"));
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String cont = multi.getParameter("content");
		String pwd = multi.getParameter("pwd");
		
		File file = multi.getFile("file");
		
		if(file != null) {
			String fileName = file.getName();
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String homedir = saveFolder + "/" + year + "-" + month + "-" + day;
			
			File path1 = new File(homedir);
			if(!path1.exists()) {
				path1.mkdirs();
			}
			
			// 파일 만들기
			String refileName = writer+"_"+fileName;
			file.renameTo(new File(homedir+"/"+refileName));
			
			String fileDBName = "/"+year+"-"+month+"-"+day+"/"+refileName;
			
			dto.setUpload_file(fileDBName);
		}
		
		dto.setUpload_no(num);
		dto.setUpload_writer(writer);
		dto.setUpload_title(title);
		dto.setUpload_cont(cont);
		dto.setUpload_pwd(pwd);
		
		UploadDAO dao = UploadDAO.getInstance();
		
		int res = dao.updateUpload(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("upload_cont.do?no="+num);
		}else if(res == -1){
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('글수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
