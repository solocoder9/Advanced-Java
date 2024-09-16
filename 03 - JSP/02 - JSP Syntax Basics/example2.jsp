<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Elements Example</title>
</head>
<body>

    <%!
        // Declaration block to declare variables and methods
        String name = "John";
        int age = 30;

        int square() {
            return age * age;
        }
    %>

    <%
        // Scriptlet block for control logic
        out.println("Name: " + name);
        out.println("Age: " + age);
        
        int number = 50;
        
        if (number > 100) {
            out.println("Number is greater than 100");
        } else {
            out.println("Number is smaller than 100");
        }
        
        // Loop to print numbers
        for (int i = 1; i <= 5; i++) {
            out.print(i + " ");
        }
    %>

    <!-- Expression to output values directly -->
    <p>Name: <%= name %></p>
    <p>Age: <%= age %></p>
    <p>Square of Age: <%= square() %></p>

</body>
</html>
