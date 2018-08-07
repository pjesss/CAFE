package com.onegroup.controller.auctionaction;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.AuctionDAO;
import com.onegroup.dao.MarketBoardDAO;

public class AuctionInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("num"));
		int auctionPrice = Integer.parseInt(request.getParameter("startPrice"));
		//int auctionTime = Integer.parseInt(request.getParameter("auctionTime"));
		Date date = new Date();
		AuctionDAO.getInstance().insertBoard(boardNum, auctionPrice, 0, date.getTime());
		
		MarketBoardDAO.getInstance().updateStatusAuction(boardNum);
		
		request.getRequestDispatcher("auction/auctionInsertSuccess.jsp").forward(request, response);
		

	}

}
