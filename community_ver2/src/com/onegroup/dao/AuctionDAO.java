package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onegroup.dto.AuctionVO;

import util.DBManager;

public class AuctionDAO {
	private static AuctionDAO instance = new AuctionDAO();

	public static AuctionDAO getInstance() {
		return instance;
	}

	public void insertBoard(int boardNum, int startPrice, int auctionTime, long enrollTime) {
		String sql = "insert into auction (boardnum, startprice, endPrice, auctiontime, enrolltime)" + "values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.setInt(2, startPrice);
			pstmt.setInt(3, startPrice);
			pstmt.setInt(4, auctionTime);
			pstmt.setLong(5, enrollTime);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<AuctionVO> getAllList() {
		List<AuctionVO> list = new ArrayList<>();

		String sql = "select * from auction, marketboard where auction.boardNum=marketboard.num";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		AuctionVO vo = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				vo = new AuctionVO();
				vo.setAuctionTime(rs.getInt("auctionTime"));
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setEndPrice(rs.getInt("endPrice"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setStartPrice(rs.getInt("startPrice"));
				vo.setStatus(rs.getInt("status"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setEnrollTime(rs.getLong("enrolltime"));
				vo.setWinner(rs.getString("winner"));

				vo.setContent(rs.getString("content"));
				vo.setTitle((rs.getString("title")));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}

		return list;
	}

	public AuctionVO getOneList(String num) {

		String sql = "select * from auction, marketboard where auction.boardNum=marketboard.num and boardNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		AuctionVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new AuctionVO();
				vo.setAuctionTime(rs.getInt("auctionTime"));
				vo.setBoardNum(rs.getInt("boardNum"));
				vo.setEndPrice(rs.getInt("endPrice"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setStartPrice(rs.getInt("startPrice"));
				vo.setStatus(rs.getInt("status"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setEnrollTime(rs.getLong("enrolltime"));
				vo.setWinner(rs.getString("winner"));

				vo.setContent(rs.getString("content"));
				vo.setTitle((rs.getString("title")));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return vo;
	}

	public void deleteAuction(String num) {

		String sql = "delete from auction where boardNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num) { // parameter는 String이다.
		String sql = "update auction set readcount = readcount+1 where boardNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updatePrice(String boardNum, String endprice, String winner) { 
		String sql = "update auction set endprice=?, winner=? where boardNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(endprice));
			pstmt.setString(2, winner);
			pstmt.setInt(3, Integer.parseInt(boardNum));
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void updateStatus(int boardNum) { // parameter는 String이다.
		String sql = "update auction set status = 1 where boardNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	
	
	
	
}
	

	
