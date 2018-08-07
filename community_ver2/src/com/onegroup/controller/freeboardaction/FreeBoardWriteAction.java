package com.onegroup.controller.freeboardaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dto.FreeBoardVO;
import com.onegroup.dto.MemberVO;

public class FreeBoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("write error2");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String userid = "";
		if(mvo!=null){
		userid = mvo.getUserid();
		}
		System.out.println("---------"+title+content);
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setUserid(userid);
		
		System.out.println(vo.getTitle() + vo.getContent() + vo.getUserid());
		System.out.println("write error3");
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.insertFreeBoard(vo);
		
		System.out.println("write error4");
		new FreeBoardListAction().execute(request, response);
		System.out.println("write error5");
			
		
		
	}

}
