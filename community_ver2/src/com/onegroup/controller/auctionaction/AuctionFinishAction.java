package com.onegroup.controller.auctionaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.AuctionDAO;
import com.onegroup.dao.BuyListDAO;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dao.SaleListDAO;
import com.onegroup.dto.AuctionVO;
import com.onegroup.dto.BuyListVO;
import com.onegroup.dto.MarketBoardVO;
import com.onegroup.dto.MemberVO;
import com.onegroup.dto.SaleListVO;

public class AuctionFinishAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		System.out.println("boardNum : "+boardNum);
		
		//boardNum을 이용해서
		//endPrice, winner 가져온다
		String winner = AuctionDAO.getInstance().getOneList(boardNum).getWinner();
		int endPrice = AuctionDAO.getInstance().getOneList(boardNum).getEndPrice();
		
		if(endPrice==0){
			System.out.println("낙찰자 없음");
			return;
		}
		
		//판매자 userid의 usermoney + endPrice;
		MemberDAO.getInstance().plusUsermoney(AuctionDAO.getInstance().getOneList(boardNum).getUserid(), endPrice);

		//구매자 userid의 usermoney - endPrice;
		MemberDAO.getInstance().minusUsermoney(winner, endPrice);

		//marketboard statue 2 -> 1
		MarketBoardDAO.getInstance().buyComplete(Integer.parseInt(boardNum));
		
		
		/////-------------------------------------------------------------------------
		
		//구매목록, 판매목록 갱신
		
		AuctionVO auctionBoard = AuctionDAO.getInstance().getOneList(boardNum);
		MemberVO saleMember = MemberDAO.getInstance().getMember(auctionBoard.getUserid());
		MemberVO buyMember = MemberDAO.getInstance().getMember(auctionBoard.getWinner());
		
		//구매목록 추가 -> transMoney 넣기
		BuyListVO buyVO = new BuyListVO();
		buyVO.setGoodsname(auctionBoard.getGoodsname());
		buyVO.setGoodsprice(auctionBoard.getEndPrice());
		buyVO.setBoardNum(auctionBoard.getBoardNum());
		buyVO.setSaleUserid(saleMember.getUserid());
		buyVO.setStatus(2); // 1:확정완료  0:확정대기, 2:경매 구매 완료
		buyVO.setTransMoney(0);//의미 없음
		buyVO.setUserid(buyMember.getUserid());
		BuyListDAO.getInstance().addBuyList(buyVO);
		
		//판매목록추가
		SaleListVO saleVO = new SaleListVO();
		saleVO.setGoodsname(auctionBoard.getGoodsname());
		saleVO.setGoodsprice(auctionBoard.getEndPrice());
		saleVO.setBoardNum(auctionBoard.getBoardNum());
		saleVO.setUserid(saleMember.getUserid());
		saleVO.setStatus(2); // 1:구매자가 확정함  0:확정대기, 2: 경매 판매 완료
		saleVO.setBuyUserid(buyMember.getUserid());
		SaleListDAO.getInstance().addSaleList(saleVO);
		
		//게시판 판매완료 처리 (0 -> 1)
		AuctionDAO.getInstance().updateStatus(auctionBoard.getBoardNum());
		
		//기존의 loginUser 객체를 갱신한다.
		HttpSession session = request.getSession();
		String userid = ((MemberVO)session.getAttribute("loginUser")).getUserid();
		request.getSession().setAttribute("loginUser", MemberDAO.getInstance().getMember(userid));

	}

}
