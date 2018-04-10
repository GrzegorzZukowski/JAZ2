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

@WebFilter({"login.jsp", "registration.jsp"})
public class LoginFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession();
			
			if (session.getAttribute("username")!= null) {
				User user = (User) session.getAttribute("username");
				UserRepo repository = new UserRepo();
				String privilege = repository.getPrivilege(user);
		
				if ( privilege.equals("NORMAL") || privilege.equals("PREMIUM") || privilege.equals("ADMIN") ) {
					response.getWriter().print("Juz jestes zalogowany");
					HttpServletResponse httpResponse = (HttpServletResponse) response;
					httpResponse.sendRedirect("/profileServ");
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
