<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlet/JSP Demo</title>
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
	<h1>Hello!</h1>
	<!-- A heading that displays "Hello!" on the page. -->
	<div>
		<a href="./employees?action=ShowEmployees" class="button">Employees</a>
		<a href="http://localhost:8080/HelloWeb/" class="button"
			target="_blank">Hello Web</a> <a
			href="http://localhost:8080/HelloWeb/workhours.html" target="_blank"
			class="invisible">Work</a>
	</div>
</body>
</html>
