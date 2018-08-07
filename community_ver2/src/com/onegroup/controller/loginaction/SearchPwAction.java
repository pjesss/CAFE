package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class SearchPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MemberDAO dao = MemberDAO.getInstance();
		String pw = dao.getMember(userid, name, phone);
		request.setAttribute("pw", pw);
		request.getRequestDispatcher("SearchId/SearchPw.jsp").forward(request,response);
	}

}
