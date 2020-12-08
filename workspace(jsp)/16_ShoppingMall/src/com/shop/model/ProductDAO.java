package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static ProductDAO instance = null;
	
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PWD_FAIL = -1;
	public static final int ADMIN_LOGIN_NONEXIST = -2;
	
	
	public ProductDAO() {	}
	
	public static ProductDAO getInstance() {
		if(instance == null) {
			instance = new ProductDAO();
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

	public int insertProduct(ProductDTO dto) {
		int res = 0;
		int cnt = 0;
		
		openConn();
		
		try {
			sql = "select max(pnum) from shop_products";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1)+1;
			}else {
				cnt = 1;
			}
			
			sql = "insert into shop_products values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cnt);
			pstmt.setString(2, dto.getPname());
			pstmt.setString(3, dto.getPcategory());
			pstmt.setString(4, dto.getPcompany());
			pstmt.setString(5, dto.getPimage());
			pstmt.setInt(6, dto.getPqty());
			pstmt.setInt(7, dto.getPrice());
			pstmt.setString(8, dto.getPspec());
			pstmt.setString(9, dto.getPcontent());
			pstmt.setInt(10, dto.getPoint());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}

	public List<ProductDTO> getProductList() {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		openConn();
		
		sql = "select * from shop_products";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setPnum(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setPcategory(rs.getString(3));
				dto.setPcompany(rs.getString(4));
				dto.setPimage(rs.getString(5));
				dto.setPqty(rs.getInt(6));
				dto.setPrice(rs.getInt(7));
				dto.setPspec(rs.getString(8));
				dto.setPcontent(rs.getString(9));
				dto.setPoint(rs.getInt(10));
				dto.setPinputdate(rs.getString(11));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeConn(rs, pstmt, con);
		}
		
		
		return list;
	}

	public ProductDTO getProduct(int pnum) {
		 ProductDTO dto = new ProductDTO();
		 
		 openConn();
		 
		 sql = "select * from shop_products where pnum = ?";
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setPnum(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setPcategory(rs.getString(3));
				dto.setPcompany(rs.getString(4));
				dto.setPimage(rs.getString(5));
				dto.setPqty(rs.getInt(6));
				dto.setPrice(rs.getInt(7));
				dto.setPspec(rs.getString(8));
				dto.setPcontent(rs.getString(9));
				dto.setPoint(rs.getInt(10));
				dto.setPinputdate(rs.getString(11));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		 
		 return dto;
	}

	public int updateProduct(ProductDTO dto) {
		int res = 0;
		
		openConn();
		
		sql = "update shop_products set pname = ?, pcategory_fk = ?, "
				+ "pcompany = ?, pimage = ?, pqty = ?, price = ?, pspec = ?, "
				+ "pcontents = ?, point = ? "
				+ "where pnum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPcategory());
			pstmt.setString(3, dto.getPcompany());
			pstmt.setString(4, dto.getPimage());
			pstmt.setInt(5, dto.getPqty());
			pstmt.setInt(6, dto.getPrice());
			pstmt.setString(7, dto.getPspec());
			pstmt.setString(8, dto.getPcontent());
			pstmt.setInt(9, dto.getPoint());
			pstmt.setInt(10, dto.getPnum());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		return res;
	}

	public int deleteProduct(int pnum) {
		int res = 0;
		
		openConn();
		
		sql = "delete from shop_products where pnum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}
}
