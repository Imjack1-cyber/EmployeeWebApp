package de.msg4automotive.employees.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.msg4automotive.employees.model.Employee;

public class ConnectionDatabase {
	private static final Logger LOG = LogManager.getLogger(ConnectionDatabase.class);

	private static final String URL = "jdbc:mysql://localhost:3306/employeewebapp?useUnicode=true&characterEncoding=utf8";
	private static final String USER = "root"; // Adjust based on your MySQL credentials
	private static final String PASS = ""; // Adjust based on your MySQL credentials

	// Method to establish a database connection
	private static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			LOG.debug("Database connection established successfully.");
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error("Database connection failed: " + e.getMessage());
		}
		if (connection == null) {
			LOG.error("Failed to establish connection to the database.");
		}
		return connection;
	}

	public List<Employee> getEmployees() {
		LOG.debug("getEmployees() method called");
		Connection con = getConnection();
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employees";

		if (con != null) {
			try (PreparedStatement preparedStatement = con.prepareStatement(sql);
					ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					Employee employee = new Employee();
					employee.setId(resultSet.getInt("id"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setAge(resultSet.getInt("age"));
					employee.setPlz(resultSet.getInt("plz"));
					employee.setCity(resultSet.getString("city"));
					employee.setStreetAddress(resultSet.getString("street_address"));
					employee.setStartedWorking(resultSet.getDate("started_working").toLocalDate());
					employees.add(employee);
				}
			} catch (SQLException e) {
				LOG.error("Error retrieving employees: ", e);
			} finally {
				try {
					con.close(); // Schließe die Verbindung
				} catch (SQLException e) {
					LOG.error("Error closing connection: ", e);
				}
			}
		} else {
			LOG.error("Connection is null, cannot retrieve employees.");
		}
		return employees;
	}

	public Employee getEmployee(int id) {
		LOG.debug("getEmployee() method called");
		Connection con = getConnection();
		Employee employee = new Employee();

		String sql = "SELECT * FROM employees WHERE id = " + id;

		if (con != null) {
			try (PreparedStatement preparedStatement = con.prepareStatement(sql);
					ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					employee.setId(resultSet.getInt("id"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setAge(resultSet.getInt("age"));
					employee.setPlz(resultSet.getInt("plz"));
					employee.setCity(resultSet.getString("city"));
					employee.setStreetAddress(resultSet.getString("street_address"));
					employee.setStartedWorking(resultSet.getDate("started_working").toLocalDate());
				}
			} catch (SQLException e) {
				LOG.error("Error retrieving employees: ", e);
			} finally {
				try {
					con.close(); // Schließe die Verbindung
				} catch (SQLException e) {
					LOG.error("Error closing connection: ", e);
				}
			}
		} else {
			LOG.error("Connection is null, cannot retrieve employees.");
		}
		LOG.debug("Employee =" + employee);
		return employee;
	}

	// Insert a new row into the specified table
	public void insertRow(int id, String firstName, String lastName, int age, int plz, String city,
			String streetAddress, LocalDate startedWorking) {
		Connection con = getConnection();
		String sqlDate = (startedWorking != null) ? startedWorking.toString() : null; // Use ISO format

		String query = "INSERT INTO employees"
				+ " (`first_name`, `last_name`, `age`, `plz`, `city`, `street_address`, `started_working`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		LOG.debug("Query=" + query);

		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setInt(3, age);
			preparedStatement.setInt(4, plz);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, streetAddress);
			preparedStatement.setString(7, sqlDate); // Set the SQL date
			preparedStatement.executeUpdate();
			System.out.println("New row added: " + firstName + " " + lastName);
		} catch (SQLException e) {
			System.out.println("Error adding row: " + e.getMessage());
		}
	}

	// Update an existing row
	public void updateRow(int id, String firstName, String lastName, int age, int plz, String city,
			String streetAddress, LocalDate startedWorking) {
		Connection con = getConnection();
		String query = "UPDATE employees SET `first_name` = '" + firstName + "', `last_name` = '" + lastName
				+ "', `age` = " + age + ", `plz` = '" + plz + "', `city` = '" + city + "', `street_address` = '"
				+ streetAddress + "', `started_working` = '" + startedWorking + "' WHERE ID = " + id;
		LOG.debug("Query= " + query);
		try (Statement stm = con.createStatement()) {
			stm.executeUpdate(query);
			System.out.println("Row with ID " + id + " updated.");
		} catch (SQLException e) {
			System.err.println("Error updating row: " + e.getMessage());
		}
	}

	// Delete a row from the specified table
	public void deleteRow(int id) {
		Connection con = getConnection();
		String query = "DELETE FROM  employees  WHERE ID = " + id;
		try (Statement stm = con.createStatement()) {
			stm.executeUpdate(query);
			System.out.println("Row with ID " + id + " deleted.");
		} catch (SQLException e) {
			System.out.println("Error deleting row: " + e.getMessage());
		}
	}

	// Add a new column to the specified table
//	private static void addColumn(Connection con, String tableName, String columnName, String columnType) {
//		String query = "ALTER TABLE " + tableName + " ADD `" + columnName + "` " + columnType;
//		try (Statement stm = con.createStatement()) {
//			stm.executeUpdate(query);
//			System.out.println("Column '" + columnName + "' added.");
//		} catch (SQLException e) {
//			System.out.println("Error adding column: " + e.getMessage());
//		}
//	}

	// Drop a column from the specified table
//	private static void dropColumn(Connection con, String tableName, String columnName) {
//		String query = "ALTER TABLE " + tableName + " DROP COLUMN `" + columnName + "`";
//		try (Statement stm = con.createStatement()) {
//			stm.executeUpdate(query);
//			System.out.println("Column '" + columnName + "' dropped.");
//		} catch (SQLException e) {
//			System.out.println("Error dropping column: " + e.getMessage());
//		}
//	}
}
