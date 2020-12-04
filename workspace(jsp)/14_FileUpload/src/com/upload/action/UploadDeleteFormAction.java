package com.upload.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		
		request.setAttribute("no", num);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("views/upload_delete_form.jsp");
		
		return forward;
	}

}
