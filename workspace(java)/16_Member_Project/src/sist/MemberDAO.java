package sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web";
	String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	String sql = "";
	public MemberDAO() { 
		
		try {
		
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExist(String name) {
		boolean result = false;
		
		String sql = "select * from member20 where name = ?";
		
		try {
			pstmt = con.prepareCall(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
			rs.close(); pstmt.close(); con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int write(String nameData, String ageData, String weightData, String heightData, String genderData) {
		int res = 0;
		
		if(isExist(nameData)) {
			
		}
		try {
			
			sql = "insert into member20 values(?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, nameData);
			pstmt.setInt(2, Integer.parseInt(ageData));
			pstmt.setInt(3, Integer.parseInt(weightData));
			pstmt.setInt(4, Integer.parseInt(heightData));
			pstmt.setString(5, genderData);
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public void listAll(DefaultTableModel model) {
	
		try {
			sql = "select * from member20";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int weight = rs.getInt("wieght");
				int height = rs.getInt("height");
				String gender = rs.getString("gender");
				
				Object data[] = {name, age, weight, height, gender};
				model.addRow(data);
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int delete(String nameData) {
		int res = 0;
		
		try {
			sql = "delete from member20 where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nameData);
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int update(String nameData, String ageData, String weightData, String heightData, String genderData) {
		int res = 0;
		
		try {
			sql = "update member20 set age = ?, wieght = ?, height = ?, gender = ? where name = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(ageData));
			pstmt.setInt(2, Integer.parseInt(weightData));
			pstmt.setInt(3, Integer.parseInt(heightData));
			pstmt.setString(4, genderData);
			pstmt.setString(5, nameData);
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	
	
}
