package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onegroup.dto.BuyListVO;
import com.onegroup.dto.SaleListVO;

import util.DBManager;


public class SaleListDAO {
	private static SaleListDAO instance = new SaleListDAO();
	
	public static SaleListDAO getInstance(){
		return instance;
	}
	
	public int addSaleList(SaleListVO vo){
		int result = 0;
		
		String sql = "insert into salelist values(salelist_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoardNum());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getBuyUserid());
			pstmt.setString(4, vo.getGoodsname());
			pstmt.setInt(5, vo.getGoodsprice());
			pstmt.setInt(6, vo.getStatus());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	public List<SaleListVO> getSaleList(String userid){
		List<SaleListVO> list = new ArrayList<>();
		
		String sql = "select * from (select * from salelist where userid=?) order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		SaleListVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new SaleListVO();
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setNum(rs.getInt("num"));
				vo.setBuyUserid(rs.getString("buyUserid"));
				vo.setStatus(rs.getInt("status"));
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
	
	public int buyComplete(int boardNum){
		int result = 0;
		String sql = "update salelist set status=1 where boardNum=?";
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
		System.out.println("salelist의 "+boardNum+" 번호의 상품 목록 구매확정!");
		return result;
	}
	public int buyCancel(int boardNum, int status){
		int result = 0;
		String sql = "update salelist set status=-1 where boardNum=? and status=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.setInt(2, status);
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		System.out.println("salelist의 "+boardNum+" 번호의 상품 목록 구매확정!");
		return result;
	}
	
	public int deleteSaleList(String[] arrNum){
		int result = 0;
		String sql = "delete from salelist where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		BuyListVO vo = null;
		try{
			conn = DBManager.getConnection();
			for(String num : arrNum){
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(num));
				pstmt.executeUpdate();
				System.out.println(num);
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
