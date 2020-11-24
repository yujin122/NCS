package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	// 싱글톤 방식으로 객체를 만들어 보자
	// 1. 싱클톤 객체를 만들기 위해서는 우선적으로 접근지정자는 private
	//	    으로 선언을 해야 함.
	// 2. 정적 멤버로 선언을 해야 함. - static으로 선언을 한다는 의미
	private static MemberDAO instance = null;
	
	// 3. 외부에서 객체 생성을 못하게 접근을 제어 - private 생성자를 만듬.
	private MemberDAO() { 	}
	
	// 4. 생성자 대신에 싱글턴 객체를 return을 해 주는 getInstance()
	// 	    메서드를 만들어서 접근하게 하는 방법
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	// DB 연결 작업 진행하는 메서드
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
	
	
	public List<Member10DTO> memSelect() {
		
		List<Member10DTO> list = new ArrayList();
		
		try {
			openConn();
			
			sql = "select * from member10 order by num";
			
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
			
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

	public int insertMem(Member10DTO dto) {
		
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

	public Member10DTO contentMember(int mem_no) {
		
		Member10DTO mem = new Member10DTO();
		
		sql = "select * from member10 where num = ?";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mem_no);
			
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

	public int updateMember(Member10DTO dto) {
		
		int res = 0;
		
		sql = "update member10 set pwd = ?, age = ?, mileage = ?, job = ?, addr = ? where num = ? ";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPwd());
			pstmt.setInt(2, dto.getAge());
			pstmt.setInt(3, dto.getMileage());
			pstmt.setString(4, dto.getJob());
			pstmt.setString(5, dto.getAddr());
			pstmt.setInt(6, dto.getNum());
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int deleteMem(int no) {
		
		int res = 0;
		
		sql = "delete from member10 where num = ?";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
}
