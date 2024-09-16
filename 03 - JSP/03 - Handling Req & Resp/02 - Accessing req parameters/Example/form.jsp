<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Submission Example</title>
</head>
<body>
    <h2>Enter Your Details</h2>

    <!-- Form to take user input -->
    <form action="result.jsp" method="get">
        Name: <input type="text" name="username"><br>
        Age: <input type="text" name="age"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
