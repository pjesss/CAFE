package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class SearchPwFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("SearchId/SearchPwForm.jsp").forward(request,response);
	}

}
