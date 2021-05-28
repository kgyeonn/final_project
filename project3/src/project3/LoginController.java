package project3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("로그인 요청이 들어옴..!");
      
      String member_id = request.getParameter("login_id");
      String member_pw = request.getParameter("login_pw");
      
      System.out.println(member_id+"/"+member_pw);
      
      MemberDAO dao = new MemberDAO();
      MemberVO vo = new MemberVO(member_id, member_pw);
      
      ArrayList<MemberVO> data = dao.login(member_id, member_pw);
      
      Gson gson = new Gson();
      
      String loginInfoList=gson.toJson(data);
      
      System.out.println(loginInfoList);
      
      //APP으로 JSON데이터 보내기
      
      
      response.setContentType("text/plain; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      if(loginInfoList != null) {
         out.print(loginInfoList);
//         out.print(vo.getMember_id());
//         out.print(vo.getMember_pw());
//         out.print(vo.getMember_phone());
//         out.print(vo.getMember_region());
//         out.print(vo.getMember_point());
         
         //System.out.println(loginInfoList.get(0).getMember_id()+"/"+loginInfoList.get(0).getMember_point());
      }else {
         out.print("");
      }
      
      
   }

}