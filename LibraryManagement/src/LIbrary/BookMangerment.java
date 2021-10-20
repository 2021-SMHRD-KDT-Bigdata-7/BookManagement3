package LIbrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookMangerment {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// executeUpdate()�� ����� ����� ����
	int result = 0;

	// �����ͺ��̽��� �����ϴ� �޼ҵ�
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.1.241:1521:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {// ���� �߻��� catch���� ����.
			System.out.println("��...��...");
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
	
		
	public void addBook(BookVo bv) {
		bv = dao.insert(b_id,b_title,b_author,b_publisher, b_price);
	}
	public String selectBook(String b_title) {
		BookVo sel = dao.select(b_title);
		return b_title;
		
	}
	
	public void selectAll() {
		dao.selectAll();
	}
	
	public void updateBook(String b_id, int b_price) {
		int upd = dao.update(b_title,b_price);
	}
	public void deleteBook(String b_id) {
		int del=dao.delete(b_id);
}
}
