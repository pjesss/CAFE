package com.onegroup.controller.cashaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class CashChargeFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = MemberDAO.getInstance();
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		String userid = vo.getUserid();
		
		MemberVO vo2 = dao.getMember(userid);
		int usermoney = vo2.getUsermoney();
		
		request.setAttribute("usermoney", usermoney);
		
		request.getRequestDispatcher("cash/cash.jsp").forward(request, response);
		
	}
}
