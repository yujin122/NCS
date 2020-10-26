package sist;

import java.sql.*;
import java.util.Scanner;

public class Ex02_Insert {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String pwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메모 제목 : ");
		String title = sc.nextLine();
		System.out.print("메모 작성자 : ");
		String writer = sc.nextLine();
		System.out.print("메모 내용 : ");
		String content = sc.nextLine();
		
		try {
			// 드라이버 로딩
			Class.forName(driver);
			
			// 데이터베이스 연결
			con = DriverManager.getConnection(url, user, pwd);
			
			String sql = "insert into memo values(memo_seq.nextval, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			// sql문 전송
			// 쿼리문이 select 쿼리문인 경우 executeQuery() 메서드를 사용 ==> 반환형은 ResultSet형
			// 쿼리문이 insert, update, delete, drop, alter
			// executeUpdate() 메서드 사용 ==> 반환형은 int형
			// 반환형이 int인 이유 : 행 삽입, 수정, 삭제 갯수를 표현한 것.
			// 쿼리문이 성공적으로 실행이 될 경우 결과값 1을 반환
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("데이터 추가 성공");
			}else {
				System.out.println("데이터 추가 실패");
			}
			
			sql = "select * from memo order by num";
			
			pstmt = con.prepareStatement(sql);
			
			// 4. 데이터베이스에 SQL문을 전송
			rs = pstmt.executeQuery();
			
			// 5. 데이터를 가져와서 출력
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("title") + "\t" + rs.getString("wirter") + "\t" 
									+ rs.getString("content") + "\t" + rs.getDate("regdate"));
			}
			
			rs.close(); pstmt.close(); con.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
