package com.board3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BbsDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static BbsDAO instance = null;
	
	public BbsDAO() {	}
	
	
	public static BbsDAO getInstance() {
		
		if(instance == null) {
			instance = new BbsDAO();
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


	public List<BbsDTO> getBbsList() {
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		
		openConn();
		
		sql = "select * from jsp_bbs order by board_group desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				
				dto.setBoard_no(rs.getInt(1));
				dto.setBoard_writer(rs.getString(2));
				dto.setBoard_title(rs.getString(3));
				dto.setBoard_cont(rs.getString(4));
				dto.setBoard_pwd(rs.getString(5));
				dto.setBoard_hit(rs.getInt(6));
				dto.setBoard_date(rs.getString(7));
				dto.setBoard_group(rs.getInt(8));
				dto.setBoard_step(rs.getInt(9));
				dto.setBoard_indent(rs.getInt(10));
				
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


	public int writeBbs(BbsDTO dto) {
		int res = 0;
		
		openConn();
		
		sql = "insert into jsp_bbs values(bbs_seq.nextval, ?, ?, ?, ?, default, sysdate, bbs_seq.currval, 0, 0)";		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_writer());
			pstmt.setString(2, dto.getBoard_title());
			pstmt.setString(3, dto.getBoard_cont());
			pstmt.setString(4, dto.getBoard_pwd());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}


	public BbsDTO getBbsPost(int num) {
		BbsDTO dto = new BbsDTO();
		
		openConn();
		
		sql = "select * from jsp_bbs where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setBoard_no(rs.getInt(1));
				dto.setBoard_writer(rs.getString(2));
				dto.setBoard_title(rs.getString(3));
				dto.setBoard_cont(rs.getString(4));
				dto.setBoard_pwd(rs.getString(5));
				dto.setBoard_hit(rs.getInt(6));
				dto.setBoard_date(rs.getString(7));
				dto.setBoard_group(rs.getInt(8));
				dto.setBoard_step(rs.getInt(9));
				dto.setBoard_indent(rs.getInt(10));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		return dto;
	}


	public void setBbsHit(int num) {
		openConn();
		
		sql = "update jsp_bbs set board_hit = board_hit+1 where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public int updateBbs(BbsDTO dto) {
		int res = 0;
		
		openConn();

		try {
			sql = "select board_pwd from jsp_bbs where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(dto.getBoard_pwd())) {
					sql = "update jsp_bbs set board_title = ?, board_cont = ?, board_writer = ? where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, dto.getBoard_title());
					pstmt.setString(2, dto.getBoard_cont());
					pstmt.setString(3, dto.getBoard_writer());
					pstmt.setInt(4, dto.getBoard_no());
					
					res = pstmt.executeUpdate();
				}else {
					res = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}	
		return res;
	}


	public int deleteBbs(int num, String pwd) {
		int res = 0;
		
		openConn();
		
		try {
			sql = "select board_pwd from jsp_bbs where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pwd)) {
					sql = "delete from jsp_bbs where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					
					res = pstmt.executeUpdate();
					
				}else {
					res = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}

}
