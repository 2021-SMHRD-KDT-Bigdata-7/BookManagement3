package LIbrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookMangerment {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// executeUpdate()의 결과를 담아줄 변수
	int result = 0;

	// 데이터베이스를 연결하는 메소드
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {// 오류 발생시 catch문이 잡음.
			System.out.println("몬가...몬가...");
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	BookDAO dao =new BookDAO();
	int cnt;
	String b_id;
	String b_title;
	String b_author;
	String b_publisher;
	int b_price;
	
		
	public BookVo addBook(String b_id,String b_title,String b_author,String b_publisher,int b_price) {
		return null;
	}
		
	
	public String selectBook(String b_title) {
		return b_title;
		
	}
	
	public void selectAll() {
		
	}
	
	public void updateBook(String b_id, int b_price) {
		
	}
	public void deleteBook(String b_id) {


}
}
