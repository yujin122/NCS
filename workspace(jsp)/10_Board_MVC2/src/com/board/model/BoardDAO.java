package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
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
		} catch (Exception e) {
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
				
				dto.setBoard_no(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setBoard_cont(rs.getString(4));
				dto.setBoard_pwd(rs.getString(5));
				dto.setBoard_hit(rs.getInt(6));
				dto.setRegdate(rs.getString(7));
			}
			
			rs.close(); pstmt.close(); con.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	public void boardHit(int num) {
		
		sql = "update board set board_hit = board_hit+1 where board_no = ?";
		
		openConn();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertBoard(BoardDTO dto) {
		
		int res = 0, count = 0;		
		
		try {
			openConn();
			
			con.setAutoCommit(false);
			sql = "select max(board_no) from board";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1)+1;
			}
			
			sql = "insert into board values(?, ?, ?, ?, ?, default, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setString(5, dto.getBoard_pwd());
			
			res = pstmt.executeUpdate();
			con.commit();
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return res;
	}


	public int updateBoard(BoardDTO dto) {
		int res = 0;
		
		try {
			sql = "select * from board where board_no = ?";
			
			openConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("Board_pwd").equals(dto.getBoard_pwd())) {
					sql = "update board set board_writer = ?, board_title = ?, board_cont = ? where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getWriter());
					pstmt.setString(2, dto.getTitle());
					pstmt.setString(3, dto.getBoard_cont());
					pstmt.setInt(4, dto.getBoard_no());
					
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


	public int removeBoard(int num, String pwd) {
		int res = 0;
		
		try {
			sql = "select * from board where board_no = ?";
			
			openConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("board_pwd").equals(pwd)) {
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


	public List<BoardDTO> searchBoard(String search, String text) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		openConn();
		try {
			if(search.equals("title")) {
				sql = "select * from board where board_title like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, "%" + text + "%");
				
			}else if(search.equals("writer")) {
				sql = "select * from board where board_writer like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, "%"+text+"%");
			}else if(search.equals("cont")) {
				sql = "select * from board where board_cont like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, "%"+text+"%");
			}else if(search.equals("title_cont")) {
				sql = "select * from board where board_title like ? or board_writer like ? order by board_no desc";
				
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, "%"+text+"%");
				pstmt.setString(2, "%"+text+"%");
				
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
