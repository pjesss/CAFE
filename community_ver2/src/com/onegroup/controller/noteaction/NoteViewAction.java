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

public class NoteViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int notenum = Integer.parseInt(request.getParameter("notenum"));
		
		NoteVO note = NoteDAO.getInstance().getNote(notenum);

		request.setAttribute("note", note);
		
		request.getRequestDispatcher("Note/NoteView.jsp").forward(request,response);
	
	}

}
