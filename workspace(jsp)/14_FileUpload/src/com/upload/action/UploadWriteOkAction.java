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

public class UploadWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UploadDTO dto = new UploadDTO();
		
		// 첨부파일이 저장될 경로(위치)
		String saveFolder = "C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(jsp)\\14_FileUpload\\WebContent\\upload";
		
		// 첨부파일의 최대 크기
		int fileSize = 10 * 1024 * 1024; // 10MB
		
		// 파일 업로드를 진행 시 이진파일 업로드를 위한 객체 생성
		MultipartRequest multi = new MultipartRequest(
				request,		// 일반적인 request 
				saveFolder,		// 업로드 파일 저장 위치 
				fileSize, 		// 업로드할 파일의 최대 크기 
				"utf-8",		// 문자 encoding 방식
				new DefaultFileRenamePolicy());		// 파일 이름 중복이 안되게 설정	
		
		// 자료실 폼에서 넘어온 데이터들을 처리
		String writer = multi.getParameter("writer").trim();
		String title = multi.getParameter("title").trim();
		String cont = multi.getParameter("content").trim();
		String pwd = multi.getParameter("pwd").trim();
		
		// 자료실 폼 페이지에서 type = "file"로 되어 있으면 
		// getFile() 메서드로 받아주어야 한다.
		File file = multi.getFile("file");
		
		if(file != null) {
			// getName() : 첨부파일의 이름을 문자열로 반환
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
		
		dto.setUpload_writer(writer);
		dto.setUpload_title(title);
		dto.setUpload_cont(cont);
		dto.setUpload_pwd(pwd);
		
		UploadDAO dao = UploadDAO.getInstance();
		
		int res = dao.insertUpload(dto);
		
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("upload_list.do");
		}else {
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('글쓰기 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
