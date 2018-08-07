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

public class DeleteNoteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int notenum = Integer.parseInt(request.getParameter("notenum"));
		
		NoteDAO dao = NoteDAO.getInstance();
		dao.deleteNote(notenum);
	
		request.getRequestDispatcher("FrontServlet?command=note_main").forward(request,response);
	}

}
