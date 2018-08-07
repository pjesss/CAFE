package com.onegroup.controller.freeboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;

public class FreeBoardWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("write error1");
		request.getRequestDispatcher("/freeboard/freeBoardWrite.jsp").forward(request, response);
	}

}
