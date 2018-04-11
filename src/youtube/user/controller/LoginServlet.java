package youtube.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		System.out.println("test");
		try {
			UserManager.getInstance().login(username, password);
			response.getWriter().write("Congratulations, " + username + " you have been logged in successfully!");
		} catch (Exception e){
			response.getWriter().write("Wrong username and/or password.");
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		 out.println("<HTML>");
		 out.println("The time is: " +
		 new java.util.Date());
		 out.println("</HTML>"); 
		 out.close();
	}

}
