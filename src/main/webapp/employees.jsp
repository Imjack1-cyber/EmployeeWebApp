<%@ page import="java.util.List" %>
<%@ page import="de.msg4automotive.employees.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <title>Employee List</title>
</head>
<body>

<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>

<table border="1" style="width: 100%">
    <thead style="background-color: lightgreen">
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
            int i = 0; // Counter for row coloring
            for (Employee employee : employees) {
        %>
        <tr <% if (i % 2 == 0) { %> style="background-color: lightgrey" <% } %>>
            <td class="centered"><%= employee.getId() %></td>
            <td class="centered"><%= employee.getFirstName() %></td>
            <td class="centered"><%= employee.getLastName() %></td>
            <td class="centered"><%= employee.getAge() %></td>
            <td class="centered"><%= employee.getPlz() %></td>
            <td class="centered"><%= employee.getCity() %></td>
            <td class="centered"><%= employee.getStreetAddress() %></td>
            <td class="centered"><%= employee.getStartedWorking() %></td>
            <td class="centered">
                <form action="./employees" method="get" class="button-form">
                    <input type="hidden" name="id" value="<%= employee.getId() %>" />
<%--                     <input type="hidden" name="firstName" value="<%= employee.getFirstName() %>" /> --%>
<%--                     <input type="hidden" name="lastName" value="<%= employee.getLastName() %>" /> --%>
<%--                     <input type="hidden" name="age" value="<%= employee.getAge() %>" /> --%>
<%--                     <input type="hidden" name="plz" value="<%= employee.getPlz() %>" /> --%>
<%--                     <input type="hidden" name="city" value="<%= employee.getCity() %>" /> --%>
<%--                     <input type="hidden" name="streetAddress" value="<%= employee.getStreetAddress() %>" /> --%>
<%--                     <input type="hidden" name="startedWorking" value="<%= employee.getStartedWorking() %>" /> --%>
                    <button type="submit" name="action" value="Update" class="button-icon">
            			<i class="bi bi-pencil update-icon"></i> <!-- Pencil icon -->
        			</button>
                </form>
                <form action="./employees" method="post" class="button-form">
       			 	<input type="hidden" name="id" value="<%= employee.getId() %>" />
        			<button type="submit" name="action" value="Delete Employee" class="button-icon">
            			<i class="bi bi-trash delete-icon"></i>
        			</button>
    			</form>
            </td>
        </tr>
        <%
                i++; // Increment the counter
            }
        %>
    </tbody>
</table>

<form action="./add.jsp" method="get" class="add-employee-form">
    <button type="submit" name="action" value="Add Employee" class="button-icon" style="font-size: 20px; padding: 10px;">
    <i class="bi bi-plus add-icon" style="font-size: 30px;"></i> Add Employee
	</button>
</form>

<script>
    function confirmReset() {
        return confirm("Are you sure you want to reset? This action will cause data loss.");
    }
</script>

<footer class ="footer">
    <div class="button-container">
        <a href="./" class="button">Employee Web App</a>
        <a href="http://localhost:8080/HelloWeb/" class="button" target="_blank">Hello Web</a>
        <a href="http://localhost:8080/HelloWeb/workhours.html" target="_blank" class="invisible">Work</a>
    </div>
</footer>
</body>
</html>
