package com.onegroup.controller.buysaleaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.SaleListDAO;

public class SaleListDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] arrNum = request.getParameterValues("num");
		
		int result = SaleListDAO.getInstance().deleteSaleList(arrNum);
		
		request.setAttribute("result", result);
		new SaleListAction().execute(request, response);

	}

}
