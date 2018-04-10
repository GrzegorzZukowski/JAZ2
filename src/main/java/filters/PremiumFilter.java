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

import repositories.UserRepo;
import domain.User;

@WebFilter("/premium.jsp")
public class PremiumFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession();
			
			HttpServletResponse httpResponse = (HttpServletResponse) response;
						
			if (session.getAttribute("username") == null) {
				
				httpResponse.sendRedirect("/index.jsp");
			}
			
			
			if (session.getAttribute("username")!= null) {
				User user = (User) session.getAttribute("username");
				UserRepo repository = new UserRepo();
				String privilege = repository.getPrivilege(user);
				
				if ( privilege.equals("NORMAL") ) {
					httpResponse.sendRedirect("/index.jsp");
				}
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
