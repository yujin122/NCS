package com.conn.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	private static BoardDAO instance = null;
	
	public BoardDAO() {	}
	
	
	public static BoardDAO getInstance() {
		
		if(instance == null) {
			instance = new BoardDAO();
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


	public List<BoardDTO> getBoardList() {
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		sql = "select * from board order by board_no desc";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setNum(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCont(rs.getString(4));
				dto.setPwd(rs.getString(5));
				dto.setHit(rs.getInt(6));
				dto.setRegdate(rs.getString(7));
				
				list.add(dto);
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public BoardDTO getBoardPost(int num) {
		BoardDTO dto = new BoardDTO();
		
		sql = "select * from board where board_no = ?";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				dto.setNum(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCont(rs.getString(4));
				dto.setPwd(rs.getString(5));
				dto.setHit(rs.getInt(6));
				dto.setRegdate(rs.getString(7));
				
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}


	public int boardWrite(BoardDTO dto) {

		int res = 0;
		
		sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, default, sysdate)";
		
		try {
			openConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getCont());
			pstmt.setString(4, dto.getPwd());
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}


	public int boardUpdate(BoardDTO dto) {
		
		int res = 0;
	
		try {
			openConn();
			
			sql = "select * from board where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("board_pwd").equals(dto.getPwd())) {
					
					sql = "update board set board_writer = ?, board_title = ?, board_cont = ? where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getWriter());
					pstmt.setString(2, dto.getTitle());
					pstmt.setString(3, dto.getCont());
					pstmt.setInt(4, dto.getNum());
					
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


	public int boardDelete(int num, String pwd) {
		int res = 0;
		

		try {
			openConn();
			
			sql = "select * from board where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("board_pwd").equals(pwd)) {
					
					sql = "delete board where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					
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


	public void upHit(int num) {
		
		try {
			openConn();
			
			sql = "update board set board_hit = board_hit+1 where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}


	public List<BoardDTO> boardSearch(String category, String text) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
			
			try {
				openConn();
				
				if(category.equals("title")) {
					sql = "select * from board where board_title like ? order by board_no desc";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+text+"%");
					
				}else if(category.equals("writer")) {
					sql = "select * from board where board_writer like ? order by board_no desc";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+text+"%");
					
				}else if(category.equals("content")) {
					sql = "select * from board where board_cont like ? order by board_no desc";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+text+"%");
					
				}else if(category.equals("title_content")) {
					sql = "select * from board where board_title like ? or board_cont like ? order by board_no desc";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+text+"%");
					pstmt.setString(2, "%"+text+"%");
				}
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					BoardDTO dto = new BoardDTO();
					
					dto.setNum(rs.getInt(1));
					dto.setWriter(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setCont(rs.getString(4));
					dto.setPwd(rs.getString(5));
					dto.setHit(rs.getInt(6));
					dto.setRegdate(rs.getString(7));
					
					list.add(dto);
				}
				
				rs.close(); pstmt.close(); con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return list;
	}
}
