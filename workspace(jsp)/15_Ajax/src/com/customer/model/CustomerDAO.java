package com.customer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static CustomerDAO instance = null;
	
	public CustomerDAO() {	}
	
	public static CustomerDAO getInstance() {
		if(instance == null) {
			instance = new CustomerDAO();
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

	public String getCustomerList() {
		String result = "";
		
		openConn();
		
		sql = "select * from customer";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//result += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			result += "<customers>";
			
			while(rs.next()) {
				result += "<customer>";
				
				result += "<no>" + rs.getInt(1) + "</no>";
				result += "<name>" + rs.getString(2) + "</name>";
				result += "<id>" + rs.getString(3) + "</id>";
				result += "<age>" + rs.getInt(4) + "</age>";
				result += "<tel>" + rs.getString(5) + "</tel>";
				result += "<addr>" + rs.getString(6) + "</addr>";
				
				result += "</customer>";
			}
			result += "</customers>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
	
		return result;
	}

	public String checkCustomerId(String userId) {
		String res = "사용 가능합니다.";
		
		openConn();
		
		sql = "select id from customer where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = "중복된 아이디가 있습니다.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}

	public int insertCustomer(CustomerDTO dto) {
		int res = 0;
		
		openConn();
		
		sql = "insert into customer values(customer_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddr());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		
		return res;
	}

	public int delete(int user_no) {
		int res = 0;
		
		openConn();
		
		sql = "delete from customer where no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			
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
