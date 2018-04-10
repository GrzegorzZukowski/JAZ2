package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import repositories.UserRepo;
import repositories.UserRepoInterface;

@WebServlet("/UsersServ")
public class UsersServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserRepoInterface repository = new UserRepo();
		
		List<User> users = repository.getAllUsers();
		
		PrintWriter out = response.getWriter();
		
		out.println("<table border='1'>");
		out.println("<tr><th>Uzytkownik</th><th>Email</th><th>Role</th></tr>");
		for (User user : users) {
			out.println("<tr><td>" + user.getUsername()
			+ "</td><td>" + user.getEmail()
			+"</td><td>" + user.getPrivilege()
		    + "</td></tr>");
		}
		out.println("</table></br>");
		out.println("<a href='index.jsp'>Powrot do strony startowej</a>");
	}
	
}
