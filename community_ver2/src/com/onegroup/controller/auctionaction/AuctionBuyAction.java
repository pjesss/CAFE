package com.onegroup.controller.auctionaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;

public class AuctionBuyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			request.getRequestDispatcher("/auction/auctionview.jsp").forward(request, response);
		
	}

}
