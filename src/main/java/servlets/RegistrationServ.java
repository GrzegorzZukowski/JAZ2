package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Privilege;
import domain.User;
import repositories.UserRepo;
import repositories.UserRepoInterface;


@WebServlet("/Registration")
public class RegistrationServ extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = retrieveUserFromRequest(request, response);
		UserRepoInterface repository = new UserRepo();
		
		repository.add(user);
		response.sendRedirect("RegistrationSuccesfull.jsp");
	}
	
	private User retrieveUserFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
			response.sendRedirect("Error.jsp");
			return null;
		} else {
			User result = new User();
			result.setUsername(request.getParameter("username"));
			result.setPassword(request.getParameter("password"));
			result.setEmail(request.getParameter("email"));
			result.setPrivilege(Privilege.NORMAL);
			return result;
		}
	}
}
