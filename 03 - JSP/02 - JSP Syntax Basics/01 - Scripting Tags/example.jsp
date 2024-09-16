<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Scripting Tags Example</title>
</head>
<body>
	<h1>JSP Scripting Tags Example</h1>

    <!-- Declaration Tag -->
    <%!
        // Declaration Tag: Used to declare variables and methods
        private String getGreeting() {
            return "Hello, welcome to JSP!";
        }
    %>

    <!-- Scriptlet Tag -->
    <% 
        // Scriptlet Tag: Used to write Java code that gets executed when the page is requested
        String name = "Charlie!"; 
        String message = getGreeting(); // Calling the method declared in the declaration tag
    %>

    <!-- Expression Tag -->
    <p>
        <!-- Expression Tag: Used to output data directly to the client -->
        Welcome, <%= name %>! <br>
        <%= message %>
    </p>
</body>
</html>