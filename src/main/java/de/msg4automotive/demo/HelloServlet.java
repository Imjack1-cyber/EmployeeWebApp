package de.msg4automotive.demo; // This defines the package for the servlet, organizing it within the application.

import java.io.IOException; // Importing IOException to handle input/output errors.

import javax.servlet.ServletConfig; // Importing ServletConfig for servlet configuration.
import javax.servlet.ServletException; // Importing ServletException for handling servlet errors.
import javax.servlet.annotation.WebServlet; // Importing the WebServlet annotation for mapping URLs to the servlet.
import javax.servlet.http.HttpServlet; // Importing the HttpServlet class to create an HTTP servlet.
import javax.servlet.http.HttpServletRequest; // Importing HttpServletRequest to handle HTTP requests.
import javax.servlet.http.HttpServletResponse; // Importing HttpServletResponse to handle HTTP responses.

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HalloWeltServlet") // This annotation maps the servlet to the URL "/HalloWeltServlet".
public class HelloServlet extends HttpServlet { // This class extends HttpServlet to handle web requests.
	private static final long serialVersionUID = 1L; // A unique ID for serialization.

	/**
	 * Default constructor for the servlet.
	 */
	public HelloServlet() {
		super(); // Calls the parent class constructor.
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initializes the servlet when it's created.
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * Handles GET requests sent to the servlet.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// This method sends a response back to the client.
		response.getWriter().append("Served at: ") // Starts writing the response.
				.append(request.getContextPath()) // Appends the context path of the application.
				.append(" - Hello!"); // Appends a greeting message.
	}

	/**
	 * Handles POST requests sent to the servlet.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Calls doGet to handle the POST request the same way as GET.
		doGet(request, response);
	}
}
