package com.onegroup.controller.freeboardaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dto.FreeBoardVO;
import com.onegroup.dto.MarketBoardVO;
import com.onegroup.dto.MemberVO;

public class FreeBoardMyViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		MemberVO uservo = (MemberVO)session.getAttribute("loginUser");
		String userid = uservo.getUserid();
		
		FreeBoardDAO dao =FreeBoardDAO.getInstance();
		List<FreeBoardVO> myList = dao.selectMyViewBoard(userid);

		List<MarketBoardVO> myMarketList = MarketBoardDAO.getInstance().selectMyBoard(userid);
		
		request.setAttribute("myview", myList);
		request.setAttribute("myMarketList", myMarketList);
		request.getRequestDispatcher("/freeboard/freeBoardMyView.jsp").forward(request, response);
	}

}
