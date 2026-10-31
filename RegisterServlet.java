package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;





import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Step 1: Fetch all form fields from the request object
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		
		// Step 2: Hash the password using BCrypt before storing
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt(12));

        // Step 3: Create the User object (with hashed password, NOT plain password)
		
		 User user = new User(name, email,hashpw, address, role);

	        // Step 4: Save to database via DAO
	        UserDAOImpl userDAOImpl = new UserDAOImpl();
	        userDAOImpl.addUser(user);

	        // Step 5: Print confirmation message
	        PrintWriter out = response.getWriter();
	        out.println("Registration successful");
	}
}
