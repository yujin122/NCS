package sist;

import java.sql.*;
import java.util.Scanner;

public class Ex03_Update {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String pwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메모 글번호 : ");
		String number = sc.nextLine();
		
		System.out.print("메모 수정 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("메모 수정 내용 : ");
		String content = sc.nextLine();
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pwd);
			
			String sql = "Update memo set title = ?, content = ? where num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(number));
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("데이터 수정 성공");
			}else {
				System.out.println("데이터 수정 실패");
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
			
			rs.close(); pstmt.close(); con.close(); sc.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
