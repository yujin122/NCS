package com.board2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board2.action.Action;
import com.board2.model.BoardDAO;
import com.board2.model.BoardDTO;

public class BoardSearchAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String label = request.getParameter("find_field");
		String text = request.getParameter("find_name").trim();
		
		int rowsize = 3;
		int block = 3;
		int totalRecord = 0;
		int allPage = 0;
		
		int page = 0;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}else {
			page = 1;
		}
		
		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);
		
		int startBlock = (((page - 1)/ block)*block)+1;
		int endBlock = (((page-1)/block)*block)+block;
		
		BoardDAO dao = BoardDAO.getInstance();
		totalRecord = dao.getBoardCont(label, text);
		
		allPage = (int)Math.ceil(totalRecord/(double)rowsize);
		
		if(endBlock > allPage) {
			endBlock = allPage;
		}
		
		List<BoardDTO> searchList = dao.getBoardList(page, rowsize, label, text);
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("find_field", label);
		request.setAttribute("find_name", text);
		request.setAttribute("list", searchList);
		
	}

}
