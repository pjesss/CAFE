package com.onegroup.controller.marketboardaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dto.MarketBoardVO;

public class MarketBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MarketBoardVO> bestList = MarketBoardDAO.getInstance().selectBestBoard();
		List<MarketBoardVO> allList = MarketBoardDAO.getInstance().selectAllBoard();
		
		String [] arrBestImg = new String[bestList.size()];
		for(int i=0; i<arrBestImg.length; i++){
			String imgPath = request.getContextPath()+"/upload/"+bestList.get(i).getImgpath1(); //첫번째 사진 경로
			arrBestImg[i] = imgPath;
		}

		String [] arrAllImg = new String[allList.size()];
		for(int i=0; i<arrAllImg.length; i++){
			String imgPath = request.getContextPath()+"/upload/"+allList.get(i).getImgpath1(); //첫번째 사진 경로
			arrAllImg[i] = imgPath;
		}
		
		request.setAttribute("marketBoardAllList", allList);
		request.setAttribute("marketBoardAllImg", arrAllImg);

		request.setAttribute("marketBoardBestList", bestList);
		request.setAttribute("marketBoardBestImg", arrBestImg);
		
		request.getRequestDispatcher("marketboard/marketBoardList.jsp").forward(request, response);
		
	}
}
