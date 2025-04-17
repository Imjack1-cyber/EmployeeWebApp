package de.msg4automotive.employees.controller; // Defines the package for this servlet, organizing it in the application.

import java.io.IOException; // Importing IOException to handle input/output errors.
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List; // Importing List to manage collections of employees.

import javax.servlet.RequestDispatcher; // Importing RequestDispatcher to forward requests.
import javax.servlet.ServletException; // Importing ServletException for handling servlet-related errors.
import javax.servlet.annotation.WebServlet; // Importing WebServlet annotation for mapping URLs to this servlet.
import javax.servlet.http.HttpServlet; // Importing HttpServlet class to create an HTTP servlet.
import javax.servlet.http.HttpServletRequest; // Importing HttpServletRequest for handling HTTP requests.
import javax.servlet.http.HttpServletResponse; // Importing HttpServletResponse for handling HTTP responses.

import org.apache.logging.log4j.LogManager; // Importing LogManager for logging.
import org.apache.logging.log4j.Logger; // Importing Logger interface for logging messages.

import de.msg4automotive.employees.database.ConnectionDatabase;
import de.msg4automotive.employees.model.Employee; // Importing Employee model class.
import de.msg4automotive.employees.service.EmployeeService; // Importing EmployeeService for business logic.

// Mapping this servlet to the URL pattern "/employees".
@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet { // This class extends HttpServlet to handle web requests.

	private static final long serialVersionUID = 1L; // A unique ID for serialization.
	private static final Logger LOG = LogManager.getLogger(EmployeeServlet.class); // Logger for logging messages.

	private EmployeeService employeeService = null; // Declare an EmployeeService instance.

	// This method is called when the servlet is initialized.
	public void init() {
		LOG.debug("init() method called"); // Log the initialization.
		employeeService = new EmployeeService(); // Instantiate the EmployeeService.
	}

	// Handles GET requests.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		LOG.debug("doGet() method called"); // Log the GET request.
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Process the request.
	}

	// Handles POST requests.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		LOG.debug("doPost() method called"); // Log the POST request.
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Process the request.
	}

	// Method to process incoming requests.
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		LOG.debug("processRequest() method called"); // Log when processing starts.

		// Get the action parameter from the request.
		String action = request.getParameter("action");
		if (action == null) {
			action = "default"; // or handle it appropriately
		}

		LOG.debug("action: " + action); // Log the action received.

		// Switch case to handle different actions.
		switch (action) {
		case "ShowEmployees":
			handleShowEmployees(request, response); // Show the list of employees.
			break;

		case "Delete Employee":
			handleDeleteEmployee(request, response); // Delete an employee.
			break;

		case "Restore":
			handleRestore(request, response); // Restore deleted employees.
			break;

		case "Update":
			handleUpdate(request, response);
			LOG.debug("Case: 'Update'");
			break;

		case "Update-Save":
			handleUpdateSave(request, response);
			LOG.debug("Case: 'Update'");
			break;

		case "Submit":
			handleSubmit(request, response);
			break;

		default:
			LOG.error("Invalid action: " + action); // Log an error for an invalid action.
			break;
		}
	}

	private void handleUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("handleUpdate() method called");
		int id = Integer.parseInt(request.getParameter("id"));
		LOG.debug("ID: " + id);
		Employee employee = employeeService.readEmployee(id);

		request.setAttribute("employee", employee); // Set the employee list as a request attribute.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp"); // Get the dispatcher for the
		dispatcher.forward(request, response); // Forward the request to the JSP.
	}

	private void handleUpdateSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("handleUpdate() method called");
		int id = Integer.parseInt(request.getParameter("id"));
		LOG.debug("ID: " + id);
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		int plz = Integer.parseInt(request.getParameter("plz"));
		String city = request.getParameter("city");
		String streetAddress = request.getParameter("street_address");
		String startedWorkingStr = request.getParameter("started_working");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LOG.debug("DateFormatter initialized");

		LocalDate startedWorking = null;

		try {
			startedWorking = LocalDate.parse(startedWorkingStr, formatter);
			LOG.debug("Parsed startedWorking: " + startedWorking);
		} catch (DateTimeParseException e) {
			LOG.error("Invalid date format for startedWorking: " + startedWorkingStr, e);
			// Handle the error (e.g., set an error message in the request)
		}

		employeeService.updateEmployee(id, firstName, lastName, age, plz, city, streetAddress, startedWorking);
		handleShowEmployees(request, response);
	}

	// Handles showing the list of employees.
	private void handleShowEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("handleShowEmployees() method called"); // Log the handling of employee showing.
		List<Employee> employees = employeeService.getEmployees(); // Get the list of employees.
		LOG.debug("employees: " + employees); // Log the list of employees.
		request.setAttribute("employees", employees); // Set the employee list as a request attribute.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employees.jsp"); // Get the dispatcher for the
																						// JSP.
		dispatcher.forward(request, response); // Forward the request to the JSP.
	}

	// Handles the deletion of an employee.
	private void handleDeleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("handleDeleteEmployee() method called"); // Log the handling of employee deletion.
		int id = Integer.parseInt(request.getParameter("id")); // Get the employee ID from the request.
		LOG.debug("id: " + id); // Log the ID received.
		employeeService.deleteEmployee(id); // Call the service to delete the employee.
		handleShowEmployees(request, response); // Show the updated list of employees.
	}

	// Handles restoring deleted employees.
	private void handleRestore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("handleRestore() method called"); // Log the handling of the restore action.
		employeeService.restore(); // Call the service to restore employees.
		handleShowEmployees(request, response); // Show the updated list of employees.
	}

	private void handleSubmit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		LOG.debug("handleSubmit() method called");

		int id = Integer.parseInt(request.getParameter("id"));
		LOG.debug("ID: " + id);
		String firstName = request.getParameter("first_name");
		LOG.debug("first_name: " + firstName);
		String lastName = request.getParameter("last_name");
		LOG.debug("last_name: " + lastName);
		int age = Integer.parseInt(request.getParameter("age"));
		LOG.debug("age: " + age);
		int plz = Integer.parseInt(request.getParameter("plz"));
		LOG.debug("plz: " + plz);
		String city = request.getParameter("city");
		LOG.debug("city: " + city);
		String streetAddress = request.getParameter("street_address");
		LOG.debug("street_address: " + streetAddress);
		String startedWorkingStr = request.getParameter("started_working");
		LOG.debug("started_working: " + startedWorkingStr);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LOG.debug("DateFormatter initialized");

		LocalDate startedWorking = null;

		try {
			startedWorking = LocalDate.parse(startedWorkingStr, formatter);
			LOG.debug("Parsed startedWorking: " + startedWorking);
		} catch (DateTimeParseException e) {
			LOG.error("Invalid date format for startedWorking: " + startedWorkingStr, e);
			// Handle the error (e.g., set an error message in the request)
		}

		LOG.debug("Adding/updating employee with ID: " + id);

		// Check if the employee exists for updating; if not, add a new employee
		if (employeeService.getEmployees().stream().anyMatch(e -> e.getId() == id)) {
			// Update existing employee logic (if applicable)
			// Update logic can be added in the service layer if necessary
			// employeeService.updateEmployee(id, firstName, lastName, age, plz, city,
			// streetAddress, startedWorking);
		} else {
			ConnectionDatabase connectionDatabase = new ConnectionDatabase();
			connectionDatabase.insertRow(id, firstName, lastName, age, plz, city, streetAddress, startedWorking);
//		}

			handleShowEmployees(request, response);
		}
	}
}