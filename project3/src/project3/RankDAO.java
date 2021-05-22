package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RankDAO {
	
	private Connection conn;
	   private PreparedStatement pst;
	   private ResultSet rs;
	   private int cnt,cnt1;
	   
	   
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
		   
		   public void rankpoint(MemberVO vo) {
			   conn();
			   try {
				   String sql = "select member_region, sum(member_point),count(member_id) from member group by member_region order by sum(member_point) desc;";
				   
				   pst = conn.prepareStatement(sql);
				   rs = pst.executeQuery();
				   
				   if(rs.next()) {
					   String get_region = rs.getString(1);
					   int get_totalPoint = rs.getInt(2);
					   int get_countId = rs.getInt(3);
					   
					   vo = new MemberVO(get_region,get_totalPoint,get_countId);
					
							   }
			   
				   
			   }
		   }
	

}
