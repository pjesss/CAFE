package com.onegroup.controller.buysaleaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.SaleListDAO;
import com.onegroup.dto.MemberVO;
import com.onegroup.dto.SaleListVO;

public class SaleListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("111");
		String userid = ((MemberVO)request.getSession().getAttribute("loginUser")).getUserid();
		System.out.println("111");
		List<SaleListVO> list = SaleListDAO.getInstance().getSaleList(userid);
		System.out.println("111");
		request.setAttribute("list", list);
		System.out.println("111");
		request.getRequestDispatcher("sale/saleList.jsp").forward(request, response);
		System.out.println("111");
	}

}
