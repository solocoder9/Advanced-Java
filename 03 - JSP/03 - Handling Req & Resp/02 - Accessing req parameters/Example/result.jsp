<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Parameters Example</title>
</head>
<body>
    <h2>Displaying Submitted Data</h2>

    <%
        // Accessing request parameters
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        // Display the request parameters
        if (username != null && age != null) {
            out.println("<p>Name: " + username + "</p>");
            out.println("<p>Age: " + age + "</p>");
        } else {
            out.println("<p>No data received!</p>");
        }
    %>
</body>
</html>
