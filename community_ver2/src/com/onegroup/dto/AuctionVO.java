package com.onegroup.dto;

import java.sql.Timestamp;

public class AuctionVO {
	private int boardNum;
	private int startPrice;
	private int endPrice;
	private int auctionTime;
	private Timestamp writedate;
	private int readcount;
	private int status; //0: 寃쎈ℓ以�  1: �뙋留ㅼ셿猷�
	private long enrollTime;
	private String winner;


	private String userid;
	private String title;
	private String content;
	private String goodsname;
	private int goodsprice;
	private String imgpath1;
	private String imgpath2;
	private String imgpath3;
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	public long getEnrollTime() {
		return enrollTime;
	}

	public void setEnrollTime(long enrollTime) {
		this.enrollTime = enrollTime;
	}
	public String getUserid() {
		return userid;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public int getGoodsprice() {
		return goodsprice;
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

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
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
	
	public int getBoardNum() {
		return boardNum;
	}

	public int getStartPrice() {
		return startPrice;
	}

	public int getEndPrice() {
		return endPrice;
	}

	public int getAuctionTime() {
		return auctionTime;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public int getReadcount() {
		return readcount;
	}

	public int getStatus() {
		return status;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public void setEndPrice(int endPrice) {
		this.endPrice = endPrice;
	}

	public void setAuctionTime(int auctionTime) {
		this.auctionTime = auctionTime;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AuctionBoardVO [boardNum=" + boardNum + ", writedate=" + writedate + ", readcount=" + readcount
				+ ", status=" + status + "]";
	}
	
}
