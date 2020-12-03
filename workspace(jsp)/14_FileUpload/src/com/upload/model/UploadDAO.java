package com.upload.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UploadDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static UploadDAO instance = null;
	
	public UploadDAO() {	}
	
	public static UploadDAO getInstance() {
		if(instance == null) {
			instance = new UploadDAO();
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

	public List<UploadDTO> getUpload() {
		List<UploadDTO> list = new ArrayList<UploadDTO>();
		
		openConn();
		
		sql = "select * from upload order by upload_no desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UploadDTO dto = new UploadDTO();
				
				dto.setUpload_no(rs.getInt(1));
				dto.setUpload_writer(rs.getString(2));
				dto.setUpload_title(rs.getString(3));
				dto.setUpload_cont(rs.getString(4));
				dto.setUpload_pwd(rs.getString(5));
				dto.setUpload_file(rs.getString(6));
				dto.setUpload_hit(rs.getInt(7));
				dto.setUpload_date(rs.getString(8));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}

		return list;
	}

	public int insertUpload(UploadDTO dto) {
		int res = 0;
		
		openConn();
	
		try {
			sql = "select max(upload_no) from upload";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int num = rs.getInt(1);
				
				sql = "insert into upload values(?, ?, ?, ?, ?, ?, default, sysdate)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num+1);
				pstmt.setString(2, dto.getUpload_writer());
				pstmt.setString(3, dto.getUpload_title());
				pstmt.setString(4, dto.getUpload_cont());
				pstmt.setString(5, dto.getUpload_pwd());
				pstmt.setString(6, dto.getUpload_file());
				
				res = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return res;
	}

	public UploadDTO getUpload(int num) {
		UploadDTO dto = new UploadDTO();
		
		openConn();
		
		sql = "select * from upload where upload_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setUpload_no(rs.getInt(1));
				dto.setUpload_writer(rs.getString(2));
				dto.setUpload_title(rs.getString(3));
				dto.setUpload_cont(rs.getString(4));
				dto.setUpload_pwd(rs.getString(5));
				dto.setUpload_file(rs.getString(6));
				dto.setUpload_hit(rs.getInt(7));
				dto.setUpload_date(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
			
		}	
		
		return dto;
	}

	public void uploadHit(int num) {
		
		openConn();
		
		sql = "update upload set upload_hit = upload_hit+1 where upload_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
			
		}
		
		
	}
}
