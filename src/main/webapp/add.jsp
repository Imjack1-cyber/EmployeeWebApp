<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="de.msg4automotive.employees.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <title>Add or Update Employees</title>
</head>
<body>
    <h1>Here you can add or update employee information</h1>

    <%
        Employee employee = (Employee) request.getAttribute("employee");
    %>
    <form action="./employees" method="post">
        <table style="border-collapse: collapse; width: 20%;">
            <tr>
                <td><label>ID: </label></td>
                <td><input type="text" name="id" value="<%= employee != null ? employee.getId() : "" %>" /></td>
            </tr>
            <tr>
                <td><label>First Name: </label></td>
                <td><input type="text" name="first_name" value="<%= employee != null ? employee.getFirstName() : "" %>" /></td>
            </tr>
            <tr>
                <td><label>Last Name: </label></td>
                <td><input type="text" name="last_name" value="<%= employee != null ? employee.getLastName() : "" %>" /></td>
            </tr>
            <tr>
                <td><label>Age: </label></td>
                <td><input type="text" name="age" value="<%= employee != null ? employee.getAge() : 0 %>" /></td>
            </tr>
            <tr>
                <td><label>PLZ: </label></td>
                <td><input type="text" name="plz" value="<%= employee != null ? employee.getPlz() : "" %>" /></td>
            </tr>
            <tr>
                <td><label>City: </label></td>
                <td><input type="text" name="city" value="<%= employee != null ? employee.getCity() : "" %>" /></td>
            </tr>
            <tr>
                <td><label>Street Address: </label></td>
                <td><input type="text" name="street_address" value="<%= employee != null ? employee.getStreetAddress() : "" %>" /></td>
            </tr>
            <tr>
                <td><label>Started Working: </label></td>
                <td><input type="date" name="started_working" value="<%= employee != null ? employee.getStartedWorking() : "" %>" /></td>
            </tr>
        </table>
        <br>
        <div>
            <input type="submit" name="action" value="Submit" class="button" />
            <input type="submit" name="action" value="Update-Save" class="button" />
        </div>
    </form>

</body>
<footer class="footer">
    <div class="button-container">
        <a href="./" class="button">Employee Web App</a>
        <a href="./employees?action=ShowEmployees" class="button">Employees</a>
        <a href="http://localhost:8080/HelloWeb/" class="button" target="_blank">Hello Web</a>
        <a href="http://localhost:8080/HelloWeb/workhours.html" target="_blank" class="invisible">Work</a>
    </div>
</footer>
</html>
