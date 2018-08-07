package com.onegroup.controller.freeboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;


public class FreeBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		FreeBoardDAO.getInstance().delete(num);
		new FreeBoardListAction().execute(request, response);
	}

}
