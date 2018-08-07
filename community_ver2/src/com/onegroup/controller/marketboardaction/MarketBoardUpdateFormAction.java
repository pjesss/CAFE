package com.onegroup.controller.marketboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dto.MarketBoardVO;


public class MarketBoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketBoardVO vo = MarketBoardDAO.getInstance().selectOneBoard(request.getParameter("num"));
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("marketboard/marketBoardUpdate.jsp").forward(request, response);
	}

}
