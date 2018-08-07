package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onegroup.dto.BuyListVO;

import util.DBManager;


public class BuyListDAO {
	private static BuyListDAO instance = new BuyListDAO();
	
	public static BuyListDAO getInstance(){
		return instance;
	}
	
	public int addBuyList(BuyListVO vo){
		int result = 0;
		
		String sql = "insert into buylist values(buylist_seq.nextval,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoardNum());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getSaleUserid());
			pstmt.setString(4, vo.getGoodsname());
			pstmt.setInt(5, vo.getGoodsprice());
			pstmt.setInt(6, vo.getTransMoney());
			pstmt.setInt(7, vo.getStatus());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	public List<BuyListVO> getBuyList(String userid){
		List<BuyListVO> list = new ArrayList<>();
		
		String sql = "select * from (select * from buylist where userid=?) order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BuyListVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new BuyListVO();
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setNum(rs.getInt("num"));
				vo.setSaleUserid(rs.getString("saleUserid"));
				vo.setStatus(rs.getInt("status"));
				vo.setTransMoney(rs.getInt("transMoney"));
				vo.setUserid(rs.getString("userid"));
				list.add(vo);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	public BuyListVO getOneBuyList(String num){
		
		String sql = "select * from buylist where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BuyListVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new BuyListVO();
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setNum(rs.getInt("num"));
				vo.setSaleUserid(rs.getString("saleUserid"));
				vo.setStatus(rs.getInt("status"));
				vo.setTransMoney(rs.getInt("transMoney"));
				vo.setUserid(rs.getString("userid"));
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
		
	}
	
	public int buyComplete(String num){
		int result = 0;
		String sql = "update buylist set status=1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		System.out.println("buylist의 "+num+" 번호의 상품 목록 구매확정!");
		
		return result;
	}
	public int buyCancel(int boardNum){
		int result = 0;
		String sql = "update buylist set status=-1 where boardNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		System.out.println("buylist의 "+boardNum+" 번호의 상품 목록 구매확정!");
		
		return result;
	}
	
	public int minusTransMoney(String num){
		int result = 0;
		String sql = "update buylist set transMoney=0 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		BuyListVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		System.out.println(num+"번호 구매목록의 transMoney를 0으로 함");
		return result;
	}
	
	public int deleteBuyList(String[] arrNum){
		int result = 0;
		String sql = "delete from buylist where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		BuyListVO vo = null;
		try{
			conn = DBManager.getConnection();
			for(String num : arrNum){
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(num));
				pstmt.executeUpdate();
				result++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
}





















