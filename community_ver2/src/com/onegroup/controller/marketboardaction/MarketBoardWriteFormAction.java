package com.onegroup.controller.marketboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;



public class MarketBoardWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("marketboard/marketBoardWrite.jsp").forward(request, response);
	}
}
