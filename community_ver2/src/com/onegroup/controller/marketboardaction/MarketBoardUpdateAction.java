package com.onegroup.controller.marketboardaction;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onegroup.controller.loginaction.Action;
import com.onegroup.dao.MarketBoardDAO;
import com.onegroup.dto.MarketBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MarketBoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int num = 0;
		String title = "";
		String userid = "";
		String content = "";
		String goodsname = "";	
		int goodsprice = 0;
		
		String img[] = new String[3];
		String imgSysName[] = new String[3];
		
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 5*1204*1204;
		MultipartRequest multi = null;
		
		try{
			multi = new MultipartRequest(
					request,
					uploadPath,
					size,
					"utf-8",
					new DefaultFileRenamePolicy());
			num = Integer.parseInt(multi.getParameter("num"));
			title = multi.getParameter("title");
			userid = multi.getParameter("userid");
			content = multi.getParameter("content");
			goodsname = multi.getParameter("goodsname");
			goodsprice = Integer.parseInt(multi.getParameter("goodsprice"));

			Enumeration<String> en = multi.getFileNames();

			for(int i=0; i<3; i++){
				img[i] = en.nextElement();
				imgSysName[i] = multi.getFilesystemName(img[i]);
				if(imgSysName[i] == null){
					imgSysName[i] = "none";
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		MarketBoardVO vo = new MarketBoardVO();
		vo.setNum(num);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setUserid(userid);
		vo.setGoodsname(goodsname);
		vo.setGoodsprice(goodsprice);
		vo.setImgpath1(imgSysName[2]);
		vo.setImgpath2(imgSysName[1]);
		vo.setImgpath3(imgSysName[0]);
		System.out.println(vo);
		MarketBoardDAO.getInstance().updateBoard(vo);
		
		new MarketBoardListAction().execute(request, response);
	}

}
