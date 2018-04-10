package filters;

import java.io.IOException;

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

@WebFilter("/profileServ")
public class ProfileFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession();
			
			HttpServletResponse httpResponse = (HttpServletResponse) response;
						
			if (session.getAttribute("username") == null) {
				
				httpResponse.sendRedirect("/login.jsp");
			}
			
			chain.doFilter(request, response);
		}
	
		@Override
		public void destroy() {
		}
		
		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}
}
