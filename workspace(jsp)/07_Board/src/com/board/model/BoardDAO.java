package com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void OpenConn() {
		String dirver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		try {
			Class.forName(dirver);
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public List<BoardDTO> boardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		sql = "select * from board order by board_no desc";
		
		try {
			OpenConn();
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setWriter(rs.getString("board_writer"));
				dto.setTitle(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setRegdate(rs.getString("board_regdate"));
				
				list.add(dto);
			}
			
			rs.close();pstmt.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}


	public BoardDTO getBoardPost(int no) {
		BoardDTO dto = new BoardDTO();
		
		sql = "select * from board where board_no = ?";
		
		try {
			OpenConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setBoard_no(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setBoard_cont(rs.getString(4));
				dto.setBoard_pwd(rs.getString(5));
				dto.setBoard_hit(rs.getInt(6));
				dto.setRegdate(rs.getString(7));
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}


	public int insertPost(BoardDTO dto) {
		int res = 0;
		
		sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, default, sysdate)";
		
		try {
			OpenConn();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getBoard_cont());
			pstmt.setString(4, dto.getBoard_pwd());
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}


	public void boardHit(int no) {
		
		OpenConn();
		
		sql = "update board set board_hit = board_hit+1 where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int updateBoard(BoardDTO dto) {
		
		int res = 0;
		
		try {
			
			OpenConn();
			
			sql = "select * from board where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(dto.getBoard_pwd().equals(rs.getString("board_pwd"))) {
					sql = "update board set board_title = ?, board_cont = ? where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getTitle());
					pstmt.setString(2, dto.getBoard_cont());
					pstmt.setInt(3, dto.getBoard_no());
					
					res = pstmt.executeUpdate();
				}else {
					res = -1;
				}
			}
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}


	public int deleteBoard(int num, String pwd) {
		
		int res = 0;
		
		sql = "select board_pwd from board where board_no = ?";
		
		try {
			OpenConn();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("board_pwd"))) {
					sql = "delete from board where board_no = ?";
					
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


	public List<BoardDTO> searchTitle(String field, String text) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			OpenConn();
			
			if(field.equals("title")) {
				sql = "select * from board where board_title like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + text + "%");
				
			}else if(field.equals("cont")) {
				sql = "select * from board where board_cont like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + text + "%");
				
			}else {
				sql = "select * from board where board_title like ? or board_cont like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + text + "%");
				pstmt.setString(2, "%" + text + "%");
				
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_no(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setBoard_cont(rs.getString(4));
				dto.setBoard_pwd(rs.getString(5));
				dto.setBoard_hit(rs.getInt(6));
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
