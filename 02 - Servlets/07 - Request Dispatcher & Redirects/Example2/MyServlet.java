package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String myEmail = req.getParameter("email1");
		String myPassword = req.getParameter("pass1");
		
		PrintWriter out = res.getWriter();
		
		
		if (myEmail.equals("demo@gmail.com") && myPassword.equals("demo123")) {
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, res);
		} else {
			res.setContentType("text/html");
			out.print("<h3 style='color:red'>Email ID and Passwod did not match</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			// rd.forward(req, res);
			rd.include(req, res);
		}
	}

}
