package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class PointDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	PointVO pvo = null;
//	ArrayList<MessageDAO> list = null;
	ArrayList<PointVO> pList = null;
	
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
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//point insert
	public int insert(PointVO vo) {
		conn();
		
		
		try {
			
			String sql = "insert into point values(?, ?, ?, sysdate)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_id());
			psmt.setInt(2, vo.getPoint_p());
			psmt.setString(3, vo.getPoint_content());
			cnt = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}
	
	public ArrayList<PointVO> select(String member_id) {
		pList = new ArrayList<PointVO>();
		int point_sum = 0;
		conn();
		
		try {
			String sql = "select * from point where member_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member_id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				int point = rs.getInt(2);
				point_sum += point;
				String date = rs.getString(3);
				String content = rs.getString(4);
				
				pvo = new PointVO(id, point, point_sum, date, content);
				pList.add(pvo);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return pList;
	}
}
	

