package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myLogin")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String myEmail1 = req.getParameter("name1");
        String myPass1 = req.getParameter("pass1");

        if (myEmail1.equals("demo@gmail.com") && myPass1.equals("demo123")) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

}
