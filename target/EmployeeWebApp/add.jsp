<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add or Update Employees</title>
<style>
.button.red {
	background-color: red; /* Red background for this button */
	border: 1px solid #333; /* Dark red border for contrast */
	padding: 3px 3px;
	font-size: 16px;
	color: #333;
	text-align: center;
	text-decoration: none; /* Remove underline */
	border-radius: 4px; /* Rounded corners */
	cursor: pointer;
	margin-left: 20px;
}

.button.red:hover {
	background-color: darkred; /* Dark red on hover for the red button */
}

.button-container {
	position: fixed; /* Fixed positioning */
	bottom: 20px; /* Distance from the bottom */
	display: flex; /* Use Flexbox */
}

.centered {
	text-align: center; /* Center text horizontally */
	vertical-align: middle; /* Center text vertically */
	height: 20px; /* Set a specific height for vertical centering */
	padding: 10px; /* Add some padding */
	border: 1px solid #ccc; /* Optional: Add borders */
}

.invisible {
	opacity: 0; /* Make it fully transparent */
	position: relative; /* Keep it in the flow */
	pointer-events: auto; /* Keep it interactive */
}

.button {
	padding: 3px 3px;
	font-size: 16px;
	color: black;
	background-color: #f8f9fa; /* Bootstrap primary color */
	text-align: center;
	text-decoration: none; /* Remove underline */
	border-radius: 4px; /* Rounded corners */
	border: 2px solid #ccc;
	cursor: pointer;
	margin-left: 20px;
}

.button:hover {
	background-color: #d3d3d3; /* Darker shade on hover */
}

input::placeholder {
	font-size: 12px; /* Smaller font size for the placeholder */
	color: #aaa; /* Placeholder color */
}
</style>
</head>
<body>
	<h1>Here you can add or update employee information</h1>
	<form action="./employees" method="post">
		<p>
			<label>ID: </label> <input type="text" name="id"
				value="<%=request.getParameter("id") != null ? request.getParameter("id") : ""%>"
				required />
			<!-- Populate ID -->
			<br>
			<br> <label>First Name: </label> <input type="text"
				name="firstName"
				value="<%=request.getParameter("firstName") != null ? request.getParameter("firstName") : ""%>"
				required />
			<!-- Populate First Name -->
			<br>
			<br> <label>Last Name: </label> <input type="text"
				name="lastName"
				value="<%=request.getParameter("lastName") != null ? request.getParameter("lastName") : ""%>"
				required />
			<!-- Populate Last Name -->
			<br>
			<br> <label>Age: </label> <input type="text" name="age"
				value="<%=request.getParameter("age") != null ? request.getParameter("age") : ""%>"
				required />
			<!-- Populate Age -->
			<br>
			<br> <label>PLZ: </label> <input type="text" name="plz"
				value="<%=request.getParameter("plz") != null ? request.getParameter("plz") : ""%>"
				required />
			<!-- Populate PLZ -->
			<br>
			<br> <label>City: </label> <input type="text" name="city"
				value="<%=request.getParameter("city") != null ? request.getParameter("city") : ""%>"
				required />
			<!-- Populate City -->
			<br>
			<br> <label>Street Address: </label> <input type="text"
				name="streetAddress"
				value="<%=request.getParameter("streetAddress") != null ? request.getParameter("streetAddress") : ""%>"
				required />
			<!-- Populate Street Address -->
			<br>
			<br> <label>Started Working (dd.MM.yyyy): </label> <input
				type="text" name="startedWorking"
				value="<%=request.getParameter("startedWorking") != null ? request.getParameter("startedWorking") : ""%>"
				required />
			<!-- Populate Started Working -->
			<br>
			<br> <input type="submit" name="action" value="Submit" />
			<!-- Submit button to add/update employee -->
		</p>
	</form>
</body>
<footer>

	<form action="./employees" method="get">
		<p>
			<input type="submit" value="Add Employee" class="button" />
			<!-- Button to redirect to add employee page -->
		</p>
	</form>

	<div class="button-container">
		<a href="./employees?action=ShowEmployees" class="button">Employees</a>
		<a href="./" class="button">Employee Web App</a> <a
			href="http://localhost:8080/HelloWeb/" class="button" target="_blank">Hello
			Web</a> <a href="http://localhost:8080/HelloWeb/workhours.html"
			target="_blank" class="invisible">Work</a>
	</div>
</footer>
</html>
