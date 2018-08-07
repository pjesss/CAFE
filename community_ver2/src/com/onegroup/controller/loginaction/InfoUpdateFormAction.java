package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class InfoUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO loginVO = (MemberVO)session.getAttribute("loginUser");
		String userid = loginVO.getUserid();
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getMember(userid);
		
		request.setAttribute("getMember", vo);
		request.getRequestDispatcher("/myinfo/infoupdateview.jsp").forward(request, response);
	}

}
