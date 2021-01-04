package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminShopDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static AdminShopDAO instance = null;
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PWD_FAIL = -1;
	public static final int ADMIN_LOGIN_NONEXIST = -2;
	
	
	public AdminShopDAO() {	}
	
	public static AdminShopDAO getInstance() {
		if(instance == null) {
			instance = new AdminShopDAO();
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
