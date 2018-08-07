package com.onegroup.controller.auctionaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.AuctionDAO;
import com.onegroup.dao.MarketBoardDAO;

public class AuctionDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("num");
		AuctionDAO.getInstance().deleteAuction(boardNum);
		MarketBoardDAO.getInstance().buyCancel(Integer.parseInt(boardNum)); //경매 취소를 이 메서드로 대체한다.
		
		request.getRequestDispatcher("auction/auctionDeleteSuccess.jsp").forward(request, response);

	}

}
