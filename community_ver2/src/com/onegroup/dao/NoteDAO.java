package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onegroup.dto.MemberVO;
import com.onegroup.dto.NoteVO;

import util.DBManager;

public class NoteDAO {
	private NoteDAO() {
	}

	private static NoteDAO instance = new NoteDAO();

	public static NoteDAO getInstance() {
		return instance;
	}

	public List<NoteVO> getNoteAll(String userid) {

		List<NoteVO> list = new ArrayList<NoteVO>();

		String sql = "select * from note where userid=? order by notenum desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoteVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new NoteVO();
				vo.setNotenum(rs.getInt("notenum"));
				vo.setToid(rs.getString("toid"));
				vo.setUserid(rs.getString("userid"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNotedate(rs.getTimestamp("notedate"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<NoteVO> getSendNoteAll(String userid) {

		List<NoteVO> list = new ArrayList<NoteVO>();

		String sql = "select * from note where toid=? order by notenum desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoteVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new NoteVO();
				vo.setNotenum(rs.getInt("notenum"));
				vo.setToid(rs.getString("toid"));
				vo.setUserid(rs.getString("userid"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNotedate(rs.getTimestamp("notedate"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public NoteVO getNote(int notenum) {

		String sql = "select * from note where notenum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoteVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notenum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new NoteVO();
				vo.setNotenum(rs.getInt("notenum"));
				vo.setToid(rs.getString("toid"));
				vo.setUserid(rs.getString("userid"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNotedate(rs.getTimestamp("notedate"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	public void sendNote(String toid, String userid, String title, String content) {

		String sql = "insert into note (notenum, toid, userid, title, content) values (note_seq.nextval,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, toid);
			pstmt.setString(2, userid);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("쪽지 성공했니?"+result);
	}
	
	
	public void deleteNote(int notenum) {

		String sql = "delete from note where notenum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notenum);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("쪽지 삭제 성공했니?"+result);
	}

	
}

/*
 * public int userCheck(String userid, String pw){
 * 
 * String sql=""; Connection conn = null; PreparedStatement pstmt = null;
 * ResultSet rs = null; try{ conn = DBManager.getConnectin(); pstmt =
 * conn.prepareStatement(sql); //conn.prepareStatement(sql);
 * 
 * rs = pstmt.executeQuery(sql); // pstmt.executeQuery(); if(rs.next()){ result
 * = 1; //id가 있다 -> 해당 아이디 사용불가 }else{ result = -1; //id가 없다 -> 해당 아이디 사용가능 }
 * }catch(Exception e){ e.printStackTrace(); }finally { DBManager.close(conn,
 * pstmt, rs); }
 * 
 * return 0; }
 */