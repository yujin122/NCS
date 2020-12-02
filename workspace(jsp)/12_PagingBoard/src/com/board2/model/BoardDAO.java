package com.board2.model;

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


	public int getListCount() {
		int res = 0;
		
		openConn();
		
		sql = "select count(board_no) from board";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}


	public List<BoardDTO> getBoardList(int page, int rowsize) {
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		// 해당 페이지에서 시작번호
		int startNo = (page * rowsize) - (rowsize - 1);
		// 해당 페이지의 끝 번호
		int endNo = (page * rowsize);
		
		openConn();
		
		// row_number() over() : 특정 컬럼을 기준으로 행 번호를 부여할 때 사용하는 함수
		// 기존의 rownum을 사용할 때에는 정렬이 되기 전에 rownum이 계산이 되기 때문에
		// 정렬 조건을 주게 되면 페이징 작업을 할 수가 없다.
		// 이것을 보완하는 방식이 row_number() 함수의 over(정렬 조건)를 이용하면 해결이 됨.
		
		sql = "select * from (select b.*, row_number() over(order by b.board_no desc) rnum "
				+ "from board b) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setTitle(rs.getString("board_title"));
				dto.setWriter(rs.getString("board_writer"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setRegdate(rs.getString("board_regdate"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				
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


	public int addBoardPost(BoardDTO dto) {
		int res = 0;
		
		openConn();
		
		sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, default, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getBoard_cont());
			pstmt.setString(4, dto.getBoard_pwd());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}

		return res;
	}


	public BoardDTO getBoardCont(int board_no) {
		BoardDTO dto = new BoardDTO();
		
		openConn();
		
		sql = "select * from board where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoard_no(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setBoard_cont(rs.getString(4));
				dto.setBoard_pwd(rs.getString(5));
				dto.setBoard_hit(rs.getInt(6));
				dto.setRegdate(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
	}


	public void boardHit(int no) {
		
		openConn();
		
		sql = "update board set board_hit = board_hit+1 where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
	}


	public int updateBoard(BoardDTO dto) {
		int res = 0;
		
		openConn();
		
		try {
			sql = "select board_pwd from board where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(dto.getBoard_pwd())) {
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
	}


	public int deleteBoard(int no, String pwd) {
		int res = 0;
		
		openConn();
	
		try {
			sql = "select board_pwd from board where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pwd)) {
					sql = "delete from board where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					
					res = pstmt.executeUpdate();
				}else {
					res = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}


	public int getBoardCont(String label, String text) {
		
		int res = 0;
		openConn();
		
		try {
			if(label.equals("title")) {
				sql = "select count(*) from board where board_title like ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				
			}else if(label.equals("cont")) {
				sql = "select count(*) from board where board_cont like ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				
			}else if(label.equals("title_cont")) {
				sql = "select count(*) from board where board_title like ? or board_cont like ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				pstmt.setString(2, "%"+text+"%");
				
			}else if(label.equals("writer")) {
				sql = "select count(*) from board where board_writer like ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return res;
		
	}


	public List<BoardDTO> getBoardList(int page, int rowsize, String label,
			String text) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();

		int startNo = (page * rowsize) - (rowsize - 1);
		// 해당 페이지의 끝 번호
		int endNo = (page * rowsize);
		
		openConn();
		
		try {
			if(label.equals("title")) {
				sql = "select * from (select b.*, row_number() over(order by b.board_no desc) rnum "
						+ "from board b "
						+ "where board_title like ?) "
						+ "where rnum>=? and rnum <=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
				
			}else if(label.equals("cont")) {
				sql = "select * from (select b.*, row_number() over(order by b.board_no desc) rnum "
						+ "from board b "
						+ "where board_cont like ?) "
						+ "where rnum>=? and rnum <=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
				
			}else if(label.equals("title_cont")) {
				sql = "select * from (select b.*, row_number() over(order by b.board_no desc) rnum "
						+ "from board b "
						+ "where board_title like ? or board_cont like ?) "
						+ "where rnum>=? and rnum <=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				pstmt.setString(2, "%"+text+"%");
				pstmt.setInt(3, startNo);
				pstmt.setInt(4, endNo);
				
			}else if(label.equals("writer")) {
				sql = "select * from (select b.*, row_number() over(order by b.board_no desc) rnum "
						+ "from board b "
						+ "where board_writer like ?) "
						+ "where rnum>=? and rnum <=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+text+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
				
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setTitle(rs.getString("board_title"));
				dto.setWriter(rs.getString("board_writer"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setRegdate(rs.getString("board_regdate"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}

	
}