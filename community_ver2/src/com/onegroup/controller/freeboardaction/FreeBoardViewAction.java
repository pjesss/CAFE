package com.onegroup.controller.freeboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dto.FreeBoardVO;

public class FreeBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		FreeBoardDAO.getInstance().updateReadCount(num);
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		FreeBoardVO vo = dao.selectOneFreeBoard(num);
		
		request.setAttribute("oneboard", vo);
		
		request.getRequestDispatcher("freeboard/freeBoardView.jsp").forward(request, response);
	}

}
