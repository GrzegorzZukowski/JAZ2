package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import repositories.UserRepo;
import repositories.UserRepoInterface;


@WebServlet("/ProfileServ")
public class ProfileServ extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UserRepoInterface repository = new UserRepo();
		
		User user = (User) session.getAttribute("username");
		
		PrintWriter out = response.getWriter();
		
		out.println("<table border='1'>");
		out.println("<tr><th>Uzytkownik</th><th>Haslo</th><th>Email</th><th>Role</th></tr>");
		out.println("<tr><td>" + user.getUsername() 
			+ "</td><td>" + user.getPassword()
			+ "</td><td>" + repository.getEmail(user)
			+"</td><td>" + repository.getPrivilege(user)
			   + "</td></tr>");
		out.println("</table></br>");
		out.println("<a href='index.jsp'>Powrot do strony startowej</a>");
	}

}
