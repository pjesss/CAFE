package com.onegroup.controller.marketboardaction;

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
import com.onegroup.dto.MarketBoardVO;
import com.onegroup.dto.MemberVO;
import com.onegroup.dto.SaleListVO;

public class MarketBoardBuyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketBoardVO marketBoard = MarketBoardDAO.getInstance().selectOneBoard(request.getParameter("num"));
		MemberVO saleMember = MemberDAO.getInstance().getMember(marketBoard.getUserid());
		MemberVO buyMember = (MemberVO)(request.getSession().getAttribute("loginUser"));
		
		
		if(marketBoard.getGoodsprice() <= buyMember.getUsermoney()){
			request.setAttribute("message", "enough");
		}else{
			request.setAttribute("message", "notEnough");
			request.getRequestDispatcher("buy/buyCheck.jsp").forward(request, response);
			return;
		}
		

		//구매자 money 차감
		int goodsprice = marketBoard.getGoodsprice();
		MemberDAO.getInstance().minusUsermoney(buyMember.getUserid(), goodsprice);
		
		//구매목록 추가 -> transMoney 넣기
		BuyListVO buyVO = new BuyListVO();
		buyVO.setGoodsname(marketBoard.getGoodsname());
		buyVO.setGoodsprice(marketBoard.getGoodsprice());
		buyVO.setBoardNum(marketBoard.getNum());
		buyVO.setSaleUserid(saleMember.getUserid());
		buyVO.setStatus(0); // 1:확정완료  0:확정대기
		buyVO.setTransMoney(marketBoard.getGoodsprice());
		buyVO.setUserid(buyMember.getUserid());
		BuyListDAO.getInstance().addBuyList(buyVO);
		
		//판매목록추가
		SaleListVO saleVO = new SaleListVO();
		saleVO.setGoodsname(marketBoard.getGoodsname());
		saleVO.setGoodsprice(marketBoard.getGoodsprice());
		saleVO.setBoardNum(marketBoard.getNum());
		saleVO.setUserid(saleMember.getUserid());
		saleVO.setStatus(0); // 1:구매자가 확정함  0:확정대기
		saleVO.setBuyUserid(buyMember.getUserid());
		SaleListDAO.getInstance().addSaleList(saleVO);
		
		//게시판 판매완료 처리
		MarketBoardDAO.getInstance().buyComplete(marketBoard.getNum());
		
		//기존의 loginUser 객체를 갱신한다.
		HttpSession session = request.getSession();
		String userid = ((MemberVO)session.getAttribute("loginUser")).getUserid();
		request.getSession().setAttribute("loginUser", MemberDAO.getInstance().getMember(userid));
		
		request.getRequestDispatcher("buy/buyCheck.jsp").forward(request, response);
		
		
	}

}
