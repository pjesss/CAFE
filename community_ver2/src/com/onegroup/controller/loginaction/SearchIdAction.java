package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class SearchIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		System.out.println("아이디 찾기 " + name + phone);
		
		MemberDAO dao = MemberDAO.getInstance();
		String userid = dao.getMember(name, phone);
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("SearchId/SearchId.jsp").forward(request,response);
	
	}

}
