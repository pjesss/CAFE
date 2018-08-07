package com.onegroup.dto;

public class BuyListVO {
	private String userid;
	private int	num;
	private String saleUserid;
	private String goodsname;
	private int goodsprice;
	private int transMoney;
	private int status; // 1:확정완료 0: 확정대기 -1:확정취소
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
	public String getSaleUserid() {
		return saleUserid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public int getTransMoney() {
		return transMoney;
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
	public void setSaleUserid(String saleUserid) {
		this.saleUserid = saleUserid;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
	}
	public void setTransMoney(int transMoney) {
		this.transMoney = transMoney;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
