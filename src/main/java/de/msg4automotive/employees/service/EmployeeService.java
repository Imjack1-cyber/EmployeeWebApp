
package de.msg4automotive.employees.service; // Defines the package for the EmployeeService class.

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList; // Importing ArrayList to store a list of employees.
import java.util.List; // Importing List for handling collections of employees.

import org.apache.logging.log4j.LogManager; // Importing LogManager for logging.
import org.apache.logging.log4j.Logger; // Importing Logger interface for logging messages.

import de.msg4automotive.employees.database.ConnectionDatabase;
import de.msg4automotive.employees.model.Employee; // Importing the Employee model class.

public class EmployeeService { // This class contains business logic related to employees.

	private static final Logger LOG = LogManager.getLogger(EmployeeService.class); // Logger for logging messages.

	private List<Employee> employees = null; // A list to hold employee objects.

	// Method to get the list of employees.
	public List<Employee> getEmployees() {
		LOG.debug("getEmployees() method called, employees is null"); // Log that the list is null.
		employees = retrieveEmployees(); // Retrieve and initialize the employee list.

		return employees; // Return the list of employees.
	}

	// Method to delete an employee by their ID.
	public void deleteEmployee(int id) {
		LOG.debug("deleteEmployee() method called, id=" + id); // Log the deletion request.
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		connectionDatabase.deleteRow(id);
		LOG.debug("retrieveEmployees() method called, employees=" + employees); // Log the list of employees retrieved.
	}

	// Method to restore the employee list (reset it).
	public void restore() {
		LOG.debug("handleRestore() method called"); // Log the restore action.
		employees = null; // Set the employee list to null, indicating it needs to be reloaded.
	}

	public void addEmployee(int id, String firstName, String lastName, int age, int plz, String city,
			String streetAddress, LocalDate startedWorking) throws ParseException {
		LOG.debug("handleAddEmployee() method called");
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		connectionDatabase.insertRow(id, firstName, lastName, age, plz, city, streetAddress, startedWorking);
	}

	// Method to retrieve the initial list of employees.
	private List<Employee> retrieveEmployees() {
		LOG.debug("retrieveEmployees() method called"); // Log when retrieving employees.

		// Create a new ArrayList to hold employee objects.
		employees = new ArrayList<Employee>();
		// Adding some sample employees to the list.
//		employees.add(
//				new Employee(1, "Chuck", "Norris", 73, 12345, "Some City", "123 Main St", LocalDate.of(2020, 1, 15)));
//		employees.add(
//				new Employee(2, "Tony", "Stark", 45, 54321, "New York", "456 Stark Tower", LocalDate.of(2019, 4, 10)));
//		employees.add(new Employee(3, "Tom", "Cruise", 60, 98765, "Los Angeles", "789 Hollywood Blvd",
//				LocalDate.of(2021, 6, 22)));
//		employees.add(new Employee(4, "Bud", "Spencer", 85, 13579, "Rome", "101 Italian St", LocalDate.of(2018, 3, 5)));
//		employees.add(new Employee(5, "Bruce", "Lee", 32, 24680, "San Francisco", "202 Martial Arts Rd",
//				LocalDate.of(2022, 9, 12)));
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		employees = connectionDatabase.getEmployees();
		LOG.debug("retrieveEmployees() method called, employees=" + employees); // Log the list of employees retrieved.
		return employees; // Return the list of employees.
	}

	public void updateEmployee(int id, String firstName, String lastName, int age, int plz, String city,
			String streetAddress, LocalDate startedWorking) {
		LOG.debug("updateEmployee() method called, id=" + id);
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		connectionDatabase.updateRow(id, firstName, lastName, age, plz, city, streetAddress, startedWorking);

//		if (employeeToUpdate != null) {
//			employeeToUpdate.setId(id);
//			employeeToUpdate.setFirstName(firstName);
//			employeeToUpdate.setLastName(lastName);
//			employeeToUpdate.setAge(age);
//			employeeToUpdate.setPlz(plz);
//			employeeToUpdate.setCity(city);
//			employeeToUpdate.setStreetAddress(streetAddress);
//			employeeToUpdate.setStartedWorking(startedWorking);
//		} else {
//			LOG.error("Employee with ID " + id + " not found for update.");
//		}

	}

	public Employee readEmployee(int id) {
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		return connectionDatabase.getEmployee(id);
	}

}
