package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class InfoUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println("회원수정 할 아이디 " + userid);
		MemberVO vo = new MemberVO();
		
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		vo.setUserid(userid);
		vo.setPw(pw);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAddress(address);
		
		MemberDAO.getInstance().updateMember(vo);
		
		new MyinfoAction().execute(request, response);
		//저장되었습니다 띄우기
		
	}

}
