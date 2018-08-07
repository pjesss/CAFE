package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.onegroup.dto.FreeBoardVO;

import util.DBManager;

public class FreeBoardDAO {
	public static FreeBoardDAO instance = new FreeBoardDAO();
	public static FreeBoardDAO getInstance(){
		return instance;
	}
	public List<FreeBoardVO> selectAllBoard(){
		String sql = "select*from freeboard order by num desc";
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;
		List<FreeBoardVO> list = new ArrayList<>();
		FreeBoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				vo = new FreeBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				list.add(vo);
				
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		
		return list;
	}
	public List<FreeBoardVO> selectBestBoard(){
		String sql = "select*from freeboard where rownum<=5 order by readcount desc, writedate desc";
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;
		List<FreeBoardVO> list = new ArrayList<>();
		FreeBoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				vo = new FreeBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				list.add(vo);
				
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		
		return list;
	}
	
	
	public List<FreeBoardVO> selectSearchBoard(String searchWord){
		System.out.println("검색어" + searchWord);
		String sql = "select * from freeboard where title like '%"+searchWord+"%' order by num desc";
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<FreeBoardVO> list = new ArrayList<>();
		FreeBoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new FreeBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(vo);
				
				System.out.println(vo.getTitle());
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	public void insertFreeBoard (FreeBoardVO vo){
		String sql = "insert into freeboard (num, userid, title, content)"
				+ "values (board_seq.nextval,?,?,?)";
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public FreeBoardVO selectOneFreeBoard(String num){
		String sql = "select * from freeboard where num=?";
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		FreeBoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo = new FreeBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	

	public void updateBoard(FreeBoardVO vo) {
		String sql = "update freeboard set title=?, content=?, writedate=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setTimestamp(3, vo.getWritedate());
			pstmt.setInt(4, vo.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	public void delete(String num){
		String sql = "delete from freeboard where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	public List<FreeBoardVO> selectMyViewBoard(String userid){
		String sql = "select*from freeboard where userid=?";
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<FreeBoardVO> list = new ArrayList<>();
		FreeBoardVO vo = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new FreeBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setNum(rs.getInt("num"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setUserid(rs.getString("userid"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				list.add(vo);
				
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	
	
	public void updateReadCount(String num){ 
		String sql = "update freeboard set readcount = readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	
	
	
}

	



