package com.onegroup.controller.marketboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dto.MarketBoardVO;


public class MarketBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		MarketBoardDAO.getInstance().updateReadCount(num);

		MarketBoardVO vo = MarketBoardDAO.getInstance().selectOneBoard(num);
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

		request.getRequestDispatcher("marketboard/marketBoardView.jsp").forward(request, response);
	}

}
