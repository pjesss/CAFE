package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onegroup.dto.MarketBoardVO;

import util.DBManager;

public class MarketBoardDAO {
	private static MarketBoardDAO instance = new MarketBoardDAO();

	public static MarketBoardDAO getInstance() {
		return instance;
	}

	public List<MarketBoardVO> selectAllBoard() {
		String sql = "select * from marketboard order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<MarketBoardVO> list = new ArrayList<>();
		MarketBoardVO vo = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				vo = new MarketBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle((rs.getString("title")));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));
				vo.setStatus(rs.getInt("status"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public List<MarketBoardVO> selectBestBoard() {

		String sql = "select * from (select * from marketboard order by readcount desc) where rownum <= 4";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<MarketBoardVO> list = new ArrayList<>();
		;
		MarketBoardVO vo = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				vo = new MarketBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle((rs.getString("title")));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));
				vo.setStatus(rs.getInt("status"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public List<MarketBoardVO> selectSearchBoard(String searchWord) {
		String sql = "select * from marketboard where title like '%" + searchWord + "%' order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MarketBoardVO> list = new ArrayList<>();
		MarketBoardVO vo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MarketBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle((rs.getString("title")));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));
				vo.setStatus(rs.getInt("status"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public int insertBoard(MarketBoardVO vo) {
		int result = 0;

		String sql = "insert into marketboard(num,title,content,userid,goodsname, goodsprice, imgpath1,imgpath2,imgpath3)"
				+ "values(marketboard_seq.nextval,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getUserid());
			pstmt.setString(4, vo.getGoodsname());
			pstmt.setInt(5, vo.getGoodsprice());
			pstmt.setString(6, vo.getImgpath1());
			pstmt.setString(7, vo.getImgpath2());
			pstmt.setString(8, vo.getImgpath3());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public MarketBoardVO selectOneBoard(String num) {

		String sql = "select * from marketboard where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MarketBoardVO vo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MarketBoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));
				vo.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return vo;
	}

	public List<MarketBoardVO> selectMyBoard(String userid) {

		List<MarketBoardVO> list = new ArrayList<>();
		
		String sql = "select * from marketboard where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MarketBoardVO vo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MarketBoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setUserid(rs.getString("userid"));
				vo.setGoodsname(rs.getString("goodsname"));
				vo.setGoodsprice(rs.getInt("goodsprice"));
				vo.setImgpath1(rs.getString("imgpath1"));
				vo.setImgpath2(rs.getString("imgpath2"));
				vo.setImgpath3(rs.getString("imgpath3"));
				vo.setStatus(rs.getInt("status"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	public int updateBoard(MarketBoardVO vo) {
		int result = 0;

		String sql = "update marketboard set title=?, content=?, userid=?, "
				+ "goodsname=?, goodsprice=?, imgpath1=?, imgpath2=?, imgpath3=?, status=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getUserid());
			pstmt.setString(4, vo.getGoodsname());
			pstmt.setInt(5, vo.getGoodsprice());
			pstmt.setString(6, vo.getImgpath1());
			pstmt.setString(7, vo.getImgpath2());
			pstmt.setString(8, vo.getImgpath3());
			pstmt.setInt(9, vo.getStatus());
			pstmt.setInt(10, vo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	public int deleteBoard(String num) {
		int result = 0;

		String sql = "delete from marketboard where num=?";
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

		return result;
	}

	public void updateReadCount(String num) { // parameter는 String이다.
		String sql = "update marketboard set readcount = readcount+1 where num=?";
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

	/**
	 * 구매했다면 확정대기중이라도 판매완료 표시를 한다
	 * 
	 * @param num
	 */
	public void buyComplete(int num) {
		String sql = "update marketboard set status = 1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void buyCancel(int num) {
		String sql = "update marketboard set status = 0 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateStatusAuction(int num) {
		String sql = "update marketboard set status = 2 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
