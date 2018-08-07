package com.onegroup.controller.auctionaction;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.AuctionDAO;
import com.onegroup.dto.AuctionVO;
import com.onegroup.dto.MemberVO;


public class AuctionBuyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("옥션1");
		String boardNum = request.getParameter("boardNum");
		String endprice = request.getParameter("endprice");
		HttpSession session = request.getSession();
		String winner = ((MemberVO)session.getAttribute("loginUser")).getUserid();
		AuctionDAO.getInstance().updatePrice(boardNum, endprice, winner);
		request.setAttribute("winner", winner);
		System.out.println("옥션2");
		
	AuctionVO vo =AuctionDAO.getInstance().getOneList(boardNum);
	request.setAttribute("vo", vo);
	
	 
    String[] arrImglocal = new String[3];

    String[] arrImgname = new String[3];
    arrImgname[0] = vo.getImgpath1();
    arrImgname[1] = vo.getImgpath2();
    arrImgname[2] = vo.getImgpath3();

    for (int i = 0; i < 3; i++) {
       if (arrImgname[i].equals("none")) {
          arrImglocal[i] = "none";
          continue;
       }

       arrImglocal[i] = request.getContextPath() + "/upload/" + arrImgname[i];

    }

    request.setAttribute("arrImglocal", arrImglocal);
    
    Date date = new Date();
    long goneTime = (date.getTime() - vo.getEnrollTime())/1000;
    request.setAttribute("goneTime", goneTime);
	
	
	System.out.println("옥션3");
	request.getRequestDispatcher("auction/auctionview.jsp").forward(request, response);
	/*new AuctionViewAction().execute(request, response);*/
		

	}

}
