package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aaa")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respnse) throws ServletException, IOException {
		System.out.println("I am in MyServlet service() mehtod");
	}

}
