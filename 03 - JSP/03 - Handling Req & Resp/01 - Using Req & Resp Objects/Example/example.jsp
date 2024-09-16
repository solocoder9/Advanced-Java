<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
        // Retrieving form data using request object
        String username = request.getParameter("username");
        
        // Check if the username is not null (i.e., form is submitted)
        if (username != null && !username.isEmpty()) {
            // Setting content type for the response
            response.setContentType("text/html");

            // Displaying the username back to the client
            out.println("<p>Hello, " + username + "!</p>");
        } else {
            // If no input is provided, display this message
            out.println("<p>Please enter your name.</p>");
        }
    %>
</body>
</html>
