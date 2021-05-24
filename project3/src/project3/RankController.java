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


@WebServlet("/RankController")
public class RankController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/plain; charset = utf-8");
	
		//ArrayList 객체생성 -> JSON객체로 변환
		ArrayList<RankVO> data = new ArrayList<RankVO>();
		
		RankDAO dao = new RankDAO();
		data = dao.select();
		
		
		//GSON 객체 생성
		Gson gson = new Gson();
		String jsonArr = gson.toJson(data);
		System.out.println(jsonArr);
		
		//App으로 JSON데이터 보내기
		response.setContentType("text/plainl charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
	}

}
