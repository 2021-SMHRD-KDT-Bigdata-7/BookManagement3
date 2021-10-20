package LIbrary;

public class BookDAO {
	

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

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
				
				
				System.out.println("연결 오류 발생");
				e.printStackTrace();  
			} 
		}
	public void close() {
		try {
			
			if(rs != null) {rs.close();}	
			if(psmt != null) {psmt.close();}
			if(conn != null) {conn.close();}
			}catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	public int insert() {
		
		getConnect();
		
		
		sql = "insert into book values(?,?,?,?,?)";
		
		try {
		psmt = conn.prepareStatement(sql);
		
						  
		result = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	//select 메소=드
	public void select(String) {
		
		getConnect();
		
		try {
			//2. sql문 전송단계
			sql = "select * from book";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
		
			
			while(rs.next()) {
				String getId = rs.getString(1);
				String getPw = rs.getString(2);
				String getNick = rs.getString(3);
				
				System.out.println(get + " / "+ get+" / "+ get+"/"+get+"/"+get);
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
		
		rs = psmt.executeQuery();
		
		
		
	}

	//update메소드
	public int update(String , int) {
		
		getConnect();
		
		
		sql = "update book set";

		try {
		
			psmt = conn.prepareStatement(sql);
		psmt.setString(1, pw);
		
		
		result = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//3. 데이터베이스 닫아주기
			close();
		}
		return result;
	}
	//delete 메소드
	public int delete(String ) {
		
		getConnect();
		
		sql = "delete from member where id=? and pw=?";
		try {
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		
		
		
		result =psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		return result;
	}
		
		
		
		
		
	}
}
