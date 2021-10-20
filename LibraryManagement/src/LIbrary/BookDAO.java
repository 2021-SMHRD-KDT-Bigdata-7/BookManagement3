package LIbrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class BookDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	int cnt = 0;
	
	String sql;
	
	BookVo book = new BookVo();
		
	public void getConnect() {
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.1.241:1521:xe";
			String user="hr";
			String password = "hr";
			conn =DriverManager.getConnection(url, user, password);
			
			}catch (Exception e) {
				
				System.out.println("연결 오류 발생");
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
	
	public int insert(BookVo bv) {
		
		getConnect();
		
		
		sql = "insert into book values(?,?,?,?,?)";
		
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, bv.getB_id());
		psmt.setString(2, bv.getB_title());
		psmt.setString(3, bv.getB_author());
		psmt.setString(4, bv.getB_publisher());
		psmt.setInt(5, bv.getB_price());
						  
		cnt = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	//select 메소드
	public BookVo select(String title) {
		
		getConnect();
		BookVo bv = null;
		try {
			//2. sql문 전송단계
			sql = "select * from book where b_title = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			
			rs = psmt.executeQuery();
			
			String b_id = "";
			String b_title = "";
			String b_author = "";
			String b_publisher = "";
			int b_price = 0;
			
			while(rs.next()) {
				b_id = rs.getString(1);
				b_title = rs.getString(2);
				b_author = rs.getString(3);
				b_publisher = rs.getString(4);
				b_price = rs.getInt(5);

				System.out.println(b_id + " / "+ b_title+" / "+ b_author+"/"+b_publisher+"/"+b_price);
			}
			bv = new BookVo(b_id, b_title, b_author, b_publisher, b_price);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
					close();
		}
		return bv;
	}
	
	public ArrayList<BookVo> selectAll() {
		getConnect();
		
		ArrayList<BookVo> list = new ArrayList<BookVo>();
				
		try {
			sql = "select * from book";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookVo bookvo = new BookVo(rs.getString("b_id"), rs.getString("b_title"), rs.getString("b_author"), rs.getString("b_publisher"), rs.getInt("b_price"));

				list.add(bookvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}

	//update메소드
	public int update(String b_id, int b_price) {
		
		getConnect();
		
		
		sql = "update book set b_id = ?, b_price = ? where b_id=?";

		try {
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, b_id);
		psmt.setInt(2, b_price);
		psmt.setString(3, b_id);
		
		
		cnt = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//3. 데이터베이스 닫아주기
			close();
		}
		
		return cnt;
	}
	//delete 메소드
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
	
	