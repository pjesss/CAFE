package com.onegroup.controller.marketboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MarketBoardVO;
import com.onegroup.dto.MemberVO;

public class MarketBoardBuyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketBoardVO marketBoard = MarketBoardDAO.getInstance().selectOneBoard(request.getParameter("num"));
		MemberVO saleMember = MemberDAO.getInstance().getMember(marketBoard.getUserid());
		
		request.setAttribute("saleMember", saleMember);
		request.setAttribute("marketBoard", marketBoard);
		request.getRequestDispatcher("marketboard/marketBoardBuy.jsp").forward(request, response);
	}

}
