package com.onegroup.controller.marketboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;

public class MarketBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketBoardDAO.getInstance().deleteBoard(request.getParameter("num"));
		
		new MarketBoardListAction().execute(request, response);
	}

}
