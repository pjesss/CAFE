package com.onegroup.controller.noteaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.NoteDAO;
import com.onegroup.dto.MemberVO;
import com.onegroup.dto.NoteVO;

public class NoteMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		
		String userid = vo.getUserid();
		
		List<NoteVO> list = NoteDAO.getInstance().getNoteAll(userid);
		
		List<NoteVO> sendList = NoteDAO.getInstance().getSendNoteAll(userid);
		
		request.setAttribute("noteList", list);
		request.setAttribute("sendNoteList", sendList);
		
		request.getRequestDispatcher("Note/NoteMain.jsp").forward(request,response);
	
	}

}
