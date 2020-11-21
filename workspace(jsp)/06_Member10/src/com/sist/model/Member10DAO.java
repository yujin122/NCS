package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Member10DAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public Member10DAO() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public List<Member10DTO> memSelect() {
		
		List<Member10DTO> list = new ArrayList();
		
		try {
			sql = "select * from member10";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member10DTO mem = new Member10DTO();
				
				mem.setNum(rs.getInt("num"));
				mem.setMemid(rs.getString("memid"));
				mem.setMemname(rs.getString("memname"));
				mem.setPwd(rs.getString("pwd"));
				mem.setAge(rs.getInt("age"));
				mem.setMileage(rs.getInt("mileage"));
				mem.setJob(rs.getString("job"));
				mem.setAddr(rs.getString("addr"));
				mem.setRegdate(rs.getString("regdate"));
				
				list.add(mem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}
