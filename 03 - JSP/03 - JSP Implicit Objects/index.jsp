<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Implicit Objects Example</title>
</head>
<body>
    <h3>JSP Implicit Objects Example</h3>

    <% 
        // request implicit object
        String userName = request.getParameter("name");
        if (userName == null) {
            userName = "Guest";
        }

        // response implicit object
        response.setContentType("text/html");

        // session implicit object
        session.setAttribute("user", userName);

        // application implicit object
        application.setAttribute("appName", "JSP Demo");

        // out implicit object
        out.println("<h4>Welcome, " + userName + "</h4>");
        out.println("Session User: " + session.getAttribute("user") + "<br>");
        out.println("Application Name: " + application.getAttribute("appName") + "<br>");

        // config implicit object
        out.println("Servlet Config Param (example): " + config.getInitParameter("example") + "<br>");

        // pageContext implicit object
        pageContext.setAttribute("currentPage", "JSP Implicit Objects");
        out.println("Current Page: " + pageContext.getAttribute("currentPage") + "<br>");
    %>

</body>
</html>
