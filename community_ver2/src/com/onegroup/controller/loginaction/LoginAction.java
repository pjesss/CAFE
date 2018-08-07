package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userCheck
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.userCheck(request.getParameter("userid"),request.getParameter("pw"));
		//1,0,-1
		
		String url = "";
		System.out.println(result);
		if(result == 1){
			//session에 loginUser올리기
			MemberVO vo = dao.getMember(request.getParameter("userid"));
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			
			//로그인 완료 창으로 가기
			url = "Login/login.jsp";
		}else{
			url = "Login/loginForm.jsp";
			request.setAttribute("message", "로그인 실패");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
