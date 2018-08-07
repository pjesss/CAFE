package com.onegroup.controller.auctionaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.AuctionDAO;
import com.onegroup.dto.AuctionVO;

public class AuctionListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AuctionVO> allList = AuctionDAO.getInstance().getAllList();

		String [] arrAllImg = new String[allList.size()];
		for(int i=0; i<arrAllImg.length; i++){
			String imgPath = request.getContextPath()+"/upload/"+allList.get(i).getImgpath1(); //첫번째 사진 경로
			arrAllImg[i] = imgPath;
		}
		
		request.setAttribute("auctionList", allList);
		request.setAttribute("marketBoardAllImg", arrAllImg);
		request.getRequestDispatcher("auction/auctionList.jsp").forward(request, response);
	}

}
