package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
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
   
   public int join(MemberVO vo) {
      conn();
      try {
         String sql = "insert into member values(?,?,?,?,100)";
         pst = conn.prepareStatement(sql);
         pst.setString(1, vo.getMember_id());
         pst.setString(2, vo.getMember_pw());
         pst.setString(3, vo.getMember_phone());
         pst.setString(4, vo.getMember_region());
         cnt = pst.executeUpdate();
         
         
      } catch (SQLException e) {
         e.printStackTrace();
         System.err.println("중첩된 아이디 혹은 빈값인지 체크해주세요!");
         
      } finally {
         close();
      }
      return cnt;
      
   }
   
   public int join_point(MemberVO vo) {
      conn();
      try {
         
         String sql="insert into point values(?,100,SYSDATE,'회원가입')";
         pst = conn.prepareStatement(sql);
         pst.setString(1, vo.getMember_id());
         System.out.println(vo.getMember_id());
         cnt1 = pst.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
         System.err.println("회원가입 포인트 적립 실패");
         
      } finally {
         close();
      }
      return cnt1;
      
   }
   
   public ArrayList<MemberVO> login(String member_id, String member_pw) {
      conn();
      
      ArrayList<MemberVO> loginInfoList=new ArrayList<MemberVO>();
      
      MemberVO vo = null;
      
      try {
         String sql = "select * from member where member_id = ? and member_pw = ?";
         pst = conn.prepareStatement(sql);
         pst.setString(1, member_id);
         pst.setString(2, member_pw);
         rs = pst.executeQuery();
         
         if(rs.next()) {
            String get_id = rs.getString(1);
            String get_pw = rs.getString(2);
            String get_phone = rs.getString(3);
            String get_region = rs.getString(4);
            int get_point = rs.getInt(5);
            
            
            vo = new MemberVO(get_id, get_pw, get_phone, get_region, get_point);
            
            loginInfoList.add(vo);
            System.out.println(get_id+get_point);
            //System.out.println(loginInfoList);
            
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("로그인 실패");
      } finally {
         close();
      }
      
      return loginInfoList;
   
   }

   

}