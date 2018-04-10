package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import repositories.UserRepo;
import repositories.UserRepoInterface;

@WebServlet("/premium")
public class PremiumServ extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = retrieveUserFromRequest(request, response);
		UserRepoInterface repository = new UserRepo();
		
		if(request.getParameter("premium").equals("set")) {
			repository.grantPremium(user);
		} else {
			repository.revokePremium(user);
		}
		
		response.sendRedirect("/UsersServ");
	}
	
	
	private User retrieveUserFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		User result = new User();
		result.setUsername(request.getParameter("username"));
		return result;
	}

}
