package com.onegroup.controller.auctionaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dto.MarketBoardVO;

public class AuctionInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketBoardVO vo = (MarketBoardVO)MarketBoardDAO.getInstance().selectOneBoard(request.getParameter("num"));
		request.setAttribute("auctionVO", vo);
		request.getRequestDispatcher("auction/auctionInsert.jsp").forward(request, response);

	}

}
