package calculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mulCalculationServlet2")
public class mulCalculationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// request : 클라이언트의 요청정보가 유지되는 동안 공유되는 영역 (dispatch)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/calculation/mulInput.jsp");
	    rd.forward(request, response);
		}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));

		System.out.println(param1);
		System.out.println(param2);
		System.out.println(param1 * param2);
		
		int mulResult = 1;
			for(int i = param1; i<=param2; i++){
				mulResult*=i;
			}

			
		
		// param1 * param2 의 곱을 출력 
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", mulResult);
		
		request.getRequestDispatcher("/calculation/mulResult2.jsp").forward(request, response);
	}

}









