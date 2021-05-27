package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizDAO {
	private Connection conn;
	private PreparedStatement pst;
	int cnt;
	private ResultSet rs;
	
	public void conn() {
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	         String db_id = "hr";
	         String db_pw = "hr";

	         conn = DriverManager.getConnection(db_url, db_id, db_pw);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }   
	   }
	   
	   public void close() {
	      try {
	         if(rs != null) {
	            rs.close();
	         }   
	         if (pst != null) {
	            pst.close();
	         }
	         if(conn != null) {
	            conn.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public int quiz_update_point(String member_id) {
	      conn();
	      try {
	         String sql = "UPDATE MEMBER SET MEMBER_POINT = MEMBER_POINT + 100 WHERE MEMBER_ID = ?";
	         pst = conn.prepareStatement(sql);
	         pst.setString(1, member_id);
	         
	         cnt = pst.executeUpdate();
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         System.err.println("중첩된 포인트 혹은 빈값인지 체크해주세요!");
	         
	      } finally {
	         close();
	      }
	      return cnt;
	      
	   }
	   
	   public int quiz_insert_point(String member_id) {
		      conn();
		      try {
		         String sql = "insert into Point values(?,100,'YYYY-MM-DD','오늘의 퀴즈 정답')";
		         pst = conn.prepareStatement(sql);
		         pst.setString(1, member_id);
		         
		         cnt = pst.executeUpdate();
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		         System.err.println("중첩된 아이디 혹은 빈값인지 체크해주세요!");
		         
		      } finally {
		         close();
		      }
		      return cnt;
		      
		   }
}
