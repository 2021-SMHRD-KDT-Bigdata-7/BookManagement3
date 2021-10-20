package LIbrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BookDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	int cnt = 0;
	
	String sql;
		
	public void getConnect() {
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.1.241:1521:xe";
			String user="hr";
			String password = "hr";
			conn =DriverManager.getConnection(url, user, password);
			
			}catch (Exception e) {
				
				System.out.println("���� ���� �߻�");
				e.printStackTrace();  
			} 
	}
	
	public void close() {
		try {
			
			if(rs != null) {rs.close();}	
			if(psmt != null) {psmt.close();}
			if(conn != null) {conn.close();
			
			}
			}catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	
	public int insert(String b_id, String b_title, String b_author, String b_publisher, String b_price) {
		
		getConnect();
		
		
		sql = "insert into book values(?,?,?,?,?)";
		
		try {
		psmt = conn.prepareStatement(sql);
		
						  
		cnt = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	//select �޼�=��
	public void select() {
		
		getConnect();
		
		try {
			//2. sql�� ���۴ܰ�
			sql = "select * from book";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
		
			
			while(rs.next()) {
				String b_id = rs.getString(1);
				String b_title = rs.getString(2);
				String b_author = rs.getString(3);
				String b_publisher = rs.getString(2);
				String b_price = rs.getString(3);
				
				System.out.println(b_id + " / "+ b_title+" / "+ b_author+"/"+b_publisher+"/"+b_price);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
					close();
		}
		
	}
	public void selectAll() {
		getConnect();
		
		sql = "select * from book";
		
		try {
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//update�޼ҵ�
	public int update(String b_id, int b_price) {
		
		getConnect();
		
		
		sql = "update book set b_id = ?, b_price = ? where b_id=?";

		try {
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, b_id);
		psmt.setInt(1, b_price);
		psmt.setString(1, b_id);
		
		
		cnt = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//3. �����ͺ��̽� �ݾ��ֱ�
			close();
		}
		
		return cnt;
	}
	//delete �޼ҵ�
	public int delete(String b_id) {
		
		getConnect();
		
		sql = "delete from book where b_id=?";
		try {
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, b_id);
		
		
		
		cnt =psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		return cnt;
	}
		
		
}	
	
	