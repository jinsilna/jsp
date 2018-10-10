package calculation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mulCalculationServlet")
public class mulCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getParameter은 항상 문자열을 반환해서
		// 형변환을 해준다.. Integer.parseInt
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		System.out.println(start);
		System.out.println(end);
		
		// class 객체화 
		CalculationLogic logic = new CalculationLogic();
		int mul = logic.sumBetweenTwoNumbers(start,end);
		
		// 사이의 값을 더하는 것 
	    //int mul = 0;
	    for(int i = start; i<= end; i++){
	    	mul+=i;
	    }
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", mul);
		
		
		// forward로 위임(scopeResult.jsp)
        request.getRequestDispatcher("/calculation/mulResult.jsp").forward(request, response);
		
	}

}
