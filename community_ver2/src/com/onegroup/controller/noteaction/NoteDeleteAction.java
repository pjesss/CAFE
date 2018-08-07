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

public class NoteDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoteDAO dao = NoteDAO.getInstance();
		
		String [] notenum = request.getParameterValues("notenum");
		for(String temp : notenum){
			int num = Integer.parseInt(temp);
			dao.deleteNote(num);
		}
		
		request.getRequestDispatcher("FrontServlet?command=note_main").forward(request,response);
	
	}

}
