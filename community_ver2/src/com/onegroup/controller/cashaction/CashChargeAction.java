package com.onegroup.controller.cashaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class CashChargeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기존 유저머니에 입력한 머니를 플러스해준다
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		String userid = vo.getUserid();
		
		String userMoney = request.getParameter("usermoney");
		int usermoney = Integer.parseInt(userMoney);
		
		System.out.println("너가 넣은 돈 : " + usermoney);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.plusUsermoney(userid, usermoney);

		request.getRequestDispatcher("myinfo/myinfoview.jsp").forward(request, response);
		
	}
}
