package com.onegroup.controller.noteaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dao.NoteDAO;
import com.onegroup.dto.MemberVO;
import com.onegroup.dto.NoteVO;

public class NoteWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		String toid = vo.getUserid();
		
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoteDAO dao = NoteDAO.getInstance();
		dao.sendNote(toid, userid, title, content);
		
		request.getRequestDispatcher("FrontServlet?command=note_main").forward(request,response);
	
	}

}
