package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get username and password entered by the user
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Step 2: Fetch the user record (with hashed password) from the database
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        User user = userDAOImpl.getUserByUsername(name);
        
        PrintWriter out = response.getWriter();
        
        if (user == null) {
            out.println("username does not exist");
            return;
        }

        String dbPassword = user.getPassword();   // hashed password stored in DB

        // Step 3: Compare entered password with hashed password using BCrypt
        if (dbPassword != null && BCrypt.checkpw(password, dbPassword)) {
            // Establish session
            jakarta.servlet.http.HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("address", user.getAddress());
            
            out.println("login successful");
        } else {
            out.println("incorrect password");
        }
    }

}
