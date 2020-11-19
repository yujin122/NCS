package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object) : 데이터 접근 객체 ==> DB에 접속(연동)하는 객체.

public class EmpDAO {
	
	Connection con = null;				// DB 연결 객체
	PreparedStatement pstmt = null;		// DB SQL문을 전송하는 객체
	ResultSet rs = null;				// SQL문을 실행 후 결과 값을 가지고 있는 객체
	String sql = null;					// 쿼리문을 저장할 객체
	
	public EmpDAO() { // 기본 생성자
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";		
		
		try {
			// 1. 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB와 연결
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EMP 테이블의 전체 레코드를 조회하는 메서드
	public List<EmpDTO> selectList() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		try {
			sql = "select * from emp order by empno";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				
				list.add(dto);
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	// dept 테이블의 전체 목록을 조회하는 메서드
	public List<DeptDTO> deptList() {
		
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		
		try {
			sql = "select * from dept order by deptno";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DeptDTO dto = new DeptDTO();
				
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
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
