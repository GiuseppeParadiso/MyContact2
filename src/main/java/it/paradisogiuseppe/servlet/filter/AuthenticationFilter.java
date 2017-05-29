package it.paradisogiuseppe.servlet.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
	private static final Logger logger = Logger.getLogger(AuthenticationFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String url = httpRequest.getRequestURL().toString();
		if (session.getAttribute("idU")!=null || url.contains("MyContact2/login") || url.contains("MyContact2/signin") ){
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect("login");
			logger.info("filtered");
		} 
	}

	@Override
	public void destroy() {}

}
