package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.sun.jndi.toolkit.url.Uri;


@WebFilter("/requestCounterFilter")
public class RequestCounterFilter implements Filter {
	/*
		    1.RequestCounterFilter 생성
			
			2.요청 uri ==> request 객체에서 획득
			  ex : '/filterServlet'
			
			3.Map 객체가 필요하지 않을까...?
			  (application)
			
			4.requestCount.jsp
			  uri : 접속 횟수 
	
		 */
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// map : key : uri , value-count(Integer)
		
		// application객체 
		ServletContext application = request.getServletContext();
		
		//application 객체에서 가져오기 
		Map<String,Integer> rcMap = (Map<String, Integer>) application.getAttribute("rcMap");
		
		// application 객체에 rcMap 객체각 존재하는지 확인 
		// 없으면 신규 생성후 저장 
		if(rcMap ==null)
			rcMap = new HashMap<String, Integer>();
		
		
		// type 캐스팅 
		String uri = ((HttpServletRequest) request).getRequestURI();
		System.out.println(uri);
		
	    Integer count =	rcMap.get(uri);
		
		// 최초 요청시 
		if(count == null){
			rcMap.put(uri, 1);
			System.out.println("최초요청");
		}else{
			rcMap.put(uri, ++count);
			System.out.println("최초요청이 아님");
		}
		
		application.setAttribute("rcMap", rcMap);

		chain.doFilter(request, response);

	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
