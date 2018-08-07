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

public class BuyCancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		BuyListVO buyVO = BuyListDAO.getInstance().getOneBuyList(num);
		
		//구매자의 money 증감
		String buyUserid = ((MemberVO)request.getSession().getAttribute("loginUser")).getUserid();
		MemberDAO.getInstance().plusUsermoney(buyUserid, buyVO.getTransMoney());
		BuyListDAO.getInstance().minusTransMoney(num);
		
		//판매목록 확정취소
		int boardNum = buyVO.getBoardNum();
		SaleListDAO.getInstance().buyCancel(boardNum, 0);
		
		//구매목록 확정취소
		BuyListDAO.getInstance().buyCancel(boardNum);
		
		//게시판 판매중 처리
		MarketBoardDAO.getInstance().buyCancel(boardNum);
		
		//기존의 loginUser 객체를 갱신한다.
		HttpSession session = request.getSession();
		String userid = ((MemberVO)session.getAttribute("loginUser")).getUserid();
		request.getSession().setAttribute("loginUser", MemberDAO.getInstance().getMember(userid));
		
		new BuyListAction().execute(request, response);
	}

}
