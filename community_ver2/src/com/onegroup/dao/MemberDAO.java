package com.onegroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onegroup.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public int userCheck(String userid, String pw) {

		String sql = "select pw from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		System.out.println(userid + "와" + pw);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pw").equals(pw)) {
					result = 1; // 로그인 성공
				} else {
					result = 0; // 비밀번호가 틀렸다.
				}
			} else {
				result = -1; // 아이디가 없다
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	public MemberVO getMember(String userid) {
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVO();
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPw(rs.getString("pw"));
				vo.setAge(rs.getInt("age"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setUsermoney(rs.getInt("usermoney"));
				vo.setUserlevel(rs.getInt("userlevel"));
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return vo;
	}

	public String getMember(String name, String phone) {
		String sql = "select userid from member where name=? and phone=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getString("userid");
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println("getmember = " + result);
		return result;
	}

	public String getMember(String userid, String name, String phone) {
		String sql = "select pw from member where (userid=? and name=?) and phone=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();

			
			if (rs.next()) {
				result = rs.getString("pw");
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		System.out.println("비밀번호 :" + result);
		return result;
	}

	public int confirmID(String userid) {
		System.out.println("confirmID dao하러 왔스므니다");
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql); // conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); // pstmt.executeQuery();
			if (rs.next()) {
				result = 1; // id가 있다 -> 해당 아이디 사용불가
			} else {
				result = -1; // id가 없다 -> 해당 아이디 사용가능
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		// #24] 다시 서블릿으로 결과값을 들고 가자
		return result;
	}

	public int insertMember(MemberVO vo) {
		int result = 0;
		String sql = "insert into member values(?,?,?,?,?,?,?,0,0)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPw());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getAddress());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	public void updateMember(MemberVO vo) {
		String sql = "update member set name=?, pw=?, email=?, phone=?, address=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getUserid());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
		System.out.println("수행결과" + result);
		
	}

	public int deleteMember(String userid){
		int result = 0;
		String sql="delete from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	
	public int minusUsermoney(String userid, int money){
		int result = 0;
		String sql="update member set usermoney=usermoney-? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}		
		
		return result;
	}
	public int plusUsermoney(String userid, int money){
		int result = 0;
		String sql="update member set usermoney=usermoney+? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}		
		
		System.out.println(userid+"의 머니에서 "+money+" 만큼 추가");
		
		return result;
	}
	
	
	
	
	/*
	 * public int userCheck(String userid, String pw){
	 * 
	 * String sql=""; Connection conn = null; PreparedStatement pstmt = null;
	 * ResultSet rs = null; try{ conn = DBManager.getConnectin(); pstmt =
	 * conn.prepareStatement(sql); //conn.prepareStatement(sql);
	 * 
	 * rs = pstmt.executeQuery(sql); // pstmt.executeQuery(); if(rs.next()){
	 * result = 1; //id가 있다 -> 해당 아이디 사용불가 }else{ result = -1; //id가 없다 -> 해당
	 * 아이디 사용가능 } }catch(Exception e){ e.printStackTrace(); }finally {
	 * DBManager.close(conn, pstmt, rs); }
	 * 
	 * return 0; }
	 */
}
