package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebFilter("/loginCheckFilter")
public class LoginCheckFilter implements Filter {

  
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		
		HttpSession session = ((HttpServletRequest) request).getSession();
	/*	
		session.getAttribute("S_USER");
		
		if(session!=null){
			//request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			System.out.println("세션에 사용자 정보 없음.");
		}
		*/
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
