package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/characterSetFilter")
public class CharacterSetFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");

		System.out.println("1.characterSetFilter 전처리");
		chain.doFilter(request, response);
		System.out.println("3. characterSetFilter 후처리");
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
