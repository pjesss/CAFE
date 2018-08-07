package com.onegroup.controller.searchformaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.FreeBoardDAO;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dao.MemberDAO;
import com.onegroup.dao.NoteDAO;
import com.onegroup.dto.FreeBoardVO;
import com.onegroup.dto.MarketBoardVO;
import com.onegroup.dto.MemberVO;
import com.onegroup.dto.NoteVO;

public class SearchFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");

		String searchWord= request.getParameter("searchWord");
		
		System.out.println(searchWord);
		
		FreeBoardDAO fdao = FreeBoardDAO.getInstance();
		MarketBoardDAO mdao = MarketBoardDAO.getInstance();
		List<FreeBoardVO> fvo = fdao.selectSearchBoard(searchWord);
		List<MarketBoardVO> mvo = mdao.selectSearchBoard(searchWord);
		
		String [] mvoImg = new String[mvo.size()];
		for(int i=0; i<mvoImg.length; i++){
			String imgPath = request.getContextPath()+"/upload/"+mvo.get(i).getImgpath1(); 
			mvoImg[i] = imgPath;
		}
		request.setAttribute("mvoImg", mvoImg);
		
		request.setAttribute("fvo", fvo);
		request.setAttribute("mvo", mvo);
		
		request.getRequestDispatcher("Search/SearchView.jsp").forward(request,response);
	
	}

}
