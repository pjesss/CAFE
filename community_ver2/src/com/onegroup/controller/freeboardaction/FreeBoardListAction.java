package com.onegroup.controller.freeboardaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dto.FreeBoardVO;

public class FreeBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("freeBoardListAction");
		
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		List<FreeBoardVO> allList = dao.selectAllBoard();
		List<FreeBoardVO> bestList = dao.selectBestBoard();
		request.setAttribute("freeBoardSelectAll", allList);
		request.setAttribute("freeBoardSelectBest", bestList);
		request.getRequestDispatcher("freeboard/freeBoardList.jsp").forward(request, response);
	}

}
