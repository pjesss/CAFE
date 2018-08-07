package com.onegroup.dto;

public class SaleListVO {
	private String userid;
	private int	num;
	private String buyUserid;
	private String goodsname;
	private int goodsprice;
	private int status;	// 1: 구매자가 확정함   0: 구매자가 확정대기중 -1:구매취소
	private int boardNum;
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserid() {
		return userid;
	}
	public int getNum() {
		return num;
	}
	public String getBuyUserid() {
		return buyUserid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public int getStatus() {
		return status;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setBuyUserid(String saleUserid) {
		this.buyUserid = saleUserid;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
