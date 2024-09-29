package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitForm")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String myName = req.getParameter("name1");
        String myEmail = req.getParameter("email1");

        // For console
        System.out.println("Name: " + myName);
        System.out.println("Email: " + myEmail);

        // For browser
        PrintWriter out = res.getWriter();
        out.println("Name: " + myName);
        out.println("Email: " + myEmail);

    }
}
