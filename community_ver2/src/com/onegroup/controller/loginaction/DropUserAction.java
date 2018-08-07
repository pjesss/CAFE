package com.onegroup.controller.loginaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.dao.MemberDAO;
import com.onegroup.dto.MemberVO;

public class DropUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		MemberDAO dao = MemberDAO.getInstance();
				
		int userCheck_flag=0;
		int result=0;
		if(userid.equals(loginUser.getUserid())){
			userCheck_flag = dao.userCheck(userid,pwd);

			if(userCheck_flag == 1){
				result = dao.deleteMember(request.getParameter("userid"));
				if (result != 0) {
					session.invalidate();
				}
			}
		}
		request.getRequestDispatcher("myinfo/myinfoview.jsp").forward(request, response);
	}
		
		

}
