package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;
import com.sun.java.swing.plaf.windows.resources.windows;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		MemberVO vo = new MemberVO(name, userid, pw, age, email, phone, address, 0, 0);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(vo);
		
		request.getRequestDispatcher("Login/loginForm.jsp").forward(request,response);
	}

}
