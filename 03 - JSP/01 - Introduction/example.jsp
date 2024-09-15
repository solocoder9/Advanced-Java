<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to JSP</h3>

    <%
        // Declaring a string variable
        String message = "Hello, JSP!";
        // Calculating the length of the string
        int length = message.length();
    %>

    <!-- Display the string and its length -->
    <p>Message: <%= message %></p>
    <p>Length of message: <%= length %></p>
</body>
</html>