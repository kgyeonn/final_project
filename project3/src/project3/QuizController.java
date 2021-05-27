package project3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QuizController")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/plain; charset = utf-8");
		
		String member_id = request.getParameter("login_id");
		
		
		QuizDAO dao = new QuizDAO();
		
		int result1 = dao.quiz_update_point(member_id);
		int result2 = dao.quiz_insert_point(member_id);
		
		if(result1 == 0) {
			System.out.println("포인트 누적 실패");
		}else {
			System.out.println("포인트 누적 성공");
		}
		
		if(result2 == 0) {
			System.out.println("포인트내역 추가 실패");
		}else {
			System.out.println("포인트내역 추가 성공");
		}
		
		
	}

}
