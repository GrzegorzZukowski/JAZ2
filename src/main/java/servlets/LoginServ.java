package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import repositories.UserRepo;
import repositories.UserRepoInterface;


@WebServlet("/login")
public class LoginServ extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UserRepoInterface repository = new UserRepo();
		
		User user = retrieveUserDataFromRequest(request, response);
		
		if (repository.login(user)) {
			session.setAttribute("username", user);
			response.sendRedirect("/profileServ");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
	
	private User retrieveUserDataFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			User result = new User();
			result.setUsername(request.getParameter("username"));
			result.setPassword(request.getParameter("password"));
			return result;
	}
}
