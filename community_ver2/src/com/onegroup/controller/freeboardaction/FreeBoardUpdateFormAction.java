package com.onegroup.controller.freeboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dto.FreeBoardVO;

public class FreeBoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FreeBoardVO vo =FreeBoardDAO.getInstance().selectOneFreeBoard(request.getParameter("num"));
		request.setAttribute("oneboard", vo);
		request.getRequestDispatcher("/freeboard/freeBoardUpdate.jsp").forward(request, response);
		
		System.out.println("num:"+request.getParameter("num"));
	
	}

}
