package com.onegroup.controller.buysaleaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.BuyListDAO;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dao.SaleListDAO;
import com.onegroup.dto.BuyListVO;
import com.onegroup.dto.MemberVO;

public class BuyCompleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");//구매목록의 목록번호
		BuyListVO buyVO = BuyListDAO.getInstance().getOneBuyList(num);//클릭한 구매목록
		
		//판매자의 momey 증감
		MemberDAO.getInstance().plusUsermoney(buyVO.getSaleUserid(), buyVO.getTransMoney());
		BuyListDAO.getInstance().minusTransMoney(num);
		
		//판매목록 확정 status 변경(0 -> 1)
		int boardNum = buyVO.getBoardNum();
		SaleListDAO.getInstance().buyComplete(boardNum);
		
		//구매목록 확정 status 변경(0 -> 1)
		BuyListDAO.getInstance().buyComplete(num);
		
		//marketboard의 status 변경(0 -> 1)
		MarketBoardDAO.getInstance().buyComplete(boardNum);
		
		//기존의 loginUser 객체를 갱신한다.
		HttpSession session = request.getSession();
		String userid = ((MemberVO)session.getAttribute("loginUser")).getUserid();
		request.getSession().setAttribute("loginUser", MemberDAO.getInstance().getMember(userid));
		
		new BuyListAction().execute(request, response);
	}

}
