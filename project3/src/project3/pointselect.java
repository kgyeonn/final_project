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

@WebServlet("/pointselect")
public class pointselect extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setCharacterEncoding("EUC-KR");
		
		response.setContentType("text/plain; charset = utf-8");
		
		//ArrayList ��ü���� -> JSON��ü�� ��ȯ
		ArrayList<PointVO> data = new ArrayList<PointVO>();
		String member_id = request.getParameter("id");
		
		PointDAO dao = new PointDAO();
		
		dao.select(member_id);
		
		data.addAll(dao.select(member_id));
		
		//GSON ��ü ����
		Gson gson = new Gson();
		
		String jsonArr = gson.toJson(data);
		
		System.out.println(jsonArr);
		
		//App ���� JSON������ ������
		response.setContentType("text/plain; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonArr);
	
	
	}

}