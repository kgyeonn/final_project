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

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("EUC-KR");
		
		response.setContentType("text/plain; charset = utf-8");
		
		String member_id = request.getParameter("login_id");
	    String member_pw = request.getParameter("login_pw");
	    String member_region = request.getParameter("login_region");
	    String member_phone = request.getParameter("login_phone");
	    
		//ArrayList 객체생성 -> JSON객체로 변환
		
		MemberVO info = new MemberVO(member_pw,member_phone,member_region,member_id);
		
		MemberDAO dao = new MemberDAO();
		
		dao.update(info);
		
		//GSON 객체 생성
		Gson gson = new Gson();
		
		String updateList = gson.toJson(info);
		
		System.out.println(updateList);
		
		//APP으로 JSON데이터 보내기
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();		
		
		out.print(updateList);
		request.setCharacterEncoding("UTF-8");
				
		int cnt = dao.update(info);		
		
		if(cnt > 0) {
			out.print("회원 정보수정 성공!");
		}else {
			out.print("회원 정보수정 실패!");
		}
		
	      if(updateList != null) {
	          out.print(updateList);
	      }
	
	}

}
