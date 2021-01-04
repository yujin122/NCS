package com.shop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static CartDAO instance = null;
	
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PWD_FAIL = -1;
	public static final int ADMIN_LOGIN_NONEXIST = -2;
	
	
	public CartDAO() {	}
	
	public static CartDAO getInstance() {
		if(instance == null) {
			instance = new CartDAO();
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

	public int insertCart(CartDTO dto) {
		int res = 0;
		
		openConn();
		
		sql = "insert into cart values(cart_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCart_pnum());
			pstmt.setString(2, dto.getCart_pname());
			pstmt.setInt(3, dto.getCart_pqty());
			pstmt.setInt(4, dto.getCart_price());
			pstmt.setString(5, dto.getCart_pspec());
			pstmt.setString(6, dto.getCart_pimage());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		
		return res;
	}

	public List<CartDTO> getCartList() {
		List<CartDTO> list = new ArrayList<CartDTO>();
		
		openConn();
		
		sql = "select * from cart order by cart_num desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				
				dto.setCart_num(rs.getInt(1));
				dto.setCart_pnum(rs.getInt(2));
				dto.setCart_pname(rs.getString(3));
				dto.setCart_pqty(rs.getInt(4));
				dto.setCart_price(rs.getInt(5));
				dto.setCart_pspec(rs.getString(6));
				dto.setCart_pimage(rs.getString(7));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}

	public int deleteCart(int num) {
		int res = 0;
		
		openConn();
		
		sql = "delete from cart where cart_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
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
