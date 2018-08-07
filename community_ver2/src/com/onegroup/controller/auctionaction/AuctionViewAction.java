package com.onegroup.controller.auctionaction;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.AuctionDAO;
import com.onegroup.dto.AuctionVO;

public class AuctionViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String num = request.getParameter("num");
	      AuctionDAO.getInstance().updateReadCount(num);
	      
	      AuctionVO vo = AuctionDAO.getInstance().getOneList(num);
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
	      
	      request.getRequestDispatcher("auction/auctionview.jsp").forward(request, response);
	}

}
