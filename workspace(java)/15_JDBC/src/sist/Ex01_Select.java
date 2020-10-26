package sist;

import java.sql.*;

public class Ex01_Select {

	public static void main(String[] args) {
		
		// 오라클 드라이버 로딩(대소문자 구별)
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String pwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			// 형식) Class.forName("오라클 드라이버 클래스 이름"); ==> 동적 바인딩
			// 동적 바인딩: 프로그램 실행 시에 드라이버를 로딩한다는 의미
			Class.forName(driver);
			
			System.out.println("드라이버 로딩 성공");
			System.out.println();
			
			// 2. 데이터베이스와 연결
			con = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("데이터베이스와 접속 성공");
			System.out.println();
			
			// 3. 데이터베이스에 SQL문을 전송하기 위한 쿼리문 작성
			String sql = "select * from memo order by num";
			
			pstmt = con.prepareStatement(sql);
			
			// 4. 데이터베이스에 SQL문을 전송
			rs = pstmt.executeQuery();
			
			// 5. 데이터를 가져와서 출력
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("title") + "\t" + rs.getString("wirter") + "\t" 
									+ rs.getString("content") + "\t" + rs.getDate("regdate"));
			}
			
			// 6. 연결 종료
			/*if(rs != null) rs.close();	
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();*/

			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
