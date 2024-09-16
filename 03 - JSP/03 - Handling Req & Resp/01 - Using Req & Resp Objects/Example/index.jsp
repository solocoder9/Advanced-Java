<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Request and Response Example</title>
</head>
<body>
    <h2>Handling Request and Response in JSP</h2>

    <!-- Form for sending data -->
    <form action="example.jsp" method="post">
        Name: <input type="text" name="username">
        <input type="submit" value="Submit">
    </form>

    <%
        // Retrieve form data using request object
        String username = request.getParameter("username");
        
        if (username != null) {
            // Setting content type for the response
            response.setContentType("text/html");

            // Displaying the username back to the client
            out.println("<p>Hello, " + username + "!</p>");
        } else {
            out.println("<p>Please enter your name.</p>");
        }
    %>
</body>
</html>
