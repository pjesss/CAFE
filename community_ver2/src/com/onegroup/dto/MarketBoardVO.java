package com.onegroup.dto;

import java.sql.Timestamp;

public class MarketBoardVO {
	private int num;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
	private String userid;
	private String goodsname;
	private int goodsprice;
	private String imgpath1;
	private String imgpath2;
	private String imgpath3;
	private int status; //1:판매완료  0:판매중
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getReadcount() {
		return readcount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public String getUserid() {
		return userid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
	}
	public String getImgpath1() {
		return imgpath1;
	}
	public String getImgpath2() {
		return imgpath2;
	}
	public String getImgpath3() {
		return imgpath3;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setImgpath1(String imgpath1) {
		this.imgpath1 = imgpath1;
	}
	public void setImgpath2(String imgpath2) {
		this.imgpath2 = imgpath2;
	}
	public void setImgpath3(String imgpath3) {
		this.imgpath3 = imgpath3;
	}
	
}
