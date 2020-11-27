package com.mem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.session.PersistentManager;

public class MemberDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static MemberDAO instance = null;
	
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

	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		sql = "select * from member10 order by num";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setNum(rs.getInt(1));
				dto.setMemid(rs.getString(2));
				dto.setMemname(rs.getString(3));
				dto.setPwd(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setMileage(rs.getInt(6));
				dto.setJob(rs.getString(7));
				dto.setAddr(rs.getString(8));
				dto.setRegdate(rs.getString(9));
				
				list.add(dto);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int insertMem(MemberDTO dto) {
		int res = 0;
		
		sql = "insert into member10 values(member10_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMemid());
			pstmt.setString(2, dto.getMemname());
			pstmt.setString(3, dto.getPwd());
			pstmt.setInt(4, dto.getAge());
			pstmt.setInt(5, dto.getMileage());
			pstmt.setString(6, dto.getJob());
			pstmt.setString(7, dto.getAddr());
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public MemberDTO getMemberInfo(int num) {
		
		MemberDTO mem = new MemberDTO();
			
		sql = "select * from member10 where num = ?";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				mem.setNum(rs.getInt("num"));
				mem.setMemid(rs.getString("memid"));
				mem.setMemname(rs.getString("memname"));
				mem.setPwd(rs.getString("pwd"));
				mem.setAge(rs.getInt("age"));
				mem.setMileage(rs.getInt("mileage"));
				mem.setJob(rs.getString("job"));
				mem.setAddr(rs.getString("addr"));
				mem.setRegdate(rs.getString("regdate"));
				
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}

	public int updateMember(MemberDTO dto) {
		int res = 0;
		
		try {
			openConn();
			
			sql = "select * from member10 where num = ?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(dto.getPwd())) {
					sql = "update member10 set pwd = ?, age = ?, mileage = ?, job = ?, addr = ? where num = ? ";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, dto.getPwd());
					pstmt.setInt(2, dto.getAge());
					pstmt.setInt(3, dto.getMileage());
					pstmt.setString(4, dto.getJob());
					pstmt.setString(5, dto.getAddr());
					pstmt.setInt(6, dto.getNum());
					
					res = pstmt.executeUpdate();
				}else {
					res = -1;
				}
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int updateMember(int no, String pwd) {
		int res = 0;
		
		try {
			openConn();
			
			sql = "select * from member10 where num = ?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					sql = "delete from member10 where num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					
					res = pstmt.executeUpdate();
				}else {
					res = -1;
				}
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public List<MemberDTO> searchMember(String search, String text) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		openConn();
		
		try {
			if(search.equals("name")) {
				sql = "select * from member10 where memname like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				
			}else if(search.equals("addr")) {
				sql = "select * from member10 where addr like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				
			}else if(search.equals("id")) {
				sql = "select * from member10 where memid like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setNum(rs.getInt(1));
				dto.setMemid(rs.getString(2));
				dto.setMemname(rs.getString(3));
				dto.setPwd(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setMileage(rs.getInt(6));
				dto.setJob(rs.getString(7));
				dto.setAddr(rs.getString(8));
				dto.setRegdate(rs.getString(9));
				
				list.add(dto);
			}
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
