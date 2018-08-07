package com.onegroup.controller.freeboardaction;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dto.FreeBoardVO;

public class FreeBoardUpadateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	FreeBoardVO vo = new FreeBoardVO();
	
	Date date = new Date();
	Timestamp ts = new Timestamp(date.getTime());
	vo.setNum(Integer.parseInt(request.getParameter("num")));
	vo.setTitle(request.getParameter("title"));
	vo.setContent(request.getParameter("content"));
	vo.setWritedate(ts);
	
	
	FreeBoardDAO.getInstance().updateBoard(vo);
	
	new FreeBoardListAction().execute(request, response);
	}
}
