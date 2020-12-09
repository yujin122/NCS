package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static MemberDAO instance = null;
	
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PWD_FAIL = -1;
	public static final int ADMIN_LOGIN_NONEXIST = -2;
	
	
	public MemberDAO() {	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		
		return instance;
	}
	
	public void openConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {
	
			try {
				
				if(rs != null)	rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public int memberLogin(MemberDTO dto) {
		int res = 0;
		
		openConn();
		
		try {
			sql = "select pwd from member10 where memid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(dto.getPwd())) {
					res = ADMIN_LOGIN_SUCCESS;
				}else {
					res = ADMIN_LOGIN_PWD_FAIL;
				}
			}else {
				res = ADMIN_LOGIN_NONEXIST;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}

	public MemberDTO getMemberCont(String id) {
		MemberDTO dto = new MemberDTO();
		
		openConn();
		
		sql = "select * from member10 where memid = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt(1));
				dto.setMemid(rs.getString(2));
				dto.setMemname(rs.getString(3));
				dto.setPwd(rs.getString(4));				
				dto.setAge(rs.getInt(5));
				dto.setMileage(rs.getInt(6));
				dto.setJob(rs.getString(7));
				dto.setAddr(rs.getString(8));
				dto.setRegdate(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
	}
}
