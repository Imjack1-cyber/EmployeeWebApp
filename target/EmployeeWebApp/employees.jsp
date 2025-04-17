<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Optional CSS -->
    <style>
        .button.red {
            background-color: red;
            border: 1px solid #333;
            padding: 3px 3px;
            font-size: 16px;
            color: #333;
            text-align: center;
            text-decoration: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 20px;
        }

        .button.red:hover {
            background-color: darkred;
        }

        .button {
            padding: 3px 3px;
            font-size: 16px;
            color: black;
            background-color: #f8f9fa;
            text-align: center;
            text-decoration: none;
            border-radius: 4px;
            border: 2px solid #ccc;
            cursor: pointer;
            margin-left: 20px;
            margin-top: 10px;
        }

        .button:hover {
            background-color: #d3d3d3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: lightgreen;
        }

        tr:nth-child(even) {
            background-color: lightgrey;
        }
    </style>
</head>
<body>

<h1>Employee List</h1>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>PLZ</th>
            <th>City</th>
            <th>Street Address</th>
            <th>Started Working</th>
            <th>Update</th>
        </tr>
    </thead>
    <tbody>
        <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        for (Employee employee : employees) {
        %>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getFirstName() %></td>
            <td><%= employee.getLastName() %></td>
            <td><%= employee.getAge() %></td>
            <td><%= employee.getPLZ() %></td>
            <td><%= employee.getCity() %></td>
            <td><%= employee.getStreetAdress() %></td>
            <td><%= employee.getStartedWorking() %></td>
            <td>
                <form action="./add.jsp" method="get">
                    <input type="hidden" name="id" value="<%= employee.getId() %>" />
                    <input type="hidden" name="firstName" value="<%= employee.getFirstName() %>" />
                    <input type="hidden" name="lastName" value="<%= employee.getLastName() %>" />
                    <input type="hidden" name="age" value="<%= employee.getAge() %>" />
                    <input type="hidden" name="plz" value="<%= employee.getPLZ() %>" />
                    <input type="hidden" name="city" value="<%= employee.getCity() %>" />
                    <input type="hidden" name="streetAddress" value="<%= employee.getStreetAdress() %>" />
                    <input type="hidden" name="startedWorking" value="<%= employee.getStartedWorking() %>" />
                    <input type="submit" value="Update Employee Information" />
                </form>
            </td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>

<!-- Form to delete an employee by ID -->
<form action="./employees" method="get">
    <p>
        <label for="singleLine">ID: </label>
        <input type="text" name="id" id="singleLine" placeholder="Enter Employee ID" />
        <input type="submit" name="action" value="Delete Employee" />
    </p>
</form>

<!-- Button to add a new employee -->
<form action="./add.jsp" method="get">
    <p>
        <input type="submit" value="Add Employee" class="button" />
    </p>
</form>

<script>
    function confirmReset() {
        return confirm("Are you sure you want to reset? This action will cause data loss.");
    }
</script>

<!-- Form to restore deleted employees -->
<form action="./employees" method="post" onsubmit="return confirmReset();">
    <p>
        <input type="submit" name="action" value="Restore" class="button red" />
    </p>
</form>

<footer>
    <div class="button-container">
        <a href="./" class="button">Employee Web App</a>
        <a href="http://localhost:8080/HelloWeb/" class="button" target="_blank">Hello Web</a>
        <a href="http://localhost:8080/HelloWeb/workhours.html" target="_blank" class="invisible">Work</a>
    </div>
</footer>
</body>
</html>
