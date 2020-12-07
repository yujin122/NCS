package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminShopDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PWD_FAIL = -1;
	public static final int ADMIN_LOGIN_NONEXIST = -2;
	
	
	private static AdminShopDAO instance = null;
	
	public AdminShopDAO() {	}
	
	
	public static AdminShopDAO getInstance() {
		
		if(instance == null) {
			instance = new AdminShopDAO();
		}
		
		return instance;
	}
	
	public void openConn() {
		
		try {
			// 1. JNDI 서버 객체 생성
			InitialContext ic = new InitialContext();
			
			// 2. lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
			
			// 3. DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
			
			if(con ==null) {
				System.out.println("연결오류");
			}
			
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


	public int adminLogin(AdminShopDTO dto) {
		int res = 0;
		
		openConn();
		
		try {
			sql = "select admin_pwd from admin_shop where admin_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getAdmin_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(dto.getAdmin_pwd())) {
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


	public AdminShopDTO getAdminCont(String id) {
		AdminShopDTO dto = new AdminShopDTO();
		
		openConn();
		
		sql = "select * from admin_shop where admin_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setAdmin_id(rs.getString(1));
				dto.setAdmin_pwd(rs.getString(2));
				dto.setAdmin_name(rs.getString(3));
				dto.setAdmin_email(rs.getString(4));
				dto.setAdmin_regdate(rs.getString(5));
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
