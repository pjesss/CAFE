package com.onegroup.controller.buysaleaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.BuyListDAO;
import com.onegroup.dto.BuyListVO;
import com.onegroup.dto.MemberVO;

public class BuyListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = ((MemberVO)request.getSession().getAttribute("loginUser")).getUserid();
		List<BuyListVO> list = BuyListDAO.getInstance().getBuyList(userid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("buy/buyList.jsp").forward(request, response);
	}
}
